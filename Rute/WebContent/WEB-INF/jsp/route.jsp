<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Fra https://purecss.io/ -->
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<title>PathFinder</title>
</head>
<body>
	<h2>Finn raskaste veg</h2>
	<p>Legg inn frå og til lokasjon.</p>

	<form method="post" class="pure-form pure-form-aligned">
		<fieldset>
			<select name="from">

				<c:forEach var="node" items="${nodes}" >
				<option value="${node.name}">${node.name}</option>
			</c:forEach>
			</select> 
			Til
			<select name="to">

				<c:forEach var="node" items="${nodes}" >
				<option value="${node.name}">${node.name}</option>
			</c:forEach>
			</select> 
			<div class="pure-controls">
				<button id="knapp" type="submit"
					class="pure-button pure-button-primary">Hent</button>

			</div>
		</fieldset>
		
	</form>

${output}

</body>

</html>
