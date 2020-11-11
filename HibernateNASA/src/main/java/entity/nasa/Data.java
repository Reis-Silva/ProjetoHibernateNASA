package entity.nasa;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "data")
public class Data {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String nasa_id;
	@Column
	private Date date_created;
	@Column(nullable = true)
	private String center;
	@Transient
	private String description;
	@Column(nullable = true)
	private String media_type;
	@Column(nullable = true)
	private String photographer;
	@Column
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
