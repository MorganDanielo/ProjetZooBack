package fr.adaming.formation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import fr.adaming.formation.model.Zone;
import fr.adaming.formation.repository.IZoneRepository;

@Service
public class ZoneService implements IZoneService {

	@Autowired
	IZoneRepository zoneRepo;

	@Override
	public Zone saveZone(Zone zone) {
		// TODO Auto-generated method stub
		return zoneRepo.save(zone);
	}

	@Override
	public Zone update(Zone zone) {
		// TODO Auto-generated method stub
		return zoneRepo.save(zone);
	}

	@Override
	public Zone getZoneById(long idZone) {
		Optional<Zone> zoneOpt = zoneRepo.findById(idZone);
		Zone zone = new Zone();
		if(zoneOpt.isPresent()) {
			zone=zoneOpt.get();
			System.err.println("===="+zone+"====");
			return zone;
		}else {
			System.err.println("====Zone introuvable====");
			return zone;
		}

	}

	@Override
	public List<Zone> getAll() {
		// TODO Auto-generated method stub
		return zoneRepo.findAll(Sort.by("idZone"));
	}

	@Override
	public void deleteZone(long idZone) {
		zoneRepo.deleteById(idZone);

	}

}
