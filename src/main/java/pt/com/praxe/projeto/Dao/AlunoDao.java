package pt.com.praxe.projeto.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pt.com.praxe.projeto.interfaces.InterfaceDao;
import pt.com.praxe.projeto.model.Aluno;
import pt.com.praxe.projeto.model.Presenca;

@Repository
@Transactional
public class AlunoDao implements InterfaceDao {

	@PersistenceContext
	private EntityManager manager;
	
	
	public void grava(Presenca presenca) {
		this.manager.persist(presenca);
	}
	
	@Override
	public void grava(Object o) {
		Aluno aluno = (Aluno) o;
		this.manager.persist(aluno);

	}
	
	@Override
	public void altera(Object o) {
		Aluno aluno = (Aluno) o;
		this.manager.merge(aluno);
	}
	
	@Override
	public void remove(Object o) {
		Aluno aluno = (Aluno) o;
		Aluno a = this.getId(aluno.getId());
		this.manager.remove(a);
	}
	
	@Override
	public Aluno getId(Long id) {
		return this.manager.find(Aluno.class, id);
	}


	public List<Aluno> getAlunos() {
		return manager.createQuery("select a from Aluno a", Aluno.class).getResultList();
	}

	
	public Aluno getAluno(Long id) {
		return manager.find(Aluno.class, id);
	}

	public List<Aluno> get(Aluno aluno) {
		Query query = this.manager.createQuery("select a from Aluno as a where a.nome = :paramNome")
				.setParameter("paramNome", aluno.getNome());
		System.out.println(aluno.getNome());
		List<Aluno> alunos = query.getResultList();

		return alunos;
	}
	
	public List<Aluno> getAluno(String nome){
		Query query = this.manager.createQuery("select a from Aluno a where a.nome = :paramNome")
		.setParameter("paramNome", nome);
		
		List<Aluno> alunos = query.getResultList();
		
		return alunos;
	}

	public List<Presenca> getPresencas(Aluno aluno) {
		Query query = this.manager.createQuery("select a.presencas from Aluno as a where a.id = :paramId ")
				.setParameter("paramId", aluno.getId());

		List<Presenca> presencas = query.getResultList();
		
		return presencas;
	}

}
