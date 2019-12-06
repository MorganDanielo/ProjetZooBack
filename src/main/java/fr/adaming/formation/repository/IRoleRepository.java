package fr.adaming.formation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.adaming.formation.model.Role;

public interface IRoleRepository extends JpaRepository<Role, Long>{

}
