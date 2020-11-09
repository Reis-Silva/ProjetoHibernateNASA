package dao;

import java.util.List;

public abstract class DAOJPA<T,I> implements DAO<T,I>{
	
	private T entidade;
	private List<T> entidades;
	
}
