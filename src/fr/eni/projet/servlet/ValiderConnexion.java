package fr.eni.projet.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projet.bean.User;
import fr.eni.projet.dal.UserDAO;

public class ValiderConnexion extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
	static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		valider(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		valider(request, response);
	}

	protected void valider(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher;
		User userConnecte = null;

		// Si l'animateur est déjà connecté, on redirige vers le menu animateur
		userConnecte = (User)request.getSession().getAttribute("userConnecte");
		if (userConnecte!=null) {
			redirectionMenuUser(request, response);
			return;
		}		
		
		// Récupération des informations saisies dans le formulaire
		String identifiant = request.getParameter("identifiant");
		String motdepasse = request.getParameter("mdp");

		// Controle des informations :
		// si tous les champs ne sont pas renseignés, revenir sur la page du formulaire
		if (   (identifiant == null) || (identifiant.length() == 0) 
			|| (motdepasse == null) || (motdepasse.length() == 0)) {
			
			String message = "Les champs Identifiant et Mot de passe sont obligatoires";
			request.setAttribute("messageErreur", message);
			dispatcher = getServletContext().getNamedDispatcher("AccesUserPage");
			dispatcher.forward(request, response);
			return;
		}
		

		try {
			// Valider l'identification par rapport aux informations de la base
			userConnecte = UserDAO.rechercher(new User(-1, null, null, null, identifiant, motdepasse, 0));
		} catch (SQLException sqle) {
			// Placer l'objet représentant l'exception dans le contexte de requete
			request.setAttribute("erreur", sqle);
			// Passer la main à la page de présentation des erreurs
			dispatcher = getServletContext().getRequestDispatcher(response.encodeURL("/erreur/erreur.jsp"));
			dispatcher.forward(request, response);
			return;
		}		
			
		// Si l'authenification est réussie...
		if (userConnecte != null) {
			// Placer le bean dans le contexte de session
			request.getSession().setAttribute("userConnecte", userConnecte);
			// Présenter la réponse
			redirectionMenuUser(request, response);
			return;
		}
		// ...sinon
		else {
			// Retourner à l'écran d'identification avec un message d'erreur fonctionnel			
			String message = "Identifiant ou mot de passe incorrect";
			request.setAttribute("messageErreur", message);
			dispatcher = getServletContext().getNamedDispatcher("AccesUserPage");
			dispatcher.forward(request, response);
			}
	}
	
	protected void redirectionMenuUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// En fonction de la méthode de redirection utilisée (forward ou sendRedirect()),
		// l'utilisateur pourra voir ou non l'URL de la ressource : 
		
		// L'utilisation d'un forward masque la nouvelle ressource demandée (car tout 
		// se passe au sein du serveur d'application) 
		RequestDispatcher dispatcher = request.getRequestDispatcher(response.encodeURL("/user/menu.jsp"));
		dispatcher.forward(request, response);
		
		// L'utilisation d'un sendRedirect expose le nom de la page à l'utilisateur (car
		// une reponse 302 est renvoyée au navigateur qui doit obligatoirement connaitre l'URL
		// de la ressource pour refaire une requête HTTP)
//		response.sendRedirect(response.encodeRedirectURL(request.getContextPath()+"/animateur/menu.jsp"));
	}
}






