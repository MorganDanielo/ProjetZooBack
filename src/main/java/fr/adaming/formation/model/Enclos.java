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
	
	private Animal animal;
	
	
	//Déclaration du constructeur vide
	public Enclos() {
		super();
	}
	
	//Déclaration du constructeur sans id
	public Enclos(int capacite, Animal animal) {
		super();
		this.capacite = capacite;
		this.animal = animal;
	}

	//Déclaration du constructeur avec id
	public Enclos(long idEnclos, int capacite, Animal animal) {
		super();
		this.idEnclos = idEnclos;
		this.capacite = capacite;
		this.animal = animal;
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
	@JoinColumn(name = "id_animal")
	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	//Redéfinition de la méthode toString	
	@Override
	public String toString() {
		return "Enclos [idEnclos=" + idEnclos + ", capacite=" + capacite + ", animal=" + animal + "]";
	}
	
	
	
	

}
