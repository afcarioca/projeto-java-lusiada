package pt.com.praxe.projeto.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pt.com.praxe.projeto.Dao.AlunoDao;
import pt.com.praxe.projeto.Dao.PresencaDao;
import pt.com.praxe.projeto.model.Aluno;
import pt.com.praxe.projeto.model.Presenca;

@Controller
public class PresencaController {
	
	@Autowired
	private PresencaDao dao;
	
	@Autowired
	private AlunoDao d;
	
	@GetMapping("/alteraPresenca")
	public ModelAndView altera(Presenca presenca) {
		ModelAndView view = new ModelAndView("/presenca/altera-presenca");
		view.addObject("presenca", presenca);
		return view;
	}
	
	@PostMapping("/alteraPresenca")
	public ModelAndView muda(Presenca presenca,@RequestParam("presenca") String p1) {
		Presenca p = this.dao.getId(presenca.getId());
		p.setPeriodo(p1);
		System.out.println("aqui");
		this.dao.altera(p);
		return new ModelAndView("redirect:/lista/presencas");
	}
	
	@RequestMapping("/removePresenca")
	public ModelAndView remove(Presenca presenca) {
		this.dao.remove(presenca);
		return new ModelAndView("redirect:/lista/presencas");
	}
	
	@RequestMapping("/lista/presencas")
	public ModelAndView lista() {
		ModelAndView view = new ModelAndView("/aluno/lista-presencas");
		Aluno aluno = null;
		List<Presenca> presencas = this.dao.total();
		
		for (Presenca presenca : presencas) 
			 aluno = this.d.getId(presenca.getAluno().getId());
		
		List<Presenca> presencas2 = this.dao.getPresencas(aluno);
		
		view.addObject("aluno", aluno);
		view.addObject("presencas", presencas2);
				
		return view;
	}
	
	
	@RequestMapping("/presenca/pesquisa")
	public ModelAndView pesquisa(Aluno aluno ,@RequestParam("periodo") String periodo) {
		ModelAndView view = new ModelAndView("/presenca/pesquisa");
		
		Aluno a = this.d.getId(aluno.getId());
		
		List<Presenca> presencas = this.dao.getNome(a, periodo);
		
		view.addObject("aluno",a);
		view.addObject("presencas", presencas);
		
		return view;
		
	}
	
	@RequestMapping("/presencas")
	public ModelAndView f(Aluno aluno) {
		ModelAndView view = new ModelAndView("/presenca/pesquisa");
		
		Aluno a = this.d.getId(aluno.getId());
		
		List<Presenca> presencas = this.dao.getPresencas(a);
		
		System.out.println(a.getNome());
		
		view.addObject("presencas", presencas);
		view.addObject("aluno",a);
		
		return view; 
	
	}
	
}
