package fr.adaming.formation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tb_zone")
public class Zone {
	
	//Déclaration des attributs
	private long idZone;
	private String nom;
	
	private Enclos enclos;
	
	//Déclaration du constructeur vide
	public Zone() {
		super();
	}

	//Déclaration du constructeur sans id
	public Zone(String nom, Enclos enclos) {
		super();
		this.nom = nom;
		this.enclos = enclos;
		
	}

	//Déclaration du constructeur avec id
	public Zone(long idZone, String nom, Enclos enclos) {
		super();
		this.idZone = idZone;
		this.nom = nom;
		this.enclos = enclos;
		
	}

	//Déclaration des getters et des setters
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_zone")
	public long getIdZone() {
		return idZone;
	}

	public void setIdZone(long idZone) {
		this.idZone = idZone;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	@OneToMany
	@JoinColumn(name = "id_enclos")
	public Enclos getEnclos() {
		return enclos;
	}

	public void setEnclos(Enclos enclos) {
		this.enclos = enclos;
	}
	

	//Redéfinition de la méthode toString	
	@Override
	public String toString() {
		return "Zone [idZone=" + idZone + ", nom=" + nom + ", enclos=" + enclos + "]";
	}
	
	
	
	

}
