package com.adaming.myapp.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("COURANT")
public class CompteCourant extends Compte {
	
	//=========================
	// Attributes
	//=========================
	
	private double decouvert;

	public CompteCourant() {
		super();
	}

	public CompteCourant(Long numeroCompte, Double solde, Date dateCreation, double decouvert) {
		super(numeroCompte, solde, dateCreation);
		this.decouvert = decouvert;
	}

	public double getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}

	

	

}
