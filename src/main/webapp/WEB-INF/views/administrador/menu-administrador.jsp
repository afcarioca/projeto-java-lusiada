<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="../estatico/inicio.jsp"/>
<title>Menu Administrador</title>
</head>
<body>
	<c:if test="${empty administradorLogado}">
		<div class="container">
			<c:import url="../erros/erro.jsp" />
		</div>
	</c:if>
	<c:if test="${not empty administradorLogado }">
		<c:import url="../estatico/cabecalho-Administrador.jsp" />
		<div class="container">
			<c:if test="${not empty usuarioCadastrado }">
				<div class="alert alert-primary" role="alert">
					<p>${usuarioCadastrado }</p>
				</div>
			</c:if>
			<c:if test="${not empty  usuarioAlterado }">
				<div class="alert alert-primary" role="alert">
					<p>${usuarioAlterado }</p>
				</div>
			</c:if>
			<c:if test="${empty usuarioCadastrado && empty usuarioAlterado }">
				<div class="alert alert-primary" role="alert">
					<p>Seja Bem-Vindo, ${administradorLogado.nome }!</p>
				</div>
			</c:if>
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
	</c:if>
</body>
</html>