package fr.adaming.formation.service;

import java.util.List;

import fr.adaming.formation.model.Nourriture;

public interface INourritureService {

	public Nourriture saveNourriture(Nourriture nourriture);

	public Nourriture updateNourriture(Nourriture nourriture);

	public Nourriture getNourritureById(long idNourriture);

	public List<Nourriture> getAll();

	public void deleteNourriture(long idNourriture);

}