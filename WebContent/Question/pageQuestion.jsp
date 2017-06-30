<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="page">
		<div id="entete">
			<h1>Question n°</h1>
			
		</div>
		<div id="contenu">
			<jsp:useBean id="questionEnCours" class="fr.eni.projet.bean.Question" scope="session" />
			<jsp:useBean id="Reponses" class="fr.eni.projet.bean.Reponse" scope="session" />
			<jsp:getProperty property="enonce" name="questionEnCours"/>
			<jsp:getProperty property="listeReponse" name="questionEnCours"/>
			
		</div>
	</div>
</body>
</html>