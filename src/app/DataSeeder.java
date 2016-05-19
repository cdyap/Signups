package app;


import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import app.entities.TimeSlot;
import app.repositories.TimeSlotRepository;

@Profile("dataSeeder")
@Component
public class DataSeeder
{
	@Autowired
	private TimeSlotRepository timeslotRep;
	
	@PostConstruct
	public void run() throws Exception
	{
		TimeSlot t1 = new TimeSlot();
		t1.setStartTime("7:00am");
		t1.setEndTime("7:10am");
		timeslotRep.save(t1);
		
		TimeSlot t2 = new TimeSlot();
		t2.setStartTime("7:10am");
		t2.setEndTime("7:20am");
		timeslotRep.save(t2);
		
		TimeSlot t3 = new TimeSlot();
		t3.setStartTime("7:20am");
		t3.setEndTime("7:30am");
		timeslotRep.save(t3);
		
		TimeSlot t4 = new TimeSlot();
		t4.setStartTime("7:30am");
		t4.setEndTime("7:40am");
		timeslotRep.save(t4);
		
		TimeSlot t5 = new TimeSlot();
		t5.setStartTime("7:40am");
		t5.setEndTime("7:50am");
		timeslotRep.save(t5);
		
		TimeSlot t6 = new TimeSlot();
		t6.setStartTime("7:50am");
		t6.setEndTime("8:00am");
		timeslotRep.save(t6);
		
		TimeSlot t7 = new TimeSlot();
		t7.setStartTime("8:00am");
		t7.setEndTime("8:10am");
		timeslotRep.save(t7);
		
		TimeSlot t8 = new TimeSlot();
		t8.setStartTime("8:10am");
		t8.setEndTime("8:20am");
		timeslotRep.save(t8);
		
		TimeSlot t9 = new TimeSlot();
		t9.setStartTime("8:20am");
		t9.setEndTime("8:30am");
		timeslotRep.save(t9);
		
		TimeSlot t10 = new TimeSlot();
		t10.setStartTime("8:30am");
		t10.setEndTime("8:40am");
		timeslotRep.save(t10);
		
		
	}
}