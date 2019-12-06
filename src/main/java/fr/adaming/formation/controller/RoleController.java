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

import fr.adaming.formation.model.Role;
import fr.adaming.formation.service.IRoleService;

@RestController
@RequestMapping("role")
@CrossOrigin(origins = "http://localhost:4200")
public class RoleController {
	
	@Autowired
	IRoleService roleService;
	
	@GetMapping
	public List<Role> getAllRole(){
		return roleService.getAllRole();
	}
	
	@GetMapping("/{idRole}")
	public Role afficherRoleById(@PathVariable long idRole) {
		return roleService.getRoleById(idRole);
	}
	
	@PostMapping
	public Role ajoutRole(@RequestBody Role role) {
		return roleService.saveRole(role);
	}
	
	@DeleteMapping("/{idRole}")
	public boolean supprimerRole(@PathVariable long idRole) {
		try {
			roleService.deleteRole(idRole);
		}catch (Exception e) {
			return false;
		}
		return true;
	}
	
	@PutMapping("/{idRole}")
	public Role modifierRole(@RequestBody Role role, @PathVariable long idRole) {
		role.setIdRole(idRole);
		return roleService.saveRole(role);
	}

}
