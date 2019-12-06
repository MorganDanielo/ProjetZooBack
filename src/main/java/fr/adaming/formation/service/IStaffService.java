package fr.adaming.formation.service;

import java.util.List;

import fr.adaming.formation.model.Staff;

public interface IStaffService {

	public Staff saveStaff(Staff staff);

	public Staff updateStaff(Staff staff);

	public Staff getStaffById(long idStaff);

	public List<Staff> getAll();

	public void deleteStaff(long idStaff);

	public void affecterTacheStaff(long idTache, long idStaff);

	public void affecterRoleStaff(long idRole, long idStaff);

	public void affecterZoneStaff(long idZone, long idStaff);

}
