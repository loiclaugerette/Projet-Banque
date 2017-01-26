package com.adaming.myapp.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("VIREMENT")
public class Virement extends Operation implements Serializable{

	//=========================
	// Attributes
	//=========================
		
	//=========================
	// Constructor
	//=========================

	public Virement() {
		super();
	}

	public Virement(Date dateOperatiion, double montantOperation) {
		super(dateOperatiion, montantOperation);
	}

	//=========================
	// Getter / Setter
	//=========================
		
	//=========================
	// Methods
	//=========================
	
}
