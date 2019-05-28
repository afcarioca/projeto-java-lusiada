<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="../estatico/inicio.jsp" />
<title>Menu do Usuário</title>
</head>
<body>
	<c:if test="${empty usuarioLogado}">
		<div class="container">
			<c:import url="../erros/erro.jsp" />
		</div>
	</c:if>
	<c:choose>
		<c:when
			test="${not empty usuarioLogado}">
			<c:import url="../estatico/cabecalho-usuario.jsp" />
			<div class="container">
				<div class="alert alert-primary" role="alert">
					<p>Seja Bem-Vindo, ${usuarioLogado.nome }!</p>
				</div>
			</div>
		</c:when>
	</c:choose>
</body>
</html>