package dao;

import java.util.List;

import javax.persistence.EntityManager;

public abstract class DAOJPA<T,I> implements DAO<T, I>{
	
	private T entidade;
	private List<T> entidades;
	private JPAUtil conexao;
	
	public T getEntidade() {
		return entidade;
	}

	public void setEntidade(T entidade) {
		this.entidade = entidade;
	}

	public List<T> getEntidades() {
		return entidades;
	}

	public void setEntidades(List<T> entidades) {
		this.entidades = entidades;
	}

	public JPAUtil getConexao() {
		return conexao;
	}

	public void setConexao(JPAUtil conexao) {
		this.conexao = conexao;
	}

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
