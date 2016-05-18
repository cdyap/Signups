package app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entities.TimeSlot;


@Repository
public interface TimeSlotRepository extends JpaRepository <TimeSlot, Long>
{
	//public List<TimeSlot> findByName(String t);
}
