package pt.com.praxe.projeto.Dao;

import pt.com.praxe.projeto.interfaces.*;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pt.com.praxe.projeto.model.Usuario;

@Repository
@Transactional
public class UsuarioDao implements InterfaceDao {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public void grava(Object o) {
		Usuario usuario = (Usuario) o;
		this.manager.persist(usuario);

	}

	@Override
	public void altera(Object o) {
		Usuario usuario = (Usuario) o;
		this.manager.merge(usuario);

	}

	@Override
	public Usuario getId(Long id) {
		return this.manager.find(Usuario.class, id);
	}
	
	@Override
	public void remove(Object o) {
		Usuario usuario = (Usuario) o;
		Usuario u = this.getId(usuario.getId());
		this.manager.remove(u);
	}
	
	public Usuario getUsuario(Usuario usuario) {
		Query query = this.manager.createQuery("select distinct u from Usuario u where u.nome = :paramNome and u.senha = :paramSenha ")
				.setParameter("paramNome", usuario.getNome())
				.setParameter("paramSenha", usuario.getSenha());
		Usuario usuarioEncontrado = (Usuario) query.getSingleResult();
		return usuarioEncontrado;
	}
	
	
	public List<Usuario> getUsuarios() {
		Query query = this.manager.createQuery("select u from Usuario as u ");
		List<Usuario> usuarios = query.getResultList();
		return usuarios;
	}
	
	public List<Usuario> getUsuarios(String nome){
		Query query = this.manager.createQuery("select u from Usuario u where u.nome = :paramNome")
				.setParameter("paramNome", nome);
		List<Usuario> usuarios  = query.getResultList();
		
		return usuarios;
	}

}
