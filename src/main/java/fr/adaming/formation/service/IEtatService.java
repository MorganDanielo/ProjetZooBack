package fr.adaming.formation.service;

import java.util.List;

import fr.adaming.formation.model.Etat;

public interface IEtatService {

	public Etat saveEtat(Etat etat);

	public Etat updateEtat(Etat etat);

	public Etat getEtatById(long idEtat);

	public List<Etat> getAllEtat();

	public void deleteEtat(long idEtat);

}
