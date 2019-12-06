package fr.adaming.formation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.adaming.formation.model.Etat;

public interface IEtatRepository extends JpaRepository<Etat, Long>{

}
