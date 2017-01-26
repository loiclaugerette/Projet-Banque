package com.adaming.myapp.model;

import java.util.List;
import java.util.Set;

import com.adaming.myapp.entities.Client;
import com.adaming.myapp.entities.Compte;

public class GestionClientModel {
	
	//=========================
	// Attributes
	//=========================
	
	private Set<Compte> comptes;
	private List<Client> clients;
	private String action;
	private Long selectedClient;
	private String Mc;
	
	//=========================
	// Getter / Setter
	//=========================

	public String getMc() {
		return Mc;
	}

	public void setMc(String mc) {
		Mc = mc;
	}

	public Set<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(Set<Compte> comptes) {
		this.comptes = comptes;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Long getSelectedClient() {
		return selectedClient;
	}

	public void setSelectedClient(Long selectedClient) {
		this.selectedClient = selectedClient;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	
	
	
	

}
