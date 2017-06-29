<jsp:directive.page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" />
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8"/>
<title>Menu User</title>
<link media="all" rel="stylesheet" href="<%=request.getContextPath()%>/theme/style.css" type="text/css"/>
</head>
<body>
<div id="page">

	<div id="entete">
		<h1>Menu User</h1>
	</div>


	<div id="contenu">
	<jsp:useBean id="userConnecte" class="fr.eni.projet.bean.User" scope="session" />
	<p>
	Bonjour
	<jsp:getProperty property="prenom" name="userConnecte"/>
	<jsp:getProperty property="nom" name="userConnecte"/>	
	</p>
	</div>
	
	<jsp:directive.include file="/pieddepage.jspf" />	
</div>

</body>
</html>