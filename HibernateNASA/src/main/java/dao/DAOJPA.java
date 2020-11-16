package dao;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public abstract class DAOJPA<T,I> implements DAO<T, I>{
	

	private JPAUtil conexao;
	
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
			conexao.offlineServer();
			messageView(true, "The data was save!");
		} catch (Exception e) {
			getEntityManager().getTransaction().rollback();
			messageView(false, "The data not save!");
		}	
	}
	
	@Override
	public void remove(Class<T> classGeneric, I pk) {
		getEntityManager().getTransaction().begin();
		T reference = getEntityManager().getReference(classGeneric, pk);
		getEntityManager().remove(reference);
		getEntityManager().getTransaction().commit();
		getEntityManager().close();
		conexao.offlineServer();
	}

	@SuppressWarnings("unused")
	@Override
	public List<T> search(Class<T> classGeneric) {
		getEntityManager().getTransaction().begin();
		CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(classGeneric); 
		Root<T> root = criteriaQuery.from(classGeneric);
		TypedQuery<T> typedQuery = (TypedQuery<T>) getEntityManager().createQuery(criteriaQuery);
		List<T> list = typedQuery.getResultList();
		getEntityManager().getTransaction().commit();		
		getEntityManager().close();
		conexao.offlineServer();
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
