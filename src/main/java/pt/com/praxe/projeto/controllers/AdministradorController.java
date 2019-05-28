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

import pt.com.praxe.projeto.Dao.AdministradorDao;
import pt.com.praxe.projeto.Dao.UsuarioDao;
import pt.com.praxe.projeto.model.Administrador;
import pt.com.praxe.projeto.model.Usuario;

@Controller
public class AdministradorController {

	@Autowired
	private AdministradorDao dao;

	@Autowired
	private UsuarioDao usuarioDao;

	@GetMapping("/loginAdm")
	public ModelAndView loginAdministrador() {
		return new ModelAndView("/administrador/login-adm");
	}

	@GetMapping("/menuAdministrador")
	public ModelAndView menuAdministrador() {
		ModelAndView view = new ModelAndView("/administrador/menu-administrador");
		List<Usuario> usuarios = this.usuarioDao.getUsuarios();
		view.addObject("usuarios", usuarios);
		return view;
	}

	@PostMapping("/menuAdministrador")
	public ModelAndView menuAdministrador(@RequestParam("nome") String nome, @RequestParam("senha") String senha,
			HttpSession session, RedirectAttributes redirectAttributes) {

		ModelAndView view = new ModelAndView("/administrador/menu-administrador");
		
		if (session.getAttribute("administradorLogado") != null || session.getAttribute("usuarioLogado") != null) {
			redirectAttributes.addFlashAttribute("Login", "Já existe um usuário Logado");
			return new ModelAndView("redirect:/loginAdm");
		}

		List<Usuario> usuarios = this.usuarioDao.getUsuarios();
		view.addObject("usuarios", usuarios);

		try {
			Administrador administrador = this.dao.getAdministrador(new Administrador(nome, senha));
			System.out.println(administrador.getNome());
			session.setAttribute("administradorLogado", administrador);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			redirectAttributes.addFlashAttribute("Login", "Usuário Inexistente");
			return new ModelAndView("redirect:/loginAdm");
		}

		return view;
	}

	@GetMapping("/sairAdministrador")
	public ModelAndView sair(HttpSession session, RedirectAttributes redirectAttributes) {
		session.invalidate();
		redirectAttributes.addFlashAttribute("Sessao", "Sessão finalizada!");
		return new ModelAndView("redirect:/loginAdm");
	}
}
