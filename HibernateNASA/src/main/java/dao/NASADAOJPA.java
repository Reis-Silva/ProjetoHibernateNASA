package dao;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.inject.Inject;

import entity.nasa.Items;
import entity.nasa.NASA;
import webservice.WEBService;

@ApplicationScoped
public class NASADAOJPA extends DAOJPA<NASA, Integer> implements NASADAO<NASA, Integer>{
	
	@Inject
	private NASA dados;
	
	@Inject
	private List<Items> items;
	
	public NASA getDados() {
		return dados;
	}

	public void setDados(NASA dados) {
		this.dados = dados;
	}

	public List<Items> getItems() {
		return items;
	}

	public void setItems(List<Items> items) {
		this.items = items;
	}

	public void BuscarDados() {
		try {
			if(WEBService.listarDadosNASA() == null) {
				System.out.println("\nServidor Inativo\n");
			}else {
				setItems(WEBService.listarDadosNASA());
				
				for(int i = 0; i < items.size();i++) {
					getItems().get(i).getData()[0].setNumberID(i+1);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void detalhesDados(int numberID) {
		
		getItems().get(numberID-1).getData()[0].getDate_created();
	}


}
