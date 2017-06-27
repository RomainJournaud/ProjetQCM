package fr.eni.projet.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Deconnecter extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		deconnecter(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		deconnecter(request, response);
	}

	protected void deconnecter(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Est-ce qu'une session existe ?
		HttpSession session = request.getSession(false);
		// Si oui, on l'invalide 
		if (session != null) { 
			session.invalidate();
		}
		// Renvoyer l'utilisateur sur la page d'acceuil (= ressource par défaut)
		response.sendRedirect(response.encodeRedirectURL(request.getContextPath()+"/"));
	}
}
