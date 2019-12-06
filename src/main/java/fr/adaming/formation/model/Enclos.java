package fr.adaming.formation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_enclos")
public class Enclos {
	
	//Déclaration des attributs
	private long idEnclos;
	private int capacite;
	private Zone zone;
	
	
	//Déclaration du constructeur vide
	public Enclos() {
		super();
	}
	
	//Déclaration du constructeur sans id
	public Enclos(int capacite, Zone zone) {
		super();
		this.capacite = capacite;
		this.zone = zone;
	}

	//Déclaration du constructeur avec id
	public Enclos(long idEnclos, int capacite,  Zone zone) {
		super();
		this.idEnclos = idEnclos;
		this.capacite = capacite;
		this.zone = zone;
	}

	//Déclaration des getters et des setters
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_enclos")
	public long getIdEnclos() {
		return idEnclos;
	}

	public void setIdEnclos(long idEnclos) {
		this.idEnclos = idEnclos;
	}

	public int getCapacite() {
		return capacite;
	}

	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}
	
	
	@ManyToOne
	@JoinColumn(name = "id_zone")
	public Zone getZone() {
		return zone;
	}

	public void setZone(Zone zone) {
		this.zone = zone;
	}

	//Redéfinition de la méthode toString	
	@Override
	public String toString() {
		return "Enclos [idEnclos=" + idEnclos + ", capacite=" + capacite + " zone=" + zone
				+ "]";
	}
	
	
	
	

}
