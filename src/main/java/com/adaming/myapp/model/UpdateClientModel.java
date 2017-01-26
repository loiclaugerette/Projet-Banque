package com.adaming.myapp.model;

import java.util.Date;

public class UpdateClientModel {
	
	//=========================
	// Attributes
	//=========================

	private Long idClient;
	private Long code;
	private String nom;
	private String prenom;
	private Date dateEntree;
	private String adresse;

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
	
}
