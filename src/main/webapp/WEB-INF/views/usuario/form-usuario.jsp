<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="../estatico/inicio.jsp" />
<title>Cadastrar Usuário</title>
</head>
<body>
	<c:import url="../estatico/cabecalho-administrador-cadastro-usuario.jsp" />
	<div class="container">
		
		<form class="px-4 py-5" action="/usuario/cadastrado/" method="post">
			<c:import url="../estatico/body-form-usuario.jsp"/>
		</form>
	</div>
</body>
</html>