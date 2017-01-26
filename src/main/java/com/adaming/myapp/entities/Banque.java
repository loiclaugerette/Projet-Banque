package com.adaming.myapp.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Banque implements Serializable{

	//=========================
	// Attributes
	//=========================
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idBanque;
	private String nom;
	private String adresse;
	private int codePostal;
	
	@OneToMany(mappedBy="banque")
	private List<Compte> comptes = new ArrayList<Compte>();
	
	@OneToMany(mappedBy="banque")
	private List<Employe> employes = new ArrayList<Employe>();	
	
	@ManyToMany
	@JoinTable(name="TB_Client_Banque")
	private List<Client> clients = new ArrayList<Client>();
	
	@OneToMany(mappedBy="banque")
	private List<Groupe> groupes = new ArrayList<Groupe>();
	
	//=========================
	// Constructor
	//=========================
	
	public Banque() {
	}
	
	public Banque(String nom, String adresse, int codePostal) {
		this.nom = nom;
		this.adresse = adresse;
		this.codePostal = codePostal;
	}
	
	//=========================
	// Getter / Setter
	//=========================

	public Long getIdBanque() {
		return idBanque;
	}

	public void setIdBanque(Long idBanque) {
		this.idBanque = idBanque;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	public List<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}

	public List<Employe> getEmployes() {
		return employes;
	}

	public void setEmployes(List<Employe> employes) {
		this.employes = employes;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	
	public List<Groupe> getGroupes() {
		return groupes;
	}

	public void setGroupes(List<Groupe> groupes) {
		this.groupes = groupes;
	}
	
	//=========================
	// Methods
	//=========================
	
	/*
	 * toString
	 * get a current entity's description
	 * @return a description string
	 */
	public String toString() {
		return "La Banque " + nom + " (" + idBanque + ") se situe au "  + adresse + " " + codePostal;
	}

}
