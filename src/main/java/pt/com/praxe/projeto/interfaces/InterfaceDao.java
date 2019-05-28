package pt.com.praxe.projeto.interfaces;

public interface InterfaceDao {
	
	void grava(Object o);
	Object getId(Long id);
	void altera(Object o);
	void remove(Object o);
}
