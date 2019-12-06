package fr.adaming.formation.service;

import java.util.List;

import fr.adaming.formation.model.Animal;

public interface IAnimalService {

	public Animal saveAnimal(Animal animal);

	public Animal updateAnimal(Animal animal);

	public Animal getAnimalById(long idAnimal);

	public List<Animal> getAllAnimal();

	public void deleteAnimal(long idAnimal);

	public void affecterNourritureAnimal(long idNou, long idAnimal);

	public void affecterAnimalEnclos(long idAni, long idEnclos);

}
