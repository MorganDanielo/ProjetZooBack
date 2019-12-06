package fr.adaming.formation.service;

import java.util.List;

import fr.adaming.formation.model.Enclos;

public interface IEnclosService {

	public Enclos saveEnclos(Enclos enclos);

	public Enclos updateEnclos(Enclos enclos);

	public Enclos getEnclosById(long idEnclos);

	public List<Enclos> getAll();

	public void deleteEnclos(long idEnclos);

	public void affecterAnimalEnclos(long idAni, long idEnclos);
}
