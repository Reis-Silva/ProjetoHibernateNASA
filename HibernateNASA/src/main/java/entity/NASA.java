package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class NASA {
	
	@Id @GeneratedValue
	private int id;
	
	private String nasa_id;

}
