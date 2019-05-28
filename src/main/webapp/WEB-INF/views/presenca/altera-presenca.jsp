<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="/webjars/bootstrap/4.3.1/css/bootstrap.css" />
<title>Insert title here</title>
</head>
<body>

	<form action="/alteraPresenca?id=${presenca.id}" method="post">
		 Presença : <input type="text" name="presenca" />
		<button type="submit">Enviar</button>
	</form>
</body>
</html>