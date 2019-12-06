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


import fr.adaming.formation.model.Nourriture;
import fr.adaming.formation.service.INourritureService;

@RestController
@RequestMapping("nourriture")
@CrossOrigin(origins = "http://localhost:4200")
public class NourritureController {
	
	@Autowired
	INourritureService nouService;
	
	@GetMapping
	public List<Nourriture> getAllNourriture(){
		return nouService.getAllNourriture();
	}
	
	@GetMapping(path="/{idNou}")
	public Nourriture afficherNou(@PathVariable long idNou) {
		return nouService.getNourritureById(idNou);
	}
	
	@PostMapping
	public Nourriture ajoutNourriture(@RequestBody Nourriture nourriture) {
		return nouService.saveNourriture(nourriture);
	}
	
	@DeleteMapping(path="/{idNou}")
	public boolean supprimerNourriture(@PathVariable long idNou) {
		try {
			nouService.deleteNourriture(idNou);
		}catch (Exception e) {
			return false;
		}
		return true;
	}
	
	@PutMapping(path="/{idNou}")
	public Nourriture modifierNourriture(@RequestBody Nourriture nourriture, @PathVariable long idNou) {
		nourriture.setIdNou(idNou);
		return nouService.saveNourriture(nourriture);
	}
	

}
