<jsp:directive.page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" />
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8"/>
  <title>Erreur</title>
  <link media="all" rel="stylesheet" href="<%=request.getContextPath()%>/theme/basique/style.css" type="text/css"/>
</head>
<body>

<div id="page">

	<div id="entete">
		<h1>Erreur</h1>
	</div>

	<div id="contenu">
	
	<div class="erreur">
		<h2>Erreur</h2>
		<jsp:useBean id="erreur" class="java.lang.Exception" type="java.lang.Exception" scope="request" />
		<p>Une erreur s'est produite : <jsp:getProperty name="erreur" property="message" /></p>
	</div>
 	</div>


	
</div>
</body>
</html>