package entity.nasa;

import java.util.Date;

import javax.persistence.Column;

public class Data {
	
	@Column
	private String nasa_id;
	
	@Column
	private Date date_created;
	
	
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
