package app.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entities.Professor;
import app.entities.Student;
import app.entities.TimeSlot;
import app.repositories.ClassesRepository;
import app.repositories.ProfessorRepository;
import app.repositories.StudentRepository;
import app.repositories.TimeSlotRepository;

@Component
@Path("/signups")
public class signupsREST {
	
	@Autowired
	private ClassesRepository classRep;

	@Autowired
	private ProfessorRepository profRep;
	
	@Autowired
	private StudentRepository studRep;
	
	@Autowired
	private TimeSlotRepository timeRep;
	
	@POST
	@Path("/createsubject")
	//@Produces(MediaType.APPLICATION_JSON)
	public HashMap<String, String> createsubject(HashMap<String, String> postData) {
	String profID = postData.get("profID");
	String subjName = postData.get("subjName");
	String subjCode = postData.get("subjCode");

	HashMap<String, String> reply = new HashMap<String, String>();
	//List <Professor> professor = profRep.findByName(profID);
	return reply;
	}
	
	@POST
	@Path("/createaccount")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public HashMap<String, String> createaccount(HashMap<String, String> postData) {
		HashMap<String, String> reply = new HashMap<String, String>();
		try {
			
			String studentID = postData.get("idNumber");
			String studentName = postData.get("name");
			String subjCode = postData.get("subject");
			String section = postData.get("section");
			String password = postData.get("password");
			Random batch = new Random();
			int batchNumber = batch.nextInt(2 - 1 + 1) + 1;
			
			Student newStudent = new Student();
			newStudent.setStudentID(Integer.parseInt(studentID));
			newStudent.setStudentName(studentName);
			newStudent.setSection(section);
			newStudent.setPassword(password.toString());
			newStudent.setBatchNumber(batchNumber);
			newStudent.setClassID(subjCode);
			studRep.save(newStudent);
			reply.put("message", batchNumber + studentName + " found!");
			
		//List <Student> student = studRep.findByName(studentID);
			return reply;
		} catch (Exception e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}		
		
	}
	
	@POST
	@Path("/createtimeslots")
	//@Produces(MediaType.APPLICATION_JSON)
	public HashMap<String, String> createtimeslots(HashMap<String, String> postData) {
	String subjCode = postData.get("subjCode");
	String timeSlots = postData.get("timeSlots");

	HashMap<String, String> reply = new HashMap<String, String>();
	//List <TimeSlot> professor = timeRep.findByName(timeSlots);
	
	return reply;
	}
	
	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public HashMap<String, String> login (HashMap<String, String> postData) {
		
		try {
			HashMap<String, String> reply = new HashMap<String, String>();
			String idNumber = postData.get("subjCode");
			String password = postData.get("timeSlots");
	
			
			Student student = studRep.findByPasswordAndStudentID(password,Integer.parseInt(idNumber));
			
			if (student != null) {
				reply.put("message" ,"success!");
			} 
			else {
				reply.put("message", "none");
			}
			return reply;
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
		
	}
	
	@POST
	@Path("/enlist")
	//@Produces(MediaType.APPLICATION_JSON)
	public HashMap<String, String> enlist(HashMap<String, String> postData) {
	String studentID = postData.get("studentID");
	String subjCode = postData.get("subjCode");
	String section = postData.get("section");
	String timeSlots = postData.get("timeSlots");

	HashMap<String, String> reply = new HashMap<String, String>();
	//List <TimeSlot> professor = timeRep.findByName(timeSlots);
	
	return reply;
	}
}


