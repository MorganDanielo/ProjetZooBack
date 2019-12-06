package fr.adaming.formation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_etat")
public class Etat {
	
	//Déclaration des attributs
	private long idEtat;
	private String libelleEtat;
		
	//Déclaration du constructeur vide
	public Etat() {
		super();
	}

	//Déclaration du constructeur sans id
	public Etat(String libelleEtat) {
		super();
		this.libelleEtat = libelleEtat;
	}

	//Déclaration du constructeur avec id
	public Etat(long idEtat, String libelleEtat) {
		super();
		this.idEtat = idEtat;
		this.libelleEtat = libelleEtat;
	}

	//Déclaration des getters et des setters
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_etat")
	public long getIdEtat() {
		return idEtat;
	}

	public void setIdEtat(long idEtat) {
		this.idEtat = idEtat;
	}

	public String getLibelleEtat() {
		return libelleEtat;
	}

	public void setLibelleEtat(String libelleEtat) {
		this.libelleEtat = libelleEtat;
	}

	//Redéfinition de la méthode toStirng
	@Override
	public String toString() {
		return "Etat [idEtat=" + idEtat + ", libelleEtat=" + libelleEtat + "]";
	}
	
	
	
	

}
