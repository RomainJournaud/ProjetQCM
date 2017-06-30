<jsp:directive.page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" />
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8"/>
<title>Insert title here</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

<script  src="https://code.jquery.com/jquery-3.2.1.min.js"  integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="  crossorigin="anonymous"></script>
<script src="js/creaTest.js"></script>
</head>
<body>

<form method="POST" id="formCreTest" data-nbquest="0">
	<div class="form-group">
	  <label for="nomTest">Nom du test:</label>
	  <input type="text" class="form-control" id="nomTest" name="nom">
	</div>
	<div class="form-group">
	  <label for="dureeTest">Durée du test:</label>
	  <input type="time" class="form-control" id="dureeTest" name="duree">
	</div>
	<div class="form-group">
	  <label for="seuilTest">Seuil de réussite du test:</label>
	  <input type="number" class="form-control" id="seuilTest" name="seuil">%
	</div>
	<button type="button" class="btn btn-primary btn-lg btn-block" id="ajoutQuestion">Ajouter une question</button>
	<button type="submit" class="btn btn-primary">Valider le test</button>
</form>

</body>
</html>