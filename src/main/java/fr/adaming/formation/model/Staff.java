package fr.adaming.formation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_staff")
public class Staff {
	
	//Déclaration des attributs
	private long idStaff;
	private String nom;
	private String prenom;
	private String login;
	private String password;
	
	private Role role;
	private Zone zone;
	
	//Déclaration du constructeur vide
	public Staff() {
		super();
	}

	//Déclaration du constructeur sans id
	public Staff(String nom, String prenom, String login, String password, Role role, Zone zone) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.password = password;
		this.role = role;
		this.zone = zone;
	}

	//Déclaration du constructeur avec id
	public Staff(long idStaff, String nom, String prenom, String login, String password, Role role,
			Zone zone) {
		super();
		this.idStaff = idStaff;
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.password = password;
		this.role = role;
		this.zone = zone;
	}

	//Déclaration des getters et des setters
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_staff")
	public long getIdStaff() {
		return idStaff;
	}

	public void setIdStaff(long idStaff) {
		this.idStaff = idStaff;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@OneToOne
	@JoinColumn(name = "id_role")
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
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
		return "Staff [idStaff=" + idStaff + ", nom=" + nom + ", prenom=" + prenom + ", login=" + login + ", password="
				+ password + ", role=" + role + ", zone=" + zone + "]";
	}
	
	
	
	
	
	

}
