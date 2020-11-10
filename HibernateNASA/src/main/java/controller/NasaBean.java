package controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import dao.NASAJPA;

@ApplicationScoped
@ManagedBean
public class NasaBean extends NASAJPA implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	@PostConstruct
	public void init() {
		BuscarDados();
	}
	
}
