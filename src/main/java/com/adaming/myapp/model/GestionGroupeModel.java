package com.adaming.myapp.model;

import java.util.List;

import com.adaming.myapp.entities.Employe;
import com.adaming.myapp.entities.Groupe;

public class GestionGroupeModel {
	
	//=========================
	// Attributes
	//=========================
	
	private Long idGroupe;
	private Long code;
	private String nom;
	
	private List<Groupe> groupes;
	private Long selectedGroupe;
	private List<Employe> employes;
	private Long selectedGroupe1;
	private Long selectedEmploye;
	private List<Employe> employesByGroupe;

	//=========================
	// Getter / Setter
	//=========================
	
	public List<Employe> getEmployes() {
		return employes;
	}
	public List<Employe> getEmployesByGroupe() {
		return employesByGroupe;
	}
	public void setEmployesByGroupe(List<Employe> employesByGroupe) {
		this.employesByGroupe = employesByGroupe;
	}
	public Long getSelectedGroupe1() {
		return selectedGroupe1;
	}
	public void setSelectedGroupe1(Long selectedGroupe1) {
		this.selectedGroupe1 = selectedGroupe1;
	}
	public Long getSelectedEmploye() {
		return selectedEmploye;
	}
	public void setSelectedEmploye(Long selectedEmploye) {
		this.selectedEmploye = selectedEmploye;
	}
	public void setEmployes(List<Employe> employes) {
		this.employes = employes;
	}
	public Long getIdGroupe() {
		return idGroupe;
	}
	public void setIdGroupe(Long idGroupe) {
		this.idGroupe = idGroupe;
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
	public List<Groupe> getGroupes() {
		return groupes;
	}
	public void setGroupes(List<Groupe> groupes) {
		this.groupes = groupes;
	}
	public Long getSelectedGroupe() {
		return selectedGroupe;
	}
	public void setSelectedGroupe(Long selectedGroupe) {
		this.selectedGroupe = selectedGroupe;
	}
	
	

	
	

}
