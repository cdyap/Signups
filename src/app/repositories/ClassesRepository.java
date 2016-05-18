package app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import app.entities.Classes;

@Repository
public interface ClassesRepository extends JpaRepository <Classes, Long>
{
	//public List<Classes> findByName(String c);
}
