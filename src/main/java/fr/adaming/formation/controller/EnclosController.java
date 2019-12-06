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

import fr.adaming.formation.model.Enclos;
import fr.adaming.formation.service.IEnclosService;
import fr.adaming.formation.service.IZoneService;


@RestController
@RequestMapping("enclos")
@CrossOrigin(origins = "http://localhost:4200")
public class EnclosController {
	
	@Autowired
	IEnclosService enclosService;
	
	@Autowired
	IZoneService zoneService;
	
	@GetMapping
	public List<Enclos> getAllEnclos(){
		return enclosService.getAllEnclos();
	}
	
	@GetMapping("/{idEnclos}")
	public Enclos afficherEnclos(@PathVariable long idEnclos) {
		return enclosService.getEnclosById(idEnclos);
	}
	
	@PostMapping
	public Enclos ajoutEnclos(@RequestBody Enclos enclos) {
		return enclosService.saveEnclos(enclos);
	}
	
	@DeleteMapping("/{idEnclos}")
	public boolean supprimerEnclos(@PathVariable long idEnclos) {
		try {
			enclosService.deleteEnclos(idEnclos);
		}catch (Exception e) {
			return false;
		}
		return true;
	}
	
	@PutMapping("/{idEnclos}")
	public Enclos modifierEnclos(@RequestBody Enclos enclos, @PathVariable long idEnclos) {
		enclos.setIdEnclos(idEnclos);
		return enclosService.saveEnclos(enclos);
	}
	
	@PutMapping("affecterZone/{idZone}/{idEnclos}")
	public void affecterZone(@RequestBody Enclos enclos, @PathVariable long idZone,@PathVariable long idEnclos) {
		enclos.setIdEnclos(idEnclos);
		enclos.setZone(zoneService.getZoneById(idZone));
		enclosService.affecterZoneEnclos(idZone, idEnclos);
	}
}
