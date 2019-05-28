package pt.com.praxe.projeto.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pt.com.praxe.projeto.Calendario;
import pt.com.praxe.projeto.Dao.AlunoDao;
import pt.com.praxe.projeto.Dao.PresencaDao;
import pt.com.praxe.projeto.model.Aluno;
import pt.com.praxe.projeto.model.Presenca;

@Controller
public class AlunoController {

	@Autowired
	private AlunoDao dao;

	private Calendar calendar;

	@Autowired
	private PresencaDao d;

	@GetMapping("/aluno/form")
	public ModelAndView form() {
		ModelAndView view = new ModelAndView("/aluno/form-aluno");
		return view;
	}

	@PostMapping("/aluno/cadastrado")
	public ModelAndView cadastra(Aluno aluno, RedirectAttributes redirectAttributes) {
		System.out.println(aluno);
		this.dao.grava(aluno);
		redirectAttributes.addFlashAttribute("sucesso", "Aluno na praxe!");
		return new ModelAndView("redirect:/lista/praxe");
	}

	@RequestMapping("/lista/praxe")
	public ModelAndView mostra() {

		List<Aluno> alunos = this.dao.getAlunos();
		ModelAndView view = new ModelAndView("/aluno/lista");
		view.addObject("alunos", alunos);

		return view;
	}

	@GetMapping("/removeAluno")
	public ModelAndView remove(Aluno aluno) {
		this.dao.remove(aluno);
		return new ModelAndView("redirect:/lista/praxe");
	}

	@GetMapping("/alteraAluno")
	public ModelAndView altera(Aluno aluno) {
		ModelAndView view = new ModelAndView("/aluno/altera-formulario-aluno");
		Aluno a = this.dao.getId(aluno.getId());
		view.addObject("aluno", a);
		return view;
	}

	@PostMapping("/alteraAluno")
	public ModelAndView muda(Aluno aluno) {
		this.dao.altera(aluno);
		return new ModelAndView("redirect:/lista/praxe");
	}

	@PostMapping("/aluno/pesquisa")
	public ModelAndView pesquisa(@RequestParam("nome") String nome) {
		ModelAndView modelAndView = new ModelAndView("/aluno/pesquisa-aluno");
		List<Aluno> alunos = this.dao.getAluno(nome);
		modelAndView.addObject("alunos", alunos);
		return modelAndView;

	}

	@GetMapping("/formPresencaAluno")
	public ModelAndView presenca(Aluno aluno) {
		ModelAndView view = new ModelAndView("/aluno/presenca");

		Aluno a = this.dao.getId(aluno.getId());

		view.addObject("aluno", a);
		return view;
	}

	@RequestMapping("/perfil")
	public ModelAndView perfil(Aluno aluno) {
		ModelAndView view = new ModelAndView("/aluno/perfil");
		Aluno a = this.dao.getId(aluno.getId());
		
		Calendar dateOfBirth = new GregorianCalendar();
		dateOfBirth.setTime(a.getDataNascimento());
		Calendar today = Calendar.getInstance();
		int age = today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR);
		dateOfBirth.add(Calendar.YEAR, age);
		if (today.before(dateOfBirth)) 
			age--;

		Integer i = age;

		view.addObject("aluno", a);
		view.addObject("idade", i);

		return view;

	}

	@PostMapping("/formPresencaAluno")
	public ModelAndView funcao(Aluno aluno, @RequestParam("periodo") String periodo) {
		ModelAndView view = new ModelAndView("/aluno/lista-presencas");

		Presenca presenca = new Presenca();
		presenca.setPeriodo(periodo);

		Calendar c = Calendar.getInstance();
		Date data = c.getTime();

		presenca.setDataPresenca(data);
		Aluno a = this.dao.getId(aluno.getId());

		a.setPresenca(presenca);

		this.d.grava(presenca);

		List<Presenca> presencas = a.getPresencas();

		view.addObject("aluno", a);
		view.addObject("presencas", presencas);

		return view;
	}

}
