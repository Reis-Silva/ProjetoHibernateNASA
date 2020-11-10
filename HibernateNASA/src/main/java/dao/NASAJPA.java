package dao;

import java.util.List;

import javax.inject.Inject;

import entity.nasa.Items;
import entity.nasa.NASA;
import webservice.GetCollection;
import webservice.WEBService;

public class NASAJPA extends DAOJPA<NASA, Integer> implements NASADAO<NASA, Integer>{
	
	@Inject
	private NASA dados;
	
	private String input;
	
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

	
	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	@Override
	public List<NASA> buscar() {
		// TODO Auto-generated method stub
		return null;
	}

	public void BuscarDados() {
		try {
			setItems(WEBService.listarDadosNASA());
			input = getItems().get(0).getData()[0].getNasa_id();
			System.out.print("teste: "+ getItems()+"\n");
			System.out.print("teste2: "+ getItems().get(0).getData()[0].getNasa_id()+"\n");
			System.out.println("teste3: " + input +"\n");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
