package fr.adaming.formation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.adaming.formation.model.Tache;

public interface ITacheRepository extends JpaRepository<Tache, Long>{

}
