package fr.adaming.formation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_nourriture")
public class Nourriture {
	
	//Déclaration des attributs
	private long idNou;
	private String nom;
	private double stock;
	
	//Déclaration du constructeur vide
	public Nourriture() {
		super();
	}

	//Déclaration du constructeur sans id
	public Nourriture(String nom, double stock) {
		super();
		this.nom = nom;
		this.stock = stock;
	}

	//Déclaration du constructeur avec id
	public Nourriture(long idNou, String nom, double stock) {
		super();
		this.idNou = idNou;
		this.nom = nom;
		this.stock = stock;
	}

	//Déclaration des getters et des setters
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_nourriture")
	public long getIdNou() {
		return idNou;
	}

	public void setIdNou(long idNou) {
		this.idNou = idNou;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getStock() {
		return stock;
	}

	public void setStock(double stock) {
		this.stock = stock;
	}

	//Redéfinition de la méthode toString
	@Override
	public String toString() {
		return "Nourriture [idNou=" + idNou + ", nom=" + nom + ", stock=" + stock + "]";
	}
	
	
	
	

}
