package app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import app.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository <Student, Long>
{
	public Student findByPasswordAndStudentID(String password, int studentId);
	public Student findByStudentID(int studentId);
}
