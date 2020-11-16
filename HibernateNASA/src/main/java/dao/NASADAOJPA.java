package dao;

import java.util.List;
import javax.inject.Inject;
import entity.nasa.Data;
import entity.nasa.Items;
import entity.nasa.NASA;
import webservice.WEBService;

public class NASADAOJPA extends DAOJPA<Data, Integer> implements NASADAO<Data, Integer>{
	
	private static final Class<Data> dataClass = Data.class;
	
	@Inject
	private NASA dados;
	
	@Inject
	private Data data = new Data();
	
	List<Data> datastorage;
	
	private Data storageSelection= new Data();
	
	private String dataSpecificVideoMedia = "http://images-assets.nasa.gov/video/Apollo 11 Overview/Apollo 11 Overview~mobile.mp4";
	private String dataSpecificImageMedia;
	private String dataSpecificAudioMedia = "https://images-assets.nasa.gov/audio/Apollo11Highlights/Apollo11Highlights~128k.mp3";
	private String dataSpecificSelection;
	
	private List<Items> mediaNASA;
	
	@Inject
	private List<Items> items;
	
	private List<Items> itemsSelection;
	
	public NASA getDados() {
		return dados;
	}

	public void setDados(NASA dados) {
		this.dados = dados;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public List<Data> getDatastorage() {
		return datastorage;
	}

	public void setDatastorage(List<Data> datastorage) {
		this.datastorage = datastorage;
	}

	public Data getStorageSelection() {
		return storageSelection;
	}

	public void setStorageSelection(Data storageSelection) {
		this.storageSelection = storageSelection;
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

	public String getDataSpecificAudioMedia() {
		return dataSpecificAudioMedia;
	}

	public void setDataSpecificAudioMedia(String dataSpecificAudioMedia) {
		this.dataSpecificAudioMedia = dataSpecificAudioMedia;
	}

	public String getDataSpecificSelection() {
		return dataSpecificSelection;
	}

	public void setDadaSpecificSelection(String dataSpecificSelection) {
		this.dataSpecificSelection = dataSpecificSelection;
	}

	public List<Items> getMediaNASA() {
		return mediaNASA;
	}

	public void setMediaNASA(List<Items> mediaNASA) {
		this.mediaNASA = mediaNASA;
	}

	public List<Items> getItems() {
		return items;
	}

	public void setItems(List<Items> items) {
		this.items = items;
	}

	public List<Items> getItemsSelection() {
		return itemsSelection;
	}

	public void setItemsSelection(List<Items> itemsSelection) {
		this.itemsSelection = itemsSelection;
	}

	public static Class<Data> getDataclass() {
		return dataClass;
	}

	public void buscarDadosNasa() {
		try {
			if(WEBService.listarDadosNASA() == null) {
				System.out.println("\nServidor Inativo\n");
				messageView(false, "Inactive Server");
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
	
	public void detalhesData() {		
		if(getData().getNumberID() == null) {
			System.out.println("\nSelecione um NASA ID\n");
			messageView(false, "Select a NASA ID!");
		}else {
			String conversaoNASA_ID = getItems().get(getData().getNumberID() - 1).getData()[0].getNasa_id().replaceAll(" ", "%20");
			String mediaSpecific = "https://images-assets.nasa.gov/"
					+ getItems().get(getData().getNumberID() - 1).getData()[0].getMedia_type() + "/" + conversaoNASA_ID + "/"
					+ conversaoNASA_ID;

			String media = getItems().get(getData().getNumberID() - 1).getData()[0].getMedia_type();

			if (media.contentEquals("video")) {
				setDataSpecificVideoMedia(mediaSpecific + "~orig.mp4");
				getItems().get(getData().getNumberID()-1).getData()[0].setMediaLink(getDataSpecificVideoMedia());
			} else if (media.contentEquals("image")) {
				setDataSpecificImageMedia(mediaSpecific + "~small.jpg");
				getItems().get(getData().getNumberID()-1).getData()[0].setMediaLink(getDataSpecificImageMedia());
			} else if (media.contentEquals("audio")) {
				setDataSpecificAudioMedia(mediaSpecific + "~128k.mp3");
				getItems().get(getData().getNumberID()-1).getData()[0].setMediaLink(getDataSpecificAudioMedia());
			} else {
				System.out.println("Medias desconhecidas");
				messageView(false, "Unknown media");
			}	
		}	
	}
	
	public void saveData() {
		if(getData().getNumberID() == null) {
			System.out.println("\nSelecione um NASA ID\n");
			messageView(false, "Select a NASA ID!");
		}else {
			Data detalhesData = getItems().get(getData().getNumberID()-1).getData()[0];
			List<Data> saveConfirmation = search(dataClass);
			boolean verification = false;
			
			for(int i = 0; i < saveConfirmation.size(); i++) {
				if(saveConfirmation.get(i).toString().contains("numberID=" + Integer.toString(getData().getNumberID())) == true) {
					verification = true;
					System.out.println("\nEste registro já está salvo no banco de dados\n");
					break;
				}else {
					System.out.println("\nVerificando...\n");
				}
			}
			
			if(verification == false) {
				save(detalhesData);
			}else {
				messageView(false, "This record is already saved in the database!");
			}
		}
			
	}

	public void buscarDataStorage(){
		setDatastorage(search(dataClass));
	}
	
	public void removeStrorage() {
		if(getStorageSelection().getNumberID() == null) {
			System.out.println("\nSelecione um NASA ID\n");
			messageView(false, "Select a NASA ID!");
		}else {
			remove(dataClass, getStorageSelection().getId());
			buscarDataStorage();
		}
	}

}
