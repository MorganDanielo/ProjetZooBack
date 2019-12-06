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

import fr.adaming.formation.model.Zone;
import fr.adaming.formation.service.IZoneService;

@RestController
@RequestMapping("zone")
@CrossOrigin(origins = "http://localhost:4200")
public class ZoneController {
	
	@Autowired
	IZoneService zoneService;
	
	@GetMapping
	public List<Zone> getAllZone(){
		return zoneService.getAllZone();
	}
	
	@GetMapping("/{idZone}")
	public Zone afficherZone(@PathVariable long idZone) {
		return zoneService.getZoneById(idZone);
	}
	
	@PostMapping
	public Zone ajoutZone(@RequestBody Zone zone) {
		return zoneService.saveZone(zone);
	}
	@DeleteMapping("/{idZone}")
	public boolean supprimerZone(@PathVariable long idZone) {
		try {
			zoneService.deleteZone(idZone);
		}catch(Exception e) {
			return false;
		}
		return true;
	}
	
	@PutMapping("/{idZone}")
	public Zone modifierZone(@RequestBody Zone zone, @PathVariable long idZone) {
		zone.setIdZone(idZone);
		return zoneService.saveZone(zone);
	}
	
}
