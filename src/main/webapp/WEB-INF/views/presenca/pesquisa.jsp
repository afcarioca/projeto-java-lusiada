<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:import url="../estatico/inicio.jsp" />
<title>Presenças do Aluno</title>
</head>
<body>
	<c:if test="${not empty usuarioLogado }">
		<c:import url="../estatico/cabecalho-lista-presenca.jsp" />
	</c:if>
	<c:if test="${not empty administradorLogado }">
		<c:import url="../estatico/cabecalho-administrador-lista-presenca.jsp"/>
	</c:if>
	<div class="container">
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