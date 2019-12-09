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

import fr.adaming.formation.model.Tache;
import fr.adaming.formation.service.IEtatService;
import fr.adaming.formation.service.IStaffService;
import fr.adaming.formation.service.ITacheService;

@RestController
@RequestMapping("tache")
@CrossOrigin(origins = "http://localhost:4200")
public class TacheController {

	@Autowired
	ITacheService tacheService;

	@Autowired
	IStaffService staffService;

	@Autowired
	IEtatService etatService;

	@GetMapping
	public List<Tache> getAllTache() {
		return tacheService.getAllTache();
	}

	@GetMapping("/{idTache}")
	public Tache afficherTache(@PathVariable long idTache) {
		return tacheService.getTacheById(idTache);
	}

	@PostMapping
	public Tache ajoutTache(@RequestBody Tache tache) {
		return tacheService.saveTache(tache);
	}
	
	@DeleteMapping("/{idTache}")
	public boolean supprimerTache(@PathVariable long idTache) {
		try {
			tacheService.deleteTache(idTache);
		}catch (Exception e) {
			return false;
		}
		return true;
	}
	
	@PutMapping("/{idTache}")
	public Tache modifierTache(@RequestBody Tache tache, @PathVariable long idTache) {
		tache.setIdTache(idTache);
		return tacheService.saveTache(tache);
	}
	
	@PutMapping("affecterEtat/{idEtat}/{idTache}")
	public void affecterEtat (@RequestBody Tache tache, @PathVariable long idEtat,@PathVariable long idTache) {
		tache.setIdTache(idTache);
		tache.setEtat(etatService.getEtatById(idEtat));
		tacheService.affecterEtatTache(idEtat, idTache);		
	}
	@PutMapping("affecterStaff/{idStaff}/{idTache}")
	public void affecterStaff (@RequestBody Tache tache, @PathVariable long idStaff,@PathVariable long idTache) {
		tache.setIdTache(idTache);
		tache.setStaff(staffService.getStaffById(idStaff));
		tacheService.affecterStaffTache(idStaff, idTache);		
	}
}
