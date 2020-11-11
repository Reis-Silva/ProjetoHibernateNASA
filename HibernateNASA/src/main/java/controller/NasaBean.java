package controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import org.primefaces.event.SelectEvent;

import dao.NASADAOJPA;
import entity.nasa.Data;

@ApplicationScoped
@ManagedBean
public class NasaBean extends NASADAOJPA implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("rawtypes")
	public void onRowSelect(SelectEvent event) {
    	getDados().getItems()[0].setData((Data[]) event.getObject());	
    }
	
	
	@PostConstruct
	public void init() {
		BuscarDados();
	}
	
}
