package com.adaming.myapp.model;

import java.util.List;

import com.adaming.myapp.entities.Banque;
import com.adaming.myapp.entities.Client;
import com.adaming.myapp.entities.Compte;
import com.adaming.myapp.entities.Employe;

public class GestionBanqueModel {
	
	//=========================
	// Attributes
	//=========================
	
	private List<Banque> banques;
	private List<Employe> employes;
	private List<Client> clients;
	private List<Compte> comptes;
	private Long selectedBanque;
	private String action;

	//=========================
	// Getter / Setter
	//=========================

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
	
	public List<Client> getClients() {
		return clients;
	}
	
	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	
	public List<Compte> getComptes() {
		return comptes;
	}
	
	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}

	public Long getSelectedBanque() {
		return selectedBanque;
	}

	public void setSelectedBanque(Long selectedBanque) {
		this.selectedBanque = selectedBanque;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

}
