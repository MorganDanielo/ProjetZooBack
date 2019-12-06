package fr.adaming.formation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import fr.adaming.formation.model.Etat;
import fr.adaming.formation.model.Tache;
import fr.adaming.formation.repository.IEtatRepository;
import fr.adaming.formation.repository.IStaffRepository;
import fr.adaming.formation.repository.ITacheRepository;

@Service
public class TacheService implements ITacheService{
	
	@Autowired
	ITacheRepository tacheRepo;
	
	@Autowired
	IEtatRepository etatRepo;
	
	@Autowired
	IStaffRepository staffRepo;

	@Override
	public Tache saveTache(Tache tache) {
		// TODO Auto-generated method stub
		return tacheRepo.save(tache);
	}

	@Override
	public Tache updateTache(Tache tache) {
		// TODO Auto-generated method stub
		return tacheRepo.save(tache);
	}

	@Override
	public Tache getTacheById(long idTache) {
		Optional<Tache> tacheOpt=tacheRepo.findById(idTache);
		Tache tache=new Tache();
		if(tacheOpt.isPresent()) {
			tache=tacheOpt.get();
			System.err.println("===="+tache+"====");
			return tache;
		}else {
			System.err.println("====Tâche introuvable====");
			return tache;
		}
	}

	@Override
	public List<Tache> getAllTache() {
		// TODO Auto-generated method stub
		return tacheRepo.findAll(Sort.by("idTache"));
	}

	@Override
	public void deleteTache(long idTache) {
		tacheRepo.deleteById(idTache);
		
	}

	@Override
	public Tache affecterEtatTache(long idEtat, long idTache) {
		Optional<Etat> etatOpt=etatRepo.findById(idEtat);
		Etat etat = new Etat();
		
		Optional<Tache> tacheOpt=tacheRepo.findById(idTache);
		Tache tache=new Tache();	
		
		if(etatOpt.isPresent()&&tacheOpt.isPresent()) {
			etat=etatOpt.get();
			tache=tacheOpt.get();
			tache.setEtat(etat);
			System.err.println("====Affectation réussie====");			
		}else {
			System.err.println("====Echec de l'affectation====");
		}
		return tacheRepo.save(tache);
	}

	@Override
	public void affecterStaffTache(long idStaff, long idTache) {
		// TODO Auto-generated method stub
		
	}
	
	

}
