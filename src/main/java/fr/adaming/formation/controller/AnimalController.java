package fr.adaming.formation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.formation.model.Animal;
import fr.adaming.formation.service.IAnimalService;
import fr.adaming.formation.service.IEnclosService;
import fr.adaming.formation.service.INourritureService;

@RestController
@RequestMapping("animal")
@CrossOrigin(origins = "http://localhost:4200")
public class AnimalController {
	
	@Autowired
	IAnimalService animalService;
	
	@Autowired
	IEnclosService enclosService;
	
	@Autowired
	INourritureService nouService;
	
	@GetMapping
	public List<Animal> getAllAnimal(){
		return animalService.getAllAnimal();
	}
	
	@GetMapping("/{idAni}")
	public Animal afficherAnimal(@PathVariable long idAni) {
		return animalService.getAnimalById(idAni);
	}
	
	@PostMapping
	public Animal ajoutAnimal(@RequestBody Animal animal) {
		return animalService.saveAnimal(animal);
	}
	
	@DeleteMapping("/{idAni}")
	public boolean supprimerAnimal(@PathVariable long idAni) {
		try {
			animalService.deleteAnimal(idAni);
		}catch (Exception e) {
			return false;
		}
		return true;
	}
	
	@PutMapping("/{idAni}")
	public Animal modifierAnimal(@RequestBody Animal animal, @PathVariable long idAni) {
		animal.setIdAni(idAni);
		return animalService.saveAnimal(animal);
	}
	
	@PutMapping("/affecterEnclos/{idEnclos}/{idAni}")
	public void affecterEnclos(@RequestBody Animal animal, @PathVariable long idEnclos, @PathVariable long idAni) {
		animal.setIdAni(idAni);
		animal.setEnclos(enclosService.getEnclosById(idEnclos));
		animalService.affecterEnclosAnimal(idEnclos, idAni);
	}
	
	@PutMapping("/affecterNourriture/{idNou}/{idAni}")
	public void affecterNourriture(@RequestBody Animal animal, @PathVariable long idNou, @PathVariable long idAni) {
		animal.setIdAni(idAni);
		animal.setNourriture(nouService.getNourritureById(idNou));
		animalService.affecterNourritureAnimal(idNou, idAni);
	}

}
