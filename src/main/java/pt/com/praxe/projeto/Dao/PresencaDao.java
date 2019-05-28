package pt.com.praxe.projeto.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pt.com.praxe.projeto.interfaces.InterfaceDao;
import pt.com.praxe.projeto.model.Aluno;
import pt.com.praxe.projeto.model.Presenca;

@Repository
@Transactional
public class PresencaDao implements InterfaceDao {

	@Autowired
	private EntityManager manager;

	@Override
	public void grava(Object o) {
		Presenca presenca = (Presenca) o;
		this.manager.persist(presenca);
	}

	@Override
	public void altera(Object o) {
		Presenca presenca = (Presenca) o;
		this.manager.merge(presenca);
	}

	@Override
	public Presenca getId(Long id) {
		return this.manager.find(Presenca.class, id);
	}

	@Override
	public void remove(Object o) {
		Presenca presenca = (Presenca) o;
		Presenca p = this.getId(presenca.getId());
		this.manager.remove(p);
	}

	public List<Presenca> getPresencas(Aluno aluno, Presenca presenca) {
		Query query = this.manager.createQuery("select a from Aluno a join fetch a.presencas");
		List<Presenca> presencas = query.getResultList();
		return presencas;

	}

	public List<Presenca> getNome(Aluno aluno, String nome) {
		Query query = this.manager
				.createQuery("select p from Presenca p where p.periodo = :paramPeriodo" + " and p.aluno = :paramAluno")
				.setParameter("paramPeriodo", nome).setParameter("paramAluno", aluno);

		List<Presenca> presenca = query.getResultList();

		return presenca;
	}

	public List<Presenca> total() {
		Query query = this.manager.createQuery("select p from Presenca p ");

		List<Presenca> presencas = query.getResultList();

		return presencas;
	}

	public List<Presenca> getPresencas(Presenca presenca) {

		Query query = this.manager.createQuery("select p from Presenca p where p.id = :paramPresenca ")
				.setParameter("paramPresenca", presenca.getId());

		List<Presenca> presencas = query.getResultList();

		return presencas;

	}

	public List<Presenca> getPresencas(Aluno aluno) {
		Query query = this.manager.createQuery("select p from Presenca p where p.aluno = :paramAluno")
				.setParameter("paramAluno", aluno);

		List<Presenca> presencas = query.getResultList();

		return presencas;
	}

}
