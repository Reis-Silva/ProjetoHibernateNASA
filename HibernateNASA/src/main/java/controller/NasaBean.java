package controller;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.SelectEvent;

import dao.NASADAOJPA;
import entity.nasa.Data;
import entity.nasa.Items;

@ViewScoped
@ManagedBean
public class NasaBean extends NASADAOJPA implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("rawtypes")
	public void onRowSelect(SelectEvent event) {
		Items items =  (Items) (event.getObject());
		setData(items.getData()[0]);
		dataSpecificSelectionMedia(getData().getMedia_type(),"");
    }
	
	@SuppressWarnings({ "rawtypes", "unchecked", "hiding" })
	public <Data> void onRowSelectStorage(SelectEvent event) {
		Data storage =  (Data) (event.getObject());
		setStorageSelection((entity.nasa.Data) storage);
		String media = getStorageSelection().getMedia_type();
		dataSpecificSelectionMedia(media,"");
    }
	
	public void dataSpecificSelectionMedia(String media,String selection) {
		if(media.contentEquals("video")) {
			setDataSpecificSelection("PF('detailsvideodata').show();");
			selectionBtn(selection);
		}else if(media.contentEquals("image")) {
			setDataSpecificSelection("PF('detailsimagedata').show();");
			selectionBtn(selection);
		}else if(media.contentEquals("audio")) {
			setDataSpecificSelection("PF('detailsaudiodata').show();");
			selectionBtn(selection);
		}else {
			System.out.println("Nenhuma das Opções");
		}
	}
	
	public void selectionBtn(String selection) {
		if(selection.equals("detailsbtn")) {
			setSelectionDetailsDescription(getData().getDescription());
			setSelectionDetailsID(getData().getNasa_id());
			detalhesData();
		}else if(selection.equals("storagedetailsbtn")) {
			setSelectionDetailsDescription(getStorageSelection().getDescription());
			setSelectionDetailsID(getStorageSelection().getNasa_id());
			if(getStorageSelection().getMedia_type().contentEquals("video")) {
				setDataSpecificVideoMedia(getStorageSelection().getMediaLink());
			}else if(getStorageSelection().getMedia_type().contentEquals("image")){
				setDataSpecificImageMedia(getStorageSelection().getMediaLink());
			}else if(getStorageSelection().getMedia_type().contentEquals("audio")){
				setDataSpecificAudioMedia(getStorageSelection().getMediaLink());
			}else {
				System.out.println("Nenhuma das Opções");
			}
		}else {
			System.out.println("\nNenhum botão details foi pressionado\n");
		}
	}
	
	public void btnAction(String selection) {
			if (selection.equals("detailsbtn")) {
				if (getData().getMedia_type() == null) {
					System.out.println("\nSelecione um NASA ID\n");
					messageView(false, "Select a NASA ID!");
				} else {
					String media = getData().getMedia_type();
					dataSpecificSelectionMedia(media, selection);
				}

			} else if (selection.equals("storagedetailsbtn")) {
				if (getStorageSelection().getMedia_type() == null) {
					System.out.println("\nSelecione um NASA ID\n");
					messageView(false, "Select a NASA ID!");
				} else {
					String media = getStorageSelection().getMedia_type();
					dataSpecificSelectionMedia(media, selection);
				}
			} else {
				System.out.println("\nNenhum botão selecionado\n");
			}
		}
	
	public void close() {
		setDataSpecificSelection(null);
		setData(new Data());
		setStorageSelection(new Data());
		setSelectionDetailsDescription(null);
		setSelectionDetailsID(null);
	}
	
	@PostConstruct
	public void init() {
		buscarDadosNasa();
	}
	
}
