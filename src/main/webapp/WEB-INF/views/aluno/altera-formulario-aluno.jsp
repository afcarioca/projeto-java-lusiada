<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="d"%>
<c:import url="cabecalho-form.jsp" />
<c:if test="${empty usuarioLogado && empty administradorLogado}">
	<div class="container">
		<c:import url="../erros/erro.jsp" />
	</div>
</c:if>
<c:if
	test="${ not empty usuarioLogado || not empty administradorLogado }">
	<c:import url="../estatico/cabecalho-usuario-cadastro-aluno.jsp" />
	<div class="container">
		<form action="/alteraAluno" method="post">
			<input type="hidden" name="id" value="${aluno.id }" />
			<div class="form-row">
				<div class="col-md-5 mb-3">
					<label>Nome</label> <input type="text" class="form-control"
						name="nome" placeholder="Nome" value="${aluno.nome }" required>
				</div>
			</div>
			<div class="form-row">
				<div class="col-md-3 mb-3">
					<label>Número de Aluno</label> <input type="text"
						class="form-control" name="numero" placeholder="Número"
						value="${aluno.numeroDeAluno }" required>
				</div>
			</div>
			<div class="form-row">
				<div class="col-md-3 mb-3">
					<label>Curso</label> <input type="text" class="form-control"
						name="curso" placeholder="Curso" value="${aluno.curso }" required>
				</div>
			</div>
			<div class="form-row">
				<div class="col-md-3 mb-3">
					<label>Telemóvel</label> <input type="text" class="form-control"
						name="telemovel" placeholder="Tel" value="${aluno.telemovel }"
						required>
				</div>
			</div>
			<div class="form-row">
				<div class="col-md-4 mb-3">
					<label>Localidade</label> <input type="text" class="form-control"
						name="localidade" placeholder="Local" value="${aluno.localidade }"
						required>
				</div>
			</div>
			<div class="form-row">
				<div class="col-md-4 mb-3">
					<label>Deslocamento</label> <input type="text" class="form-control"
						name="deslocamento" value="${aluno.deslocamento }"
						placeholder="Deslocamento">
				</div>
			</div>
			<div class="form-row">
				<div class="col-md-3 mb-3">
					<label>Problemas de Saúde</label>
					<textarea class="form-control" name="saude" rows="3"
						placeholder="Escreva aqui...">${aluno.saude }</textarea>
				</div>
			</div>
			<div class="form-row">
				<div class="col-md-3 mb-3">
					<label>Data de Nascimento</label>
					<fmt:formatDate value="${aluno.dataNascimento}"
						pattern="dd/MM/yyyy" />
					<d:campoData id="dataNascimento"/>
				</div>
			</div>
			<div class="form-row">
				<label>Observações</label>
				<textarea class="form-control" name="observacoes" rows="5"
					placeholder="Escreva aqui...">${aluno.observacoes }</textarea>
			</div>
			<div class="form-row">
				<button class="btn btn-primary" type="submit">Cadastrar</button>
			</div>
		</form>
	</div>
</c:if>
</body>
</html>