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
@Table(name = "tb_animal")
public class Animal {
	
	//Déclaration des attributs
	private long idAni;
	private String espece;
	
	private Nourriture nourriture;
	private Enclos enclos;
	
	//Déclaration du constructeur vide
	public Animal() {
		super();
	}

	//Déclaration dun constructeur sans id
	public Animal(String espece, Nourriture nourriture, Enclos enclos) {
		super();
		this.espece = espece;
		this.nourriture = nourriture;
		this.enclos = enclos;
	}

	//Déclaration du constructeur avec id
	public Animal(long idAni, String espece, Nourriture nourriture, Enclos enclos) {
		super();
		this.idAni = idAni;
		this.espece = espece;
		this.nourriture = nourriture;
		this.enclos = enclos;
	}

	//Déclaration des getters et des setters
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_animal")
	public long getIdAni() {
		return idAni;
	}

	public void setIdAni(long idAni) {
		this.idAni = idAni;
	}

	public String getEspece() {
		return espece;
	}

	public void setEspece(String espece) {
		this.espece = espece;
	}

	@ManyToOne
	@JoinColumn(name = "id_nourriture")
	public Nourriture getNourriture() {
		return nourriture;
	}

	public void setNourriture(Nourriture nourriture) {
		this.nourriture = nourriture;
	}
	
	
	@ManyToOne
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
		return "Animal [idAni=" + idAni + ", espece=" + espece + ", nourriture=" + nourriture + ", enclos=" + enclos
				+ "]";
	}
	
	
	
	
	

}
