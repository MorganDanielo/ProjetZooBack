package fr.adaming.formation.service;

import java.util.List;

import fr.adaming.formation.model.Zone;

public interface IZoneService {

	public Zone saveZone(Zone zone);

	public Zone update(Zone zone);

	public Zone getZoneById(long idZone);

	public List<Zone> getAll();

	public void deleteZone(long idZone);

	public void affecterEnclosZone(long idEnclos, long idZone);

}
