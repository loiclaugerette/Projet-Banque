package com.adaming.myapp.model;

import java.util.List;
import java.util.Set;

import com.adaming.myapp.entities.Client;
import com.adaming.myapp.entities.Compte;

public class ComptesClientModel {
	
	//=========================
	// Attributes
	//=========================
	
	private Client client;
	private Set<Compte> comptes;
	
	//=========================
	// Getter / Setter
	//=========================

	public Client getClient() {
		return client;
	}
	
	public void setClient(Client client) {
		this.client = client;
	}
	
	public Set<Compte> getComptes() {
		return comptes;
	}
	
	public void setComptes(Set<Compte> comptes) {
		this.comptes = comptes;
	}

}
