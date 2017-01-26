package com.adaming.myapp.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.adaming.myapp.entities.Client;
import com.adaming.myapp.entities.Compte;

public class GestionCompteModel {

	//=========================
	// Attributes
	//=========================
	
	private Compte compte;
	
	private double montantOperation;
	private Long idCompteCible;
	@DateTimeFormat (iso=ISO.DATE)
	private Date dateOperation;
	private List<Client> clients;
	private Set<Compte> comptes;
	private Long selectedClient;
	private Client client;

	//=========================
	// Getter / Setter
	//=========================

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public double getMontantOperation() {
		return montantOperation;
	}

	public void setMontantOperation(double montantOperation) {
		this.montantOperation = montantOperation;
	}

	public Long getIdCompteCible() {
		return idCompteCible;
	}

	public void setIdCompteCible(Long idCompteCible) {
		this.idCompteCible = idCompteCible;
	}

	public Date getDateOperation() {
		return dateOperation;
	}

	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public Set<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(Set<Compte> comptes) {
		this.comptes = comptes;
	}

	public Long getSelectedClient() {
		return selectedClient;
	}

	public void setSelectedClient(Long selectedClient) {
		this.selectedClient = selectedClient;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
}
