package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import app.entities.OralTimeSlot;
import app.entities.TimeSlot;

@Repository
public interface OralTimeRepository extends JpaRepository <OralTimeRepository, Long> {
	
	//@Query("SELECT * from oraltimeslot WHERE name = ?1")
	OralTimeSlot findByName(String name);
	
}
