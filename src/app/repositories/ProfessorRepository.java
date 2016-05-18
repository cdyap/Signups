package app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import app.entities.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository <Professor, Long>
{
	//public List<Professor> findByName(String p);
}
