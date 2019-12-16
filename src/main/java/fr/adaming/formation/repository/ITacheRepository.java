package fr.adaming.formation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.adaming.formation.model.Staff;
import fr.adaming.formation.model.Tache;

public interface ITacheRepository extends JpaRepository<Tache, Long> {

	@Query("select tache from Tache tache where tache.staff= :staff")
	public List<Tache> getTacheByStaff(@Param("staff")Staff staff);

}
