package fr.eni.projet.servlet;

import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.*;

import fr.eni.projet.bean.*;
import fr.eni.projet.dal.*;

public class ValiderAccesAnimateur extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
	static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		valider(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		valider(request, response);
	}

	protected void valider(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher;
		User animateurConnecte = null;

		// Si l'animateur est déjà connecté, on redirige vers le menu animateur
		animateurConnecte = (User)request.getSession().getAttribute("animateurConnecte");
		if (animateurConnecte!=null) {
			redirectionMenuAnimateur(request, response);
			return;
		}		
		
		// Récupération des informations saisies dans le formulaire
		String mail = request.getParameter("identifiant");
		String motdepasse = request.getParameter("motdepasse");

		// Controle des informations :
		// si tous les champs ne sont pas renseignés, revenir sur la page du formulaire
		if (   (mail == null) || (mail.length() == 0) 
			|| (motdepasse == null) || (motdepasse.length() == 0)) {
			
			String message = "Les champs Identifiant et Mot de passe sont obligatoires";
			request.setAttribute("messageErreur", message);
			dispatcher = getServletContext().getNamedDispatcher("AccesAnimateurPage");
			dispatcher.forward(request, response);
			return;
		}
		

		try {
			// Valider l'identification par rapport aux informations de la base
			animateurConnecte = UserDAO.rechercher(new User(-1, null, null, motdepasse, mail));
		} catch (SQLException sqle) {
			// Placer l'objet représentant l'exception dans le contexte de requete
			request.setAttribute("erreur", sqle);
			// Passer la main à la page de présentation des erreurs
			dispatcher = getServletContext().getRequestDispatcher(response.encodeURL("/erreur/erreur.jsp"));
			dispatcher.forward(request, response);
			return;
		}		
			
		// Si l'authenification est réussie...
		if (animateurConnecte != null) {
			// Placer le bean dans le contexte de session
			request.getSession().setAttribute("animateurConnecte", animateurConnecte);
			// Présenter la réponse
			redirectionMenuAnimateur(request, response);
			return;
		}
		// ...sinon
		else {
			// Retourner à l'écran d'identification avec un message d'erreur fonctionnel			
			String message = "Identifiant ou mot de passe incorrect";
			request.setAttribute("messageErreur", message);
			dispatcher = getServletContext().getNamedDispatcher("AccesAnimateurPage");
			dispatcher.forward(request, response);
			}
	}
	
	protected void redirectionMenuAnimateur(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// En fonction de la méthode de redirection utilisée (forward ou sendRedirect()),
		// l'utilisateur pourra voir ou non l'URL de la ressource : 
		
		// L'utilisation d'un forward masque la nouvelle ressource demandée (car tout 
		// se passe au sein du serveur d'application) 
		RequestDispatcher dispatcher = request.getRequestDispatcher(response.encodeURL("/animateur/menu.jsp"));
		dispatcher.forward(request, response);
		
		// L'utilisation d'un sendRedirect expose le nom de la page à l'utilisateur (car
		// une reponse 302 est renvoyée au navigateur qui doit obligatoirement connaitre l'URL
		// de la ressource pour refaire une requête HTTP)
//		response.sendRedirect(response.encodeRedirectURL(request.getContextPath()+"/animateur/menu.jsp"));
	}
}






