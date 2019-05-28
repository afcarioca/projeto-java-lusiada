package pt.com.praxe.projeto.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pt.com.praxe.projeto.model.Administrador;

@Repository
@Transactional
public class AdministradorDao {
	
	@PersistenceContext
	private EntityManager manager;
	
	public Administrador getAdministrador(Administrador adm) {
		Query query = this.manager.createQuery("select distinct a from Administrador as a where "
				+ "a.nome = :paramNome and a.senha = :paramSenha")
				.setParameter("paramNome", adm.getNome())
				.setParameter("paramSenha", adm.getSenha());
					
		Administrador administrador = (Administrador)query.getSingleResult();
		
		return administrador;
	}
}
