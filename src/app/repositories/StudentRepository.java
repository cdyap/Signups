package app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import app.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository <Student, Long>
{
	//Student findByStudentIdAndPassword(Integer studentid, String password);
	//@Query("SELECT * FROM student where studentid = :studentId AND password LIKE (':password')") 
	public Student findByPasswordAndStudentID(String password, int studentId);
}
