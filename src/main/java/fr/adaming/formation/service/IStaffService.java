package fr.adaming.formation.service;

import java.util.List;

import fr.adaming.formation.model.Staff;
import fr.adaming.formation.model.Token;

public interface IStaffService {

	public Staff saveStaff(Staff staff);

	public Staff updateStaff(Staff staff);

	public Staff getStaffById(long idStaff);

	public List<Staff> getAllStaff();

	public void deleteStaff(long idStaff);

	public void affecterRoleStaff(long idRole, long idStaff);

	public void affecterZoneStaff(long idZone, long idStaff);

	public List<Staff> findByLogin(String login);

	public boolean existsStaffByLogin(String login);

	public Token findByLoginAndPassword(String login, String password);

}
