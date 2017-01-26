package com.adaming.myapp.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("EPARGNE")
public class CompteEpargne extends Compte {
	
	private Double tauxInteret;

	public Double getTauxInteret() {
		return tauxInteret;
	}

	public void setTauxInteret(Double tauxInteret) {
		this.tauxInteret = tauxInteret;
	}

	public CompteEpargne() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CompteEpargne(Long numeroCompte, Double solde, Date dateCreation, Double tauxInteret ) {
		super(numeroCompte, solde, dateCreation);
		this.tauxInteret =tauxInteret ;
		// TODO Auto-generated constructor stub
	}


	
	
}
