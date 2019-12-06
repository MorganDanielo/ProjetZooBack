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

import fr.adaming.formation.model.Etat;
import fr.adaming.formation.service.IEtatService;

@RestController
@RequestMapping("etat")
@CrossOrigin(origins = "http://localhost:4200")
public class EtatController {
	
	@Autowired
	IEtatService etatService;
	
	@GetMapping
	public List<Etat> getAllEtat(){
		return etatService.getAllEtat();
	}
	
	@GetMapping(path="/{idEtat}")
	public Etat afficherEtat(@PathVariable long idEtat) {
		return etatService.getEtatById(idEtat);
	}
	
	@PostMapping
	public Etat ajoutEtat(@RequestBody Etat etat) {
		return etatService.saveEtat(etat);
	}
	
	@DeleteMapping(path="/{idEtat}")
	public boolean supprimerEtat(@PathVariable long idEtat) {
		try {
			etatService.deleteEtat(idEtat);
		}catch (Exception e) {
			return false;
		}
		return true;
	}
	
	@PutMapping(path="/{idEtat}")
	public Etat modifierEtat(@RequestBody Etat etat, @PathVariable long idEtat) {
		etat.setIdEtat(idEtat);
		return etatService.saveEtat(etat);
	}

}
