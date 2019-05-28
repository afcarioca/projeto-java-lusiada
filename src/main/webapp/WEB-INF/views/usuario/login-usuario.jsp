<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="../estatico/inicio.jsp" />
<title>Login</title>
</head>
<body>
	<div class="container">
		<form class="px-4 py-5" action="/menuUsuario" method="post">
			<c:import url="../estatico/alert-login.jsp" />
			<c:import url="../estatico/body-login.jsp" />
			<c:import url="../estatico/alert-sessao.jsp" />
		</form>
	</div>
</body>
</html>