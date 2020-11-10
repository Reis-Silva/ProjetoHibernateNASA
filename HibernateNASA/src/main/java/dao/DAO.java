package dao;

import java.util.List;

import javax.persistence.EntityManager;

public interface DAO<T,I> {
	
	 public void save(T entity);
	 public void remove(Class<T> classGeneric, I pk);
	 T getById(Class<T> classGeneric, I pk);
	 public List<T> buscar();
	 EntityManager getEntityManager();
	 List<T> buscar(Class<T> classGeneric);
	
}
