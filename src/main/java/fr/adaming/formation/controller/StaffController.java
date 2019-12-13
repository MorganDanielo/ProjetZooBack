package fr.adaming.formation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.formation.model.Staff;
import fr.adaming.formation.model.Token;
import fr.adaming.formation.service.IRoleService;
import fr.adaming.formation.service.IStaffService;
import fr.adaming.formation.service.IZoneService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;

@RestController
@RequestMapping("staff")
@CrossOrigin(origins = "http://localhost:4200")
public class StaffController {
	
	

	@Autowired
	IStaffService staffService;

	@Autowired
	IRoleService roleService;

	@Autowired
	IZoneService zoneService;

	@GetMapping
	public List<Staff> getAllStaff() {
		return staffService.getAllStaff();
	}

	@GetMapping("/{idStaff}")
	public Staff afficherStaff(@PathVariable long idStaff) {
		return staffService.getStaffById(idStaff);
	}

	@PostMapping
	public Staff ajoutStaff(@RequestBody Staff staff) {
		return staffService.saveStaff(staff);
	}

	@DeleteMapping("/{idStaff}")
	public boolean supprimerStaff(@PathVariable long idStaff) {
		try {
			staffService.deleteStaff(idStaff);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@PutMapping("/{idStaff}")
	public Staff modifierStaff(@RequestBody Staff staff, @PathVariable long idStaff) {
		staff.setIdStaff(idStaff);
		return staffService.saveStaff(staff);
	}

	@PutMapping("affecterRole/{idRole}/{idStaff}")
	public void affecterRole(@RequestBody Staff staff, @PathVariable long idRole, @PathVariable long idStaff) {
		staff.setIdStaff(idStaff);
		staff.setRole(roleService.getRoleById(idRole));
		staffService.affecterRoleStaff(idRole, idStaff);
	}

	@PutMapping("affecterZone/{idZone}/{idStaff}")
	public void affecterZone(@RequestBody Staff staff, @PathVariable long idZone, @PathVariable long idStaff) {
		staff.setIdStaff(idStaff);
		staff.setZone(zoneService.getZoneById(idZone));
		staffService.affecterZoneStaff(idZone, idStaff);
	}

	@GetMapping("exist/{login}")
	public boolean existsStaffByLogin(@PathVariable String login) {
		return staffService.existsStaffByLogin(login);
	}
	@PostMapping("/login")
	public Token findByLoginAndPassword(@RequestBody Staff staff) {
		return staffService.findByLoginAndPassword(staff.getLogin(), staff.getPassword());
		
	}
}
