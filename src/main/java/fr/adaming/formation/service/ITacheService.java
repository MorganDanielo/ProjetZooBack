package fr.adaming.formation.service;

import java.util.List;

import fr.adaming.formation.model.Tache;

public interface ITacheService {

	public Tache saveTache(Tache tache);

	public Tache updateTache(Tache tache);

	public Tache getTacheById(long idTache);

	public List<Tache> getAllTache();

	public void deleteTache(long idTache);

	public void affecterEtatTache(long idEtat, long idTache);

	public void affecterStaffTache(long idStaff,long idTache);

}
