package fr.adaming.formation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import fr.adaming.formation.model.Etat;
import fr.adaming.formation.repository.IEtatRepository;

@Service
public class EtatService implements IEtatService{
	
	@Autowired
	IEtatRepository etatRepo;

	@Override
	public Etat saveEtat(Etat etat) {
		// TODO Auto-generated method stub
		return etatRepo.save(etat);
	}

	@Override
	public Etat updateEtat(Etat etat) {
		// TODO Auto-generated method stub
		return etatRepo.save(etat);
	}

	@Override
	public Etat getEtatById(long idEtat) {
		Optional<Etat> etatOpt=etatRepo.findById(idEtat);
		Etat etat=new Etat();
		if(etatOpt.isPresent()) {
			etat=etatOpt.get();
			System.err.println("===="+etat+"====");
			return etat;
		}else {
		System.err.println("====Etat introuvable====");
		return etat;
		}
		
	}

	@Override
	public List<Etat> getAllEtat() {
		// TODO Auto-generated method stub
		return etatRepo.findAll(Sort.by("idEtat"));
	}

	@Override
	public void deleteEtat(long idEtat) {
		etatRepo.deleteById(idEtat);
		
	}

}
