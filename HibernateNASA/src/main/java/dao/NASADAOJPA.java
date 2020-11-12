package dao;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.inject.Inject;

import entity.nasa.Data;
import entity.nasa.Items;
import entity.nasa.NASA;
import webservice.WEBService;

public class NASADAOJPA extends DAOJPA<Data, Integer> implements NASADAO<Data, Integer>{
	
	@Inject
	private NASA dados;
	
	@Inject
	private Data data;
	
	private String dataSpecificVideoMedia = "http://images-assets.nasa.gov/video/Apollo 11 Overview/Apollo 11 Overview~mobile.mp4";
	private String dataSpecificImageMedia;
	private String dataSpecificAudioMedia = "https://images-assets.nasa.gov/audio/Apollo11Highlights/Apollo11Highlights~128k.mp3";
	private String dadaSpecificSelection;
	
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

	
	
	public String getDadaSpecificSelection() {
		return dadaSpecificSelection;
	}

	public void setDadaSpecificSelection(String dadaSpecificSelection) {
		this.dadaSpecificSelection = dadaSpecificSelection;
	}

	public String getDataSpecificAudioMedia() {
		return dataSpecificAudioMedia;
	}

	public void setDataSpecificAudioMedia(String dataSpecificAudioMedia) {
		this.dataSpecificAudioMedia = dataSpecificAudioMedia;
	}

	public String getDataSpecificVideoMedia() {
		return dataSpecificVideoMedia;
	}

	public void setDataSpecificVideoMedia(String dataSpecificVideoMedia) {
		this.dataSpecificVideoMedia = dataSpecificVideoMedia;
	}

	public String getDataSpecificImageMedia() {
		return dataSpecificImageMedia;
	}

	public void setDataSpecificImageMedia(String dataSpecificImageMedia) {
		this.dataSpecificImageMedia = dataSpecificImageMedia;
	}

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
		
		 
		System.out.println("\nTeste: "+ getItems().get(numberID-1).getData()[0].getMedia_type() +"\n");
		
			String conversaoNASA_ID = getItems().get(numberID-1).getData()[0].getNasa_id().replaceAll(" ", "%20");
			String mediaSpecific = "https://images-assets.nasa.gov/" + getItems().get(numberID-1).getData()[0].getMedia_type()+"/"
					+ conversaoNASA_ID + "/" + conversaoNASA_ID;
			
			String media = getItems().get(numberID-1).getData()[0].getMedia_type();
			
			if(media.contentEquals("video")) {
				setDataSpecificVideoMedia(mediaSpecific + "~orig.mp4");
			}else if(media.contentEquals("image")) {
				setDataSpecificImageMedia(mediaSpecific +"~small.jpg");
			}else if(media.contentEquals("audio")) {
				setDataSpecificAudioMedia(mediaSpecific +"~128k.mp3");
			}else {
				System.out.println("Medias desconhecidas");
			}		
	}
	
	public void saveData(int numberID) {
		Data detalhesData = getItems().get(numberID-1).getData()[0];
		save(detalhesData);
	}


}
