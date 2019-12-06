package fr.adaming.formation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_role")
public class Role {
	
	//Déclaration des attributs
	private long idRole;
	private String libelle;
	
	//Déclaration du constructeur vide
	public Role() {
		super();
	}

	//Déclaration du constructeur sans id
	public Role(String libelle) {
		super();
		this.libelle = libelle;
	}

	//Déclaration du constructeur avec id
	public Role(long idRole, String libelle) {
		super();
		this.idRole = idRole;
		this.libelle = libelle;
	}

	//Déclaration des getters et des setters
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_role")
	public long getIdRole() {
		return idRole;
	}

	public void setIdRole(long idRole) {
		this.idRole = idRole;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	//Redéfinition de la méthode toString
	@Override
	public String toString() {
		return "Role [idRole=" + idRole + ", libelle=" + libelle + "]";
	}
	
	
	
	

}
