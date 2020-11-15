package dao;

import java.util.List;

import javax.persistence.EntityManager;

public interface DAO<T,I> {
	 public void save(T entity);
	 public void remove(Class<T> classGeneric, I pk);
	 EntityManager getEntityManager();
	 public List<T> search(Class<T> classGeneric);
}
