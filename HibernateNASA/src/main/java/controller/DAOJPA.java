package controller;

import java.util.List;

import dao.DAO;

public abstract class DAOJPA<T,I> implements DAO<T,I>{
	
	private T entidade;
	private List<T> entidades;
	
}
