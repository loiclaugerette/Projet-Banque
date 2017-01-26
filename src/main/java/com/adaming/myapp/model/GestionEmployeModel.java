package com.adaming.myapp.model;

import java.util.List;

import com.adaming.myapp.entities.Compte;
import com.adaming.myapp.entities.Employe;

public class GestionEmployeModel {
	
	//=========================
	// Attributes
	//=========================
	
	private Long idEmploye;
	private Long code;
	private String nom;
	
	private List<Compte> comptes;
	private Long selectedEmploye;
	private List<Employe> employes;

	//=========================
	// Getter / Setter
	//=========================
	
	
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
	public List<Compte> getComptes() {
		return comptes;
	}
	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}
	public Long getSelectedEmploye() {
		return selectedEmploye;
	}
	public void setSelectedEmploye(Long selectedEmploye) {
		this.selectedEmploye = selectedEmploye;
	}
	public List<Employe> getEmployes() {
		return employes;
	}
	public void setEmployes(List<Employe> employes) {
		this.employes = employes;
	}

	

}
