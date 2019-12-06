package fr.adaming.formation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.formation.model.Animal;
import fr.adaming.formation.model.Enclos;
import fr.adaming.formation.model.Nourriture;
import fr.adaming.formation.repository.IAnimalRepository;
import fr.adaming.formation.repository.IEnclosRepository;
import fr.adaming.formation.repository.INourritureRepository;
@Service
public class AnimalService implements IAnimalService{
	
	@Autowired
	IAnimalRepository animalRepo;
	
	@Autowired
	IEnclosRepository enclosRepo;
	
	@Autowired
	INourritureRepository nouRepo;

	@Override
	public Animal saveAnimal(Animal animal) {
		
		return animalRepo.save(animal);
	}

	@Override
	public Animal updateAnimal(Animal animal) {
		
		return animalRepo.save(animal);
	}

	@Override
	public Animal getAnimalById(long idAni) {
		Animal animal = new Animal();
		Optional<Animal> animalOpt=animalRepo.findById(idAni);
		
		if(animalOpt.isPresent()) {
			animal=animalOpt.get();
			System.err.println("===="+animal+"====");
			return animal;
		}else {
			System.err.println("====Animal Introuvable====");
			return animal;
		}
	}

	@Override
	public List<Animal> getAllAnimal() {
		
		return animalRepo.findAll();
	}

	@Override
	public void deleteAnimal(long idAni) {
		animalRepo.deleteById(idAni);
		
	}

	@Override
	public void affecterNourritureAnimal(long idNou, long idAni) {
		Animal animal = new Animal();
		Optional<Animal> animalOpt=animalRepo.findById(idAni);
		
		Nourriture nourriture= new Nourriture();
		Optional<Nourriture> nouOpt=nouRepo.findById(idNou);
		
		if(nouOpt.isPresent() && animalOpt.isPresent()) {
			nourriture=nouOpt.get();
			animal=animalOpt.get();
			animal.setNourriture(nourriture);
			animalRepo.save(animal);
			System.err.println("=====Affectation réussie=====");
		}else {
			System.err.println("=====Echec de l'affectation=====");
		}
		
		
	}

	@Override
	public void affecterEnclosAnimal(long idEnclos, long idAni) {
		Animal animal = new Animal();
		Optional<Animal> animalOpt=animalRepo.findById(idAni);
		
		Enclos enclos = new Enclos();
		Optional<Enclos> enclosOpt=enclosRepo.findById(idEnclos);
		
		if(animalOpt.isPresent() && enclosOpt.isPresent()) {
			enclos=enclosOpt.get();
			animal=animalOpt.get();
			animal.setEnclos(enclos);
			animalRepo.save(animal);
			System.err.println("=====Affectation réussie=====");
		}else {
			System.err.println("=====Echec de l'affectation======");
		}
		
	}

}
