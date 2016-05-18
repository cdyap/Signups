package app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository <Student, Long>
{
	//Student findByStudentIdAndPassword(Integer studentid, String password);
	Student findByPasswordAndStudentid(String password, int studentId);
}
