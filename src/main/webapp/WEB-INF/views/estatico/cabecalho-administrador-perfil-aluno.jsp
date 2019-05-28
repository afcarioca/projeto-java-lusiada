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
				href="/menuAdministrador">Lista de Usuários</a></li>
			<li class="nav-item"><a class="nav-link" href="/aluno/form">Cadastrar
					Aluno</a></li>
		</ul>
		<c:if test="${not empty administradorLogado  }">
			<a class="nav-link" href="/sairAdministrador">Sair do Sistema</a>
		</c:if>
	</div>
</nav>