package fr.adaming.formation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.adaming.formation.model.Animal;

public interface IAnimalRepository extends JpaRepository<Animal, Long>{

}
