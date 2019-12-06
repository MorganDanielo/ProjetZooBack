package fr.adaming.formation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.adaming.formation.model.Nourriture;

public interface INourritureRepository extends JpaRepository<Nourriture, Long>{

}
