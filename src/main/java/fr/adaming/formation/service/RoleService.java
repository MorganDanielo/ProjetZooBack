package fr.adaming.formation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import fr.adaming.formation.model.Role;
import fr.adaming.formation.repository.IRoleRepository;
@Service
public class RoleService implements IRoleService{
	
	@Autowired
	IRoleRepository roleRepo;

	@Override
	public Role saveRole(Role role) {
		// TODO Auto-generated method stub
		return roleRepo.save(role);
	}

	@Override
	public Role updateRole(Role role) {
		// TODO Auto-generated method stub
		return roleRepo.save(role);
	}

	@Override
	public Role getRoleById(long idRole) {
		Optional<Role> roleOpt=roleRepo.findById(idRole);
		Role role=new Role();
		if(roleOpt.isPresent()) {
			role=roleOpt.get();
			System.err.println("===="+role+"====");
			return role;
		}else {
			System.err.println("====Rôle Introuvable====");
			return role;
		}
	}

	@Override
	public List<Role> getAllRole() {
		// TODO Auto-generated method stub
		return roleRepo.findAll(Sort.by("idRole"));
	}

	@Override
	public void deleteRole(long idRole) {
		roleRepo.deleteById(idRole);
		
	}

}
