package app.rest;

import java.io.Console;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entities.Professor;
import app.entities.Student;
import app.entities.TimeSlot;
import app.repositories.ProfessorRepository;
import app.repositories.StudentRepository;
import app.repositories.TimeSlotRepository;

@Component
@Path("/signups")
public class signupsREST {
	

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
			Long prof_id = Long.parseLong(postData.get("prof_id"));
			
			Random batch = new Random();
			int batchNumber = batch.nextInt(2 - 1 + 1) + 1;
			
			Professor prof = profRep.findOne(prof_id);
			
			if (prof != null) {
				Student newStudent = new Student();
				newStudent.setStudentID(Integer.parseInt(studentID));
				newStudent.setStudentName(studentName);
				newStudent.setSection(section);
				newStudent.setPassword(password.toString());
				newStudent.setBatchNumber(batchNumber);
				newStudent.setClassID(subjCode);
				newStudent.setProf(prof);
				studRep.save(newStudent);
				reply.put("message", studentName + " created under batch " + batchNumber + "!");
			}
			else {
				reply.put("message", "fail!");
			}
			
			
			
		//List <Student> student = studRep.findByName(studentID);
			return reply;
		} catch (Exception e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}		
		
	}
	
	@POST
	@Path("/createprof")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public HashMap<String, String> createprof(HashMap<String, String> postData) {
		HashMap<String, String> reply = new HashMap<String, String>();
		try {
			
			
			String name = postData.get("name");
			String email = postData.get("email");
			String classCode = postData.get("class");
			String password = postData.get("password");
			
			Professor prof = new Professor();
			
			prof.setName(name);
			prof.setEmail(email);
			prof.setPassword(password);
			prof.setSubject(classCode);
			profRep.save(prof);
			reply.put("message", "Success!");
			reply.put("prof_id", profRep.findByName(name).getId().toString());
			
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
//		HashMap<String, String> reply = new HashMap<String, String>();
		try {
			HashMap<String, String> reply = new HashMap<String, String>();
			String idNumber = postData.get("idNumber");
			String password = postData.get("password");
	
			
			Student student = studRep.findByPasswordAndStudentID(password,Integer.parseInt(idNumber));
			
			if (student != null) {
				reply.put("message" ,"success!");
				reply.put("batch", Integer.toString(student.getBatchNumber()));
				reply.put("student_id", student.getId().toString());
			} 
			else {
				reply.put("message", "none");
			}
			System.out.println(reply);
			return reply;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
		
	}
	
	
	@POST
	@Path("/enlist")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public HashMap<String, String> enlist(HashMap<String, String> postData) {
	try {
		HashMap<String, String> reply = new HashMap<String, String>();
		String dateinput = postData.get("date");
		String idNumber = postData.get("idNumber");
		String starttime = postData.get("timeslotCode");
		
		Student student = studRep.findByStudentID(Integer.parseInt(idNumber));
		TimeSlot tm = new TimeSlot();
		
		try {

			//tm.setClassID(student.getClassID().toString());
			
			timeRep.save(tm);
			reply.put("message", "success!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//reply.put("message", d.toString());
		}
		
		
		
		return reply;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		throw e;
	}
	}
}


