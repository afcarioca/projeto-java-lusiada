<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="../estatico/inicio.jsp" />
<title>Dados do Aluno</title>
</head>
<body>
	<c:if test="${not empty usuarioLogado }">
		<c:import url="../estatico/cabecalho-perfil-aluno.jsp" />
	</c:if>
	<c:if test="${not empty administradorLogado }">
		<c:import url="../estatico/cabecalho-administrador-perfil-aluno.jsp" />
	</c:if>
	<div class="container">
		<table class="table table-bordered">
			<tbody>
				<tr>
					<td>Nome</td>
					<td>${aluno.nome}</td>
				</tr>
				<tr>
					<td>Número de Aluno</td>
					<td>${aluno.numeroDeAluno}</td>
				</tr>
				<tr>
					<td>Curso</td>
					<td>${aluno.curso}</td>
				</tr>
				<tr>
					<td>Telemóvel</td>
					<td>${aluno.telemovel}</td>
				</tr>
				<tr>
					<td>Localidade</td>
					<td>${aluno.localidade}</td>
				</tr>
				<tr>
					<td>Idade</td>
					<td>${idade }</td>
				</tr>
				<tr>
					<td>Problemas de Saúde</td>
					<td>${aluno.saude }</td>
				</tr>
				<tr>
					<td>Deslocamento</td>
					<td>${aluno.deslocamento }</td>
				</tr>
				<tr>
					<td>Observacoes</td>
					<td>${aluno.observacoes }</td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>