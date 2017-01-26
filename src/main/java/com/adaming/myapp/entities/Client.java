package com.adaming.myapp.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
public class Client implements Serializable{
	
	//=========================
	// Attributes
	//=========================
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idClient;
	private Long code;
	private String nom;	
	private String prenom;
	@DateTimeFormat(iso=ISO.DATE)
	private Date dateEntree;
	private String adresse;
	
	@ManyToMany(mappedBy="clients")
	private List<Banque> banques = new ArrayList<Banque>();
	
	@OneToMany(fetch=FetchType.EAGER) // association avec le compte
	@JoinTable(name="TB_Compte_Client")
	private Set<Compte> comptes = new HashSet<Compte>();
	
	//=========================
	// Constructor
	//=========================
	
	public Client() {
	}
	
	public Client(Long code, String nom, String prenom,
			Date dateEntree, String adresse) {
		super();
		this.code = code;
		this.nom = nom;
		this.prenom = prenom;
		this.dateEntree = dateEntree;
		this.adresse = adresse;
	}

	//=========================
	// Getter / Setter
	//=========================
	
	public Long getIdClient() {
		return idClient;
	}

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
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

	public Date getDateEntree() {
		return dateEntree;
	}

	public void setDateEntree(Date dateEntree) {
		this.dateEntree = dateEntree;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	public List<Banque> getBanques() {
		return banques;
	}

	public void setBanques(List<Banque> banques) {
		this.banques = banques;
	}
	public Set<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(Set<Compte> comptes) {
		this.comptes = comptes;
	}
	

	//=========================
	// Methods
	//=========================
	
	/*
	 * toString
	 * méthode to string pour l'affichage
	 * @param null
	 * @return attribut client
	 */
	
	

	@Override
	public String toString() {
		return "Client [idCompte=" + idClient + ", code=" + code + ", nom="
				+ nom + ", prenom=" + prenom + ", dateEntree=" + dateEntree
				+ ", adresse=" + adresse + "]";
	}
	
	
}
