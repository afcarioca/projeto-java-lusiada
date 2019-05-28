<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="d"%>
<c:import url="../estatico/inicio.jsp" />
<title>Formulário</title>
</head>
<body>
	<c:if test="${empty usuarioLogado && empty administradorLogado}">
		<div class="container">
			<h1>Aqui Não</h1>
		</div>
	</c:if>
	<c:if
		test="${ not empty usuarioLogado || not empty administradorLogado }">
		<c:import url="../estatico/cabecalho-usuario-cadastro-aluno.jsp" />
		<div class="container">
			<form action="/aluno/cadastrado/" method="post">
				<div class="form-row">
					<div class="col-md-5 mb-3">
						<label>Nome</label> <input type="text" class="form-control"
							name="nome" placeholder="Nome" required>
					</div>
				</div>
				<div class="form-row">
					<div class="col-md-3 mb-3">
						<label>Número de Aluno</label> <input type="text"
							class="form-control" name="numero" placeholder="Número" required>
					</div>
				</div>
				<div class="form-row">
					<div class="col-md-3 mb-3">
						<label>Curso</label> <input type="text" class="form-control"
							name="curso" placeholder="Curso" required>
					</div>
				</div>
				<div class="form-row">
					<div class="col-md-3 mb-3">
						<label>Telemóvel</label> <input type="text" class="form-control"
							name="telemovel" placeholder="Tel" required>
					</div>
				</div>
				<div class="form-row">
					<div class="col-md-4 mb-3">
						<label>Localidade</label> <input type="text" class="form-control"
							name="localidade" placeholder="Local" required>
					</div>
				</div>
				<div class="form-row">
					<div class="col-md-4 mb-3">
						<label>Deslocamento</label> <input type="text"
							class="form-control" name="deslocamento"
							placeholder="Deslocamento">
					</div>
				</div>
				<div class="form-row">
					<div class="col-md-3 mb-3">
						<label>Problemas de Saúde</label>
						<textarea class="form-control" name="saude" rows="3"
							placeholder="Escreva aqui..."></textarea>
					</div>
				</div>
				<div class="form-row">
					<div class="col-md-3 mb-3">
						<label>Data de Nascimento</label>
						<d:campoData id="dataNascimento" />
					</div>
				</div>
				<div class="form-row">
					<label>Observações</label>
					<textarea class="form-control" name="observacoes" rows="5"
						placeholder="Escreva aqui..."></textarea>
				</div>
				<div class="form-row">
					<button class="btn btn-primary" type="submit">Cadastrar</button>
				</div>
			</form>
		</div>
	</c:if>
</body>
</html>