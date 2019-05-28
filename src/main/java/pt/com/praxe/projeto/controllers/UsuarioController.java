package pt.com.praxe.projeto.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pt.com.praxe.projeto.Dao.UsuarioDao;
import pt.com.praxe.projeto.model.Usuario;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioDao dao;

	@GetMapping("/login")
	public ModelAndView loginUsuario() {
		return new ModelAndView("/usuario/login-usuario");
	}

	@GetMapping("/menuUsuario")
	public ModelAndView menuUsuario() {
		ModelAndView view = new ModelAndView("/usuario/menu-usuario");
		List<Usuario> usuarios = this.dao.getUsuarios();
		view.addObject("usuarios", usuarios);
		return view;
	}

	@PostMapping("/menuUsuario")
	public ModelAndView menuUsuario(@RequestParam("nome") String nome, @RequestParam("senha") String senha,
			HttpSession session, RedirectAttributes redirectAttributes) {

		ModelAndView view = new ModelAndView("/usuario/menu-usuario");

		if (session.getAttribute("usuarioLogado") != null || session.getAttribute("administradorLogado") != null) {
			redirectAttributes.addFlashAttribute("Login", "Já existe um usuário Logado");
			return new ModelAndView("redirect:/login");
		}

		try {
			Usuario usuario = this.dao.getUsuario(new Usuario(nome, senha));
			session.setAttribute("usuarioLogado", usuario);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			redirectAttributes.addFlashAttribute("Login", "Usuário Inexistente");
			return new ModelAndView("redirect:/login");

		}

		return view;

	}

	@GetMapping("/usuario/form")
	public ModelAndView form() {
		return new ModelAndView("/usuario/form-usuario");
	}

	@PostMapping("/usuario/cadastrado")
	public ModelAndView cadastra(@RequestParam("nome") String nome, @RequestParam("senha") String senha, RedirectAttributes redirectAttributes) {
		this.dao.grava(new Usuario(nome, senha));
		redirectAttributes.addFlashAttribute("usuarioCadastrado", "Usuário Cadastrado com sucesso!");
		return new ModelAndView("redirect:/menuAdministrador");

	}

	@GetMapping("/alteraUsuario")
	public ModelAndView altera(Usuario usuario) {
		ModelAndView view = new ModelAndView("/usuario/altera-formulario-usuario");

		Usuario u = this.dao.getId(usuario.getId());

		view.addObject("usuario", u);

		return view;
	}

	@PostMapping("/alteraUsuario")
	public ModelAndView muda(Usuario usuario, RedirectAttributes redirectAttributes) {
		this.dao.altera(usuario);
		redirectAttributes.addFlashAttribute("usuarioAlterado", " Usuário alterado com sucesso");
		return new ModelAndView("redirect:/menuAdministrador");
	}

	@GetMapping("/removeUsuario")
	public ModelAndView remove(Usuario usuario) {

		this.dao.remove(usuario);
		return new ModelAndView("redirect:/menuAdministrador");
	}

	@PostMapping("/usuario/pesquisa")
	public ModelAndView pesquisa(@RequestParam("nome") String nome) {
		List<Usuario> usuarios = this.dao.getUsuarios(nome);
		ModelAndView view = new ModelAndView("/usuario/pesquisa-usuario");
		view.addObject("usuarios", usuarios);
		return view;
	}

	@GetMapping("/sair")
	public ModelAndView sair(HttpSession session, RedirectAttributes redirectAttributes) {
		session.invalidate();
		redirectAttributes.addFlashAttribute("Sessao", "Sessão finalizada!");
		return new ModelAndView("redirect:/login");
	}

}
