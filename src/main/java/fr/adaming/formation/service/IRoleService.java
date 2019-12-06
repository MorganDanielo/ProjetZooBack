package fr.adaming.formation.service;

import java.util.List;

import fr.adaming.formation.model.Role;

public interface IRoleService {

	public Role saveRole(Role role);

	public Role updateRole(Role role);

	public Role getRoleById(long idRole);

	public List<Role> getAll();

	public void deleteRole(long idRole);
}