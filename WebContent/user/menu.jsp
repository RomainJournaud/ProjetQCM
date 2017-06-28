<jsp:directive.page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Menu User</title>
<link media="all" rel="stylesheet" href="<%=request.getContextPath()%>/theme/basique/style.css" type="text/css"/>
</head>
<body>
<div id="page">

	<div id="entete">
		<h1>Menu User</h1>
	</div>


	<div id="contenu">
	<jsp:useBean id="UserConnecte" class="fr.eni.projet.bean.User" scope="session" />
	<p>
	Bonjour
	<jsp:getProperty property="prenom" name="UserConnecte"/>
	<jsp:getProperty property="nom" name="UserConnecte"/>	
	</p>
	</div>
	
		
</div>

</body>
</html>