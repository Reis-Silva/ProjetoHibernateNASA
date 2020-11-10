package entity.nasa;

import java.util.Date;

public class Data {
	
	
	private String nasa_id;
	
	private Date date_created;
	
	private String center;
	
	public String getCenter() {
		return center;
	}
	public void setCenter(String center) {
		this.center = center;
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
	
	
}
