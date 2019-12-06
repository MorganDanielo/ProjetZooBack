package fr.adaming.formation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import fr.adaming.formation.model.Enclos;
import fr.adaming.formation.model.Zone;
import fr.adaming.formation.repository.IEnclosRepository;
import fr.adaming.formation.repository.IZoneRepository;

@Service
public class EnclosService implements IEnclosService {

	@Autowired
	IEnclosRepository enclosRepo;

	@Autowired
	IZoneRepository zoneRepo;

	@Override
	public Enclos saveEnclos(Enclos enclos) {
		// TODO Auto-generated method stub
		return enclosRepo.save(enclos);
	}

	@Override
	public Enclos updateEnclos(Enclos enclos) {
		// TODO Auto-generated method stub
		return enclosRepo.save(enclos);
	}

	@Override
	public Enclos getEnclosById(long idEnclos) {
		Enclos enclos = new Enclos();
		Optional<Enclos> enclosOpt = enclosRepo.findById(idEnclos);

		if (enclosOpt.isPresent()) {
			enclos = enclosOpt.get();
			System.err.println("====" + enclos + "====");
			return enclos;
		} else {
			System.err.println("====Enclos introuvable====");
			return enclos;
		}
	}

	@Override
	public List<Enclos> getAllEnclos() {
		// TODO Auto-generated method stub
		return enclosRepo.findAll(Sort.by("idEnclos"));
	}

	@Override
	public void deleteEnclos(long idEnclos) {
		enclosRepo.deleteById(idEnclos);

	}

	@Override
	public void affecterZoneEnclos(long idZone, long idEnclos) {
		Optional<Zone> zoneOpt = zoneRepo.findById(idZone);
		Zone zone = new Zone();

		Optional<Enclos> enclosOpt = enclosRepo.findById(idEnclos);
		Enclos enclos = new Enclos();

		if (enclosOpt.isPresent() && zoneOpt.isPresent()) {
			enclos = enclosOpt.get();
			zone = zoneOpt.get();
			enclos.setZone(zone);
			enclosRepo.save(enclos);
			System.err.println("=====Affectation réussie=====");
		} else {
			System.err.println("=====Echec de l'affectation=====");
		}
		

	}

}
