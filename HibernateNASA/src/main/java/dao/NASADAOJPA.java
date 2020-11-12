package dao;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.inject.Inject;

import entity.nasa.Data;
import entity.nasa.Items;
import entity.nasa.NASA;
import webservice.WEBService;

@ApplicationScoped
public class NASADAOJPA extends DAOJPA<Data, Integer> implements NASADAO<Data, Integer>{
	
	@Inject
	private NASA dados;
	
	@Inject
	private Data data;
	
	private List<Items> mediaNASA;
	
	@Inject
	private List<Items> items;
	
	private List<Items> itemsSelection;
	
	@Inject
	private int inputNumberID;
	
	@Inject
	private String inputNASAID;
	
	@Inject
	private String inputDescription;
	
	@Inject
	private String inputCenter;
	
	@Inject
	private String inputPhotographer;
	
	@Inject
	private Date inputDate;
	
	@Inject
	private String inputMedia;
	

	public List<Items> getMediaNASA() {
		return mediaNASA;
	}

	public void setMediaNASA(List<Items> mediaNASA) {
		this.mediaNASA = mediaNASA;
	}

	public List<Items> getItemsSelection() {
		return itemsSelection;
	}

	public void setItemsSelection(List<Items> itemsSelection) {
		this.itemsSelection = itemsSelection;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public String getInputDescription() {
		return inputDescription;
	}

	public void setInputDescription(String inputDescription) {
		this.inputDescription = inputDescription;
	}

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

	public int getInputNumberID() {
		return inputNumberID;
	}

	public void setInputNumberID(int inputNumberID) {
		this.inputNumberID = inputNumberID;
	}

	public String getInputNASAID() {
		return inputNASAID;
	}

	public void setInputNASAID(String inputNASAID) {
		this.inputNASAID = inputNASAID;
	}

	public String getInputCenter() {
		return inputCenter;
	}

	public void setInputCenter(String inputCenter) {
		this.inputCenter = inputCenter;
	}

	public String getInputPhotographer() {
		return inputPhotographer;
	}

	public void setInputPhotographer(String inputPhotographer) {
		this.inputPhotographer = inputPhotographer;
	}

	public Date getInputDate() {
		return inputDate;
	}

	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}

	public String getInputMedia() {
		return inputMedia;
	}

	public void setInputMedia(String inputMedia) {
		this.inputMedia = inputMedia;
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
	
	public void detalhesData(int numberID) {
		
		Data detalhesData = getItems().get(numberID-1).getData()[0];
		try {
			String conversaoNASA_ID = getItems().get(numberID-1).getData()[0].getNasa_id().replaceAll(" ", "%20");
			System.out.println("\nTeste: "+conversaoNASA_ID+"\n");
			setMediaNASA(WEBService.listarMediaNASA(conversaoNASA_ID));
			for(int i = 0;i < mediaNASA.size();i++) {
				getMediaNASA().get(i).setHref(mediaNASA.get(i).getHref().replaceAll(" ", "%20"));
			}
			
			System.out.println("\nTeste: "+mediaNASA.get(0).getHref()+"\n");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	public void saveData(int numberID) {
		Data detalhesData = getItems().get(numberID-1).getData()[0];
		save(detalhesData);
	}


}
