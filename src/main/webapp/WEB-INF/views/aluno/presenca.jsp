<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="../estatico/inicio.jsp" />
<title>Presenças do Aluno</title>
</head>
<body>
	<c:if test="${not empty administradorLogado }">
		<c:import url="../estatico/cabecalho-administrador-presenca-aluno.jsp"/>
	</c:if>
	<c:if test="${not empty usuarioLogado }">
		<c:import url="../estatico/cabecalho-presenca-aluno.jsp"/>
	</c:if>
	<div class="container">
		<form action="/formPresencaAluno?id=${aluno.id }" method="Post">
			<div class="form-group">
				<label for="exampleFormControlSelect1">Período</label> <select
					class="form-control" name="periodo">
					<option>Manhã</option>
					<option>Tarde</option>
					<option>Noite</option>
				</select>
			</div>
			<button class="btn btn-primary" type="submit">Marcar</button>
		</form>
	</div>
</body>
</html>