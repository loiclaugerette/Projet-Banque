package com.adaming.myapp.model;

public class AddBanqueModel {
	
	//=========================
	// Attributes
	//=========================
	private Long idBanque;
	private String nom;
	private String adresse;
	private int codePostal;
	
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
	

	
}
