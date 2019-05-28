<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="/webjars/bootstrap/4.3.1/css/bootstrap.css" />
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<c:if test="${not empty usuarioLogado && not empty AdministradorLogado  }">
			<c:import url="../erros/jahexiste.jsp"/>
		</c:if>
		<c:if test="${not empty usuarioLogado && empty AdministradorLogado }">
			<c:import url="cabecalho.jsp" />

		</c:if>

		<c:if test="${not empty AdministradorLogado && empty usuarioLogado }">
			<c:import url="../usuario/cabecalho-Administrador.jsp" />
			<div class="alert alert-primary" role="alert">
				<p>Seja Bem-Vindo ${AdministradorLogado.nome }!</p>
			</div>
			<table class="table table-bordered">
				<thead>
					<th>#</th>
					<th>Nome</th>
					<th>#</th>
					<th>#</th>
				</thead>
				<tbody>
					<c:forEach items="${usuarios }" var="usuario">
						<tr>
							<td scope="row">#</td>
							<td>${usuario.nome }</td>
							<td><a class="btn btn-primary"
								href="/alteraUsuario?id=${usuario.id }">Altera</a></td>
							<td><a class="btn btn-primary"
								href="/removeUsuario?id=${usuario.id }"> Deletar</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>
</body>
</html>