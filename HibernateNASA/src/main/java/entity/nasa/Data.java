package entity.nasa;

import java.util.Date;

public class Data {
	
	
	private String nasa_id;
	private Date date_created;
	private String center;
	private String description;
	private String media_type;
	private String photographer;
	private int numberID;
	
	
	public int getNumberID() {
		return numberID;
	}
	public void setNumberID(int numberID) {
		this.numberID = numberID;
	}
	public String getNasa_id() {
		return nasa_id;
	}
	public void setNasa_id(String nasa_id) {
		this.nasa_id = nasa_id;
	}
	public Date getDate_created() {
		return date_created;
	}
	public void setDate_created(Date date_created) {
		this.date_created = date_created;
	}
	public String getCenter() {
		return center;
	}
	public void setCenter(String center) {
		this.center = center;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getMedia_type() {
		return media_type;
	}
	public void setMedia_type(String media_type) {
		this.media_type = media_type;
	}
	public String getPhotographer() {
		return photographer;
	}
	public void setPhotographer(String photographer) {
		this.photographer = photographer;
	}
	
	
	
}
