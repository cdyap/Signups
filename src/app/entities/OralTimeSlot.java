package app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

@Entity
public class OralTimeSlot {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="pk")
	private Long id;
	
	@ManyToOne
	@JoinTable(name="slot_id")
	private TimeSlot timeS;
	
	public TimeSlot getTimeS() {
		return timeS;
	}

	public void setTimeS(TimeSlot timeS) {
		this.timeS = timeS;
	}

	@Column
	private String name;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
