<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="../estatico/inicio.jsp" />
<title>Pesquisa Aluno</title>
</head>
<body>
	<c:if test="${empty (usuarioLogado) && empty (administradorLogado) }">
		<div class="container">
			<h1>Não está logado</h1>
		</div>
	</c:if>
	<c:if test="${not empty (administradorLogado) }">
		<c:import url="../estatico/cabecalho-administrador-aluno.jsp" />
		<div class=container>
			<table class="table table-bordered">
				<c:import url="tabela.jsp" />
				<tbody>
					<c:forEach items="${alunos }" var="aluno">
						<tr>
							<td><a class="btn btn-primary"
								href="/formPresencaAluno?id=${aluno.id }">Marca Presença</a></td>

							<td><a class="nav-link" href="/perfil?id=${aluno.id }">${aluno.nome}</a></td>
							<td>${aluno.numeroDeAluno}</td>
							<td>${aluno.curso}</td>
							<td><a class="btn btn-primary"
								href="/alteraAluno?id=${aluno.id }">Altera</a></td>
							<td><a class="btn btn-primary"
								href="/removeAluno?id=${aluno.id }"> Deletar</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</c:if>
	<c:if test="${not empty (usuarioLogado)}">
		<c:import url="../estatico/cabecalho-usuario.jsp" />
		<div class=container>
			<table class="table table-bordered">
				<c:import url="tabela.jsp" />
				<tbody>
					<c:forEach items="${alunos }" var="aluno">
						<tr>
							<td><a class="btn btn-primary"
								href="/formPresencaAluno?id=${aluno.id }">Marca Presença</a></td>

							<td><a class="nav-link" href="/perfil?id=${aluno.id }">${aluno.nome}</a></td>
							<td>${aluno.numeroDeAluno}</td>
							<td>${aluno.curso}</td>
							<td><a class="btn btn-primary"
								href="/alteraAluno?id=${aluno.id }">Altera</a></td>
							<td><a class="btn btn-primary"
								href="/removeAluno?id=${aluno.id }"> Deletar</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</c:if>
</body>
</html>