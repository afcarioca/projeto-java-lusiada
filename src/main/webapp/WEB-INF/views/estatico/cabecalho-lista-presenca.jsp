<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<a class="navbar-brand" href="/lista/praxe">Praxe</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item"><a class="nav-link"
				href="/formPresencaAluno?id=${aluno.id }">Marcar Presença </a></li>
		</ul>
		<form class="form-inline my-2 my-lg-0"
			action="/presenca/pesquisa?id=${aluno.id }" method="post">
			<input class="form-control mr-sm-2" type="search"
				placeholder="Presenças" aria-label="Search" name="periodo">
			<button class="btn btn-primary my-2 my-sm-0" type="submit">Presenças</button>
		</form>

		<c:if test="${not empty administradorLogado  }">
			<a class="nav-link" href="/sairAdministrador">Sair do Sistema</a>
		</c:if>

		<c:if test="${not empty usuarioLogado  }">
			<a class="nav-link" href="/sair">Sair do Sistema</a>
		</c:if>
	</div>
</nav>