package fr.adaming.formation.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_tache")
public class Tache {
	
	//Déclaration des attributs
	private long idTache;
	private String intitule;
	private Date date;
	private double duree;
	
	private Etat etat;

	//Déclaration du constructeur vide
	public Tache() {
		super();
	}

	//Déclaration du constructeur sans id
	public Tache(String intitule, Date date, double duree, Etat etat) {
		super();
		this.intitule = intitule;
		this.date = date;
		this.duree = duree;
		this.etat = etat;
	}

	//Déclaration du constructeur avec id
	public Tache(long idTache, String intitule, Date date, double duree, Etat etat) {
		super();
		this.idTache = idTache;
		this.intitule = intitule;
		this.date = date;
		this.duree = duree;
		this.etat = etat;
	}

	//Déclaration des getters et des setters
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tache")
	public long getIdTache() {
		return idTache;
	}

	public void setIdTache(long idTache) {
		this.idTache = idTache;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getDuree() {
		return duree;
	}

	public void setDuree(double duree) {
		this.duree = duree;
	}

	@OneToOne
	@JoinColumn(name = "etatId")
	public Etat getEtat() {
		return etat;
	}

	public void setEtat(Etat etat) {
		this.etat = etat;
	}

	//Redéfinition de la méthode toString
	@Override
	public String toString() {
		return "Tache [idTache=" + idTache + ", intitule=" + intitule + ", date=" + date + ", duree=" + duree
				+ ", etat=" + etat + "]";
	}
	
	
	
	

}
