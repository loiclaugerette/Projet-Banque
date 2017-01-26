package com.adaming.myapp.model;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.adaming.myapp.entities.Banque;
import com.adaming.myapp.entities.Client;
import com.adaming.myapp.entities.Employe;

public class AddCompteModel {
	
	//=========================
	// Attributes
	//=========================

	private Long idCompte;
	private Long numeroCompte;
	private Double solde;
	@DateTimeFormat(iso=ISO.DATE)
	private Date dateCreation;
	private Double tauxInteret;
	private double decouvert;
	private Client client;
	private String action;
	private Employe employe;
	
	private List<Banque> banques;
	private Long idBanque;
	
	private List<Employe> employes;
	private Long idEmploye;
	
	//=========================
	// Getter / Setter
	//=========================
	
	public String getAction() {
		return action;
	}

	public Employe getEmploye() {
		return employe;
	}
	
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	
	public void setAction(String action) {
		this.action = action;
	}
	
	public double getDecouvert() {
		return decouvert;
	}
	
	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}
	
	public Double getTauxInteret() {
		return tauxInteret;
	}
	
	public void setTauxInteret(Double tauxInteret) {
		this.tauxInteret = tauxInteret;
	}
	
	public Long getIdCompte() {
		return idCompte;
	}
	
	public void setIdCompte(Long idCompte) {
		this.idCompte = idCompte;
	}
	
	public Long getNumeroCompte() {
		return numeroCompte;
	}
	
	public void setNumeroCompte(Long numeroCompte) {
		this.numeroCompte = numeroCompte;
	}
	
	public Double getSolde() {
		return solde;
	}
	
	public void setSolde(Double solde) {
		this.solde = solde;
	}
	
	public Date getDateCreation() {
		return dateCreation;
	}
	
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	
	public Client getClient() {
		return client;
	}
	
	public void setClient(Client client) {
		this.client = client;
	}
	
	public Long getIdBanque() {
		return idBanque;
	}
	
	public void setIdBanque(Long idBanque) {
		this.idBanque = idBanque;
	}

	public Long getIdEmploye() {
		return idEmploye;
	}

	public void setIdEmploye(Long idEmploye) {
		this.idEmploye = idEmploye;
	}

	public List<Banque> getBanques() {
		return banques;
	}

	public void setBanques(List<Banque> banques) {
		this.banques = banques;
	}

	public List<Employe> getEmployes() {
		return employes;
	}

	public void setEmployes(List<Employe> employes) {
		this.employes = employes;
	}

}
