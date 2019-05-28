<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<a class="navbar-brand" href="/lista/praxe">Praxe</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item"><a class="nav-link"
						href="/formPresencaAluno?id=${aluno.id }">Marcar Presença </a></li>
					<li class="nav-item"><a class="nav-link" href="#">Cursos</a></li>
				</ul>
				<form class="form-inline my-2 my-lg-0"
					action="/presenca/pesquisa?id=${aluno.id }" method="post">
					<input class="form-control mr-sm-2" type="search"
						placeholder="Search" aria-label="Search" name="periodo">
					<button class="btn btn-primary my-2 my-sm-0" type="submit">Search</button>
				</form>

				<c:if test="${not empty AdministradorLogado  }">
					<a class="nav-link" href="/sairAdministrador">Sair do Sistema</a>
				</c:if>

				<c:if test="${not empty usuarioLogado  }">
					<a class="nav-link" href="/sair">Sair do Sistema</a>
				</c:if>
			</div>
		</nav>
		<table class="table table-bordered">
			<thead>
				<th>Presenças de ${aluno.nome }</th>
				<th>Data</th>
				<th>Hora</th>
				<th>#</th>
				<th>#</th>
			</thead>
			<tbody>
				<c:forEach items="${presencas }" var="presenca">
					<tr>
						<td>${presenca.periodo }</td>
						<td><fmt:formatDate pattern="dd/MM/yyyy"
								value="${presenca.dataPresenca }" /></td>
						<td><fmt:formatDate pattern="HH:mm:ss"
								value="${presenca.dataPresenca }" /></td>
						<td><a class="btn btn-primary"
							href="/alteraPresenca?id=${presenca.id }">Altera</a></td>
						<td><a class="btn btn-primary"
							href="/removePresenca?id=${presenca.id }"> Deletar</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>