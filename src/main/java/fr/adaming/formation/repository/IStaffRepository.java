package fr.adaming.formation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.adaming.formation.model.Staff;

public interface IStaffRepository extends JpaRepository<Staff, Long>{
	
	public List<Staff> findByLogin(String login);
	
	public boolean existsStaffByLogin(String login);
	
	public Staff findByLoginAndPassword(String login, String password);

}
