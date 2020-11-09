package dao;

import java.util.List;

import javax.persistence.EntityManager;

public abstract class DAOJPA<T,I> implements DAO<T, I>{
	
	private T entidade;
	private List<T> entidades;
	private JPAUtil conexao;
	
	@Override
	public void save(T entity) {
		try {
			getEntityManager().getTransaction().begin();
			getEntityManager().persist(entity);
			getEntityManager().getTransaction().commit();
			getEntityManager().close();
			
		} catch (Exception e) {
			getEntityManager().getTransaction().rollback();
		}
		
	}
	
	@Override
	public void remove(Class<T> classGeneric, I pk) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public T getById(Class<T> classGeneric, I pk) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<T> buscar() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public EntityManager getEntityManager() {
		if(conexao == null) {
			conexao = new JPAUtil();
		}
		return conexao.getEntityManager();
	}
	
	
}
