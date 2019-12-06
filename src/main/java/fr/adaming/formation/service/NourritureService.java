package fr.adaming.formation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import fr.adaming.formation.model.Nourriture;
import fr.adaming.formation.repository.INourritureRepository;
@Service
public class NourritureService implements INourritureService {
	
	@Autowired
	INourritureRepository nouRepository;
	

	@Override
	public Nourriture saveNourriture(Nourriture nourriture) {
		// TODO Auto-generated method stub
		return nouRepository.save(nourriture);
	}

	@Override
	public Nourriture updateNourriture(Nourriture nourriture) {
		// TODO Auto-generated method stub
		return nouRepository.save(nourriture);
	}

	@Override
	public Nourriture getNourritureById(long idNou) {
		Optional<Nourriture> nouOpt=nouRepository.findById(idNou);
		Nourriture nou = new Nourriture();
		if(nouOpt.isPresent()) {
			nou=nouOpt.get();
			System.err.println("===="+nou+"====");
			return nou;
		}else {
			System.err.println("====Nourriture introuvable====");
			return nou;
		}
	}

	@Override
	public List<Nourriture> getAllNourriture() {
		// TODO Auto-generated method stub
		return nouRepository.findAll(Sort.by("idNou"));
	}

	@Override
	public void deleteNourriture(long idNou) {
		nouRepository.deleteById(idNou);
		
	}

}
