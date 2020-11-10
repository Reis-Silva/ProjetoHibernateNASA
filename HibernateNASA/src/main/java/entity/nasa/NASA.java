package entity.nasa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class NASA {
	
	@Id @GeneratedValue
	private int id;
	
	private Items[] items;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Items[] getItems() {
		return items;
	}

	public void setItems(Items[] items) {
		this.items = items;
	}
	
	

}
