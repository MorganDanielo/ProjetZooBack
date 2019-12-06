package fr.adaming.formation.service;

import java.util.List;

import fr.adaming.formation.model.Enclos;

public interface IEnclosService {

	public Enclos saveEnclos(Enclos enclos);

	public Enclos updateEnclos(Enclos enclos);

	public Enclos getEnclosById(long idEnclos);

	public List<Enclos> getAllEnclos();

	public void deleteEnclos(long idEnclos);

	public void affecterZoneEnclos(long idZone, long idEnclos);

}
