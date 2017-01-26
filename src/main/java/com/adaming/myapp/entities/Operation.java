package com.adaming.myapp.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_operation", discriminatorType = DiscriminatorType.STRING)
public class Operation implements Serializable{
	
	//=========================
	// Attributes
	//=========================

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idOperation;
	private Date dateOperatiion;
	private double montantOperation;
	
	//=========================
	// Constructor
	//=========================
	
	public Operation() {
	}	
	
	public Operation(Date dateOperatiion,
			double montantOperation) {
		this.dateOperatiion = dateOperatiion;
		this.montantOperation = montantOperation;
	}
	
	//=========================
	// Getter / Setter
	//=========================

	public Long getIdOperation() {
		return idOperation;
	}

	public void setIdOperation(Long idOperation) {
		this.idOperation = idOperation;
	}

	public Date getDateOperatiion() {
		return dateOperatiion;
	}

	public void setDateOperatiion(Date dateOperatiion) {
		this.dateOperatiion = dateOperatiion;
	}

	public double getMontantOperation() {
		return montantOperation;
	}

	public void setMontantOperation(double montantOperation) {
		this.montantOperation = montantOperation;
	}

	//=========================
	// Methods
	//=========================
	
	/*
	 * toString
	 * méthode to string pour l'affichage
	 * @param null
	 * @return attribut client
	 */
	@Override
	public String toString() {
		return "Operation [idOperation=" + idOperation + ", dateOperatiion="
				+ dateOperatiion + ", montantOperation=" + montantOperation
				+ "]";
	}
	
}
