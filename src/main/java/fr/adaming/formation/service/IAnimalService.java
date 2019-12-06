package fr.adaming.formation.service;

import java.util.List;

import fr.adaming.formation.model.Animal;

public interface IAnimalService {

	public Animal saveAnimal(Animal animal);

	public Animal updateAnimal(Animal animal);

	public Animal getAnimalById(long idAni);

	public List<Animal> getAllAnimal();

	public void deleteAnimal(long idAni);

	public void affecterNourritureAnimal(long idNou, long idAni);

	public void affecterEnclosAnimal(long idEnclos,long idAni);

}
