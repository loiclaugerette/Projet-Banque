package com.adaming.myapp.model;

import java.util.List;

import com.adaming.myapp.entities.Banque;

public class AddEmployeModel {
	
	//=========================
	// Attributes
	//=========================
	private Long idEmploye;
	private Long code;
	private String nom;
	//private List<Employe> employe;
	private Banque banque;
	private List<Banque> banques;
	private Long selectedBanque;
	
	//=========================
	// Getter / Setter
	//=========================

	/*public List<Employe> getEmploye() {
		return employe;
	}

	public void setEmploye(List<Employe> employe) {
		this.employe = employe;
	}*/

	public Banque getBanque() {
		return banque;
	}

	

	public Long getSelectedBanque() {
		return selectedBanque;
	}



	public void setSelectedBanque(Long selectedBanque) {
		this.selectedBanque = selectedBanque;
	}



	public List<Banque> getBanques() {
		return banques;
	}



	public void setBanques(List<Banque> banques) {
		this.banques = banques;
	}



	public void setBanque(Banque banque) {
		this.banque = banque;
	}

	public Long getIdEmploye() {
		return idEmploye;
	}

	public void setIdEmploye(Long idEmploye) {
		this.idEmploye = idEmploye;
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

}
