package fr.adaming.formation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import fr.adaming.formation.model.Role;
import fr.adaming.formation.model.Staff;
import fr.adaming.formation.model.Zone;
import fr.adaming.formation.repository.IRoleRepository;
import fr.adaming.formation.repository.IStaffRepository;
import fr.adaming.formation.repository.IZoneRepository;

public class StaffService implements IStaffService{
	
	@Autowired
	IStaffRepository staffRepo;
	
	@Autowired
	IRoleRepository roleRepo;
	
	@Autowired
	IZoneRepository zoneRepo;

	@Override
	public Staff saveStaff(Staff staff) {
		return staffRepo.save(staff);
	}

	@Override
	public Staff updateStaff(Staff staff) {
		return staffRepo.save(staff);
	}

	@Override
	public Staff getStaffById(long idStaff) {
		Staff staff=new Staff();
		Optional<Staff> staffOpt=staffRepo.findById(idStaff);
		
		if(staffOpt.isPresent()) {
			staff=staffOpt.get();
			System.err.println("===="+staff+"====");
			return staff;
		}else {
			System.err.println("====Staff introuvable====");
			return staff;
		}
		
	}

	@Override
	public List<Staff> getAllStaff() {
		return staffRepo.findAll();
	}

	@Override
	public void deleteStaff(long idStaff) {
		staffRepo.deleteById(idStaff);
		
	}

	@Override
	public void affecterRoleStaff(long idRole, long idStaff) {
		Role role = new Role();
		Optional<Role> roleOpt=roleRepo.findById(idRole);
		
		Staff staff= new Staff();
		Optional<Staff> staffOpt=staffRepo.findById(idStaff);
		
		if(roleOpt.isPresent() && staffOpt.isPresent()) {
			role=roleOpt.get();
			staff=staffOpt.get();
			staff.setRole(role);
			staffRepo.save(staff);
			System.err.println("=====Affectation réussie=====");
		}else {
			System.err.println("=====Echec de l'affectation=====");
		}
					
	}

	@Override
	public void affecterZoneStaff(long idZone, long idStaff) {
		Staff staff= new Staff();
		Optional<Staff> staffOpt=staffRepo.findById(idStaff);
		
		Zone zone = new Zone();
		Optional<Zone> zoneOpt=zoneRepo.findById(idZone);
		
		if(staffOpt.isPresent() && zoneOpt.isPresent()) {
			zone=zoneOpt.get();
			staff=staffOpt.get();
			staff.setZone(zone);
			staffRepo.save(staff);
			System.err.println("=====Affectation réussie=====");
		}else {
			System.err.println("=====Echec de l'affectation=====");
		}
	}

	@Override
	public List<Staff> findByLogin(String login) {
		// TODO Auto-generated method stub
		return staffRepo.findByLogin(login);
	}

	@Override
	public boolean existsStaffByLogin(String login) {
		// TODO Auto-generated method stub
		return staffRepo.existsStaffByLogin(login);
	}

	@Override
	public Staff findByLoginAndPassword(String login, String password) {
		Staff staff=staffRepo.findByLoginAndPassword(login, password);
		if(staff!=null) {
			staff.setPassword("");
			return staff;
		}else {
			return new Staff();
		}
	}

}
