package dao;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Criteria;

import entity.nasa.Data;
import entity.nasa.Items;

public abstract class DAOJPA<T,I,L> implements DAO<T, I, L>{
	
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
			conexao = null;
			getEntityManager().getTransaction().begin();
			getEntityManager().persist(entity);
			getEntityManager().getTransaction().commit();
			getEntityManager().close();
			messageView(true, "The data was save!");
		} catch (Exception e) {
			getEntityManager().getTransaction().rollback();
			messageView(false, "The data not save!");
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
	
	
	public List<T> search() {
		conexao = null;
		
		getEntityManager().getTransaction().begin();
		Criteria crit = ((Criteria) getEntityManager()).createCriteria(null);
		List<Items> list = ((Query) crit).getResultList();
		getEntityManager().getTransaction().commit();
		
		return (List<T>) list;
	}
	
	
	public void messageView(Boolean success, String menssage) {
		if (success == true) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, menssage, null));
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, menssage, null));
		}
	}
	
	@Override
	public EntityManager getEntityManager() {
		if(conexao == null) {
			conexao = new JPAUtil();
		}
		return conexao.getEntityManager();
	}
	
	
}
