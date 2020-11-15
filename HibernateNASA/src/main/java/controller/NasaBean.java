package controller;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.SelectEvent;

import dao.NASADAOJPA;
import entity.nasa.Items;

@ViewScoped
@ManagedBean
public class NasaBean extends NASADAOJPA implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	@SuppressWarnings("rawtypes")
	public void onRowSelect(SelectEvent event) {
		Items items =  (Items) (event.getObject());
		setData(items.getData()[0]);
		
		String media = getItems().get(getData().getNumberID() - 1).getData()[0].getMedia_type();
		
		if(media.contentEquals("video")) {
			setDadaSpecificSelection("PF('detailsvideodata').show();");
		}else if(media.contentEquals("image")) {
			setDadaSpecificSelection("PF('detailsimagedata').show();");
		}else if(media.contentEquals("audio")) {
			setDadaSpecificSelection("PF('detailsaudiodata').show();");
		}else {
			System.out.println("Nenhuma das Opções");
		}
		System.out.println("\nTeste: "+ getDadaSpecificSelection() +"\n");
    }
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public <Data> void onRowSelectStorage(SelectEvent event) {
		Data storage =  (Data) (event.getObject());
		setStorageSelection((entity.nasa.Data) storage);
    }
	
	@PostConstruct
	public void init() {
		buscarDadosNasa();
	}
	
}
