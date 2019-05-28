<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="../estatico/inicio.jsp"/>
<title>Pesquisa Usuários</title>
</head>
<body>
	<c:import url="../estatico/cabecalho-Administrador.jsp" />
	<div class="container">
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
	</div>
</body>
</html>