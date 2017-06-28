<jsp:directive.page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" />
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8"/>
  <title>Connexion</title>
  <link media="all" rel="stylesheet" href="<%=request.getContextPath()%>/theme/style.css" type="text/css"/>
</head>
<body>

<div id="page">

	<header>
		<h1>Connexion</h1>
	</header>


	<div id="contenu">
	
	<jsp:scriptlet> 
		String utilisateurId = request.getParameter("identifiant");
		if (utilisateurId==null) utilisateurId="";
		String utilisateurMdP = request.getParameter("motdepasse");
		if (utilisateurMdP==null) utilisateurMdP="";
		String messageErreur = (String)request.getAttribute("messageErreur");
		if (messageErreur==null) messageErreur="";
	</jsp:scriptlet>
	
		<form class="connexion" action="<%= response.encodeURL(request.getContextPath()+"/ValiderConnexion")%>" method="post">
		<div class="bloc_identifiant">
			<label for="identifiant">Identifiant</label>
			<input class="champtexte" type="text" id="identifiant" name="identifiant" value="<%=utilisateurId%>"/>
		</div>
		<div class="bloc_motdepasse">
			<label for="motdepasse">Mot de passe</label>
			<input class="champtexte" type="text"  id="motdepasse" name="motdepasse" value="<%=utilisateurMdP%>"/>
		</div>
		<div class="bloc_connexion">
			<input type="submit" id="seconnecter" value="Se connecter" />
		</div>
		</form>
		
		<% if (!"".equals(messageErreur)) { %>
		<div><p><%=messageErreur%></p></div>
		<% } %>

 	</div> 	
	
</div>
</body>
</html>
