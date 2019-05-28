<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="../estatico/inicio.jsp" />
<title>Alterar Usuário</title>
</head>
<body>
	<c:import
		url="../estatico/cabecalho-administrador-cadastro-usuario.jsp" />
	<div class="container">
		<form action="/alteraUsuario" method="post">
			<input type="hidden" name="id" value="${usuario.id }" />
			<div class="col-md-4 mb-3">
				<label>Nome </label> <input type="text" class="form-control"
					name="nome" value="${usuario.nome }" placeholder="Novo Usuário">
				<label>Senha</label> <input type="password" class="form-control"
					name="senha" value="${usuario.senha }" placeholder="Senha">
			</div>
			<div class="col-md-4 mb-3">
				<button type="submit" class="btn btn-primary">Alterar</button>
			</div>
		</form>
	</div>
</body>
</html>