package com.adaming.myapp.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_Compte", discriminatorType = DiscriminatorType.STRING)
public abstract class Compte implements Serializable {
	
	//=========================
	// Attributes
	//=========================
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCompte;
	private Long numeroCompte;
	private Double solde;

	
	private Date dateCreation;
	
	//====================================
	//   association avec la class Banque
	//====================================
	
	@ManyToOne
	@JoinColumn(name="idBanque")
	private Banque banque;
	
	//====================================
	//   association avec la class Employe
	//====================================
	
	@ManyToOne
	@JoinColumn(name = "idEmploye")
	private Employe employe;
	
	//====================================
	//   association avec la class Operation
	//====================================
	
	@OneToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "operation_to_compte")
	private List<Operation> operations = new ArrayList <Operation> ();
	
	//=========================
	// Constructor
	//=========================
	
	public Compte() {
	}

	public Compte(Long numeroCompte, Double solde,
			Date dateCreation) {
		this.numeroCompte = numeroCompte;
		this.solde = solde;
		this.dateCreation = dateCreation;
	}
	
	//=========================
	// Getter / Setter
	//=========================
	
	public Long getIdCompte() {
		return idCompte;
	}

	public void setIdCompte(Long idCompte) {
		this.idCompte = idCompte;
	}

	public Long getNumeroCompte() {
		return numeroCompte;
	}

	public void setNumeroCompte(Long numeroCompte) {
		this.numeroCompte = numeroCompte;
	}

	public Double getSolde() {
		return solde;
	}

	public void setSolde(Double solde) {
		this.solde = solde;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public List<Operation> getOperations() {
		return operations;
	}

	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}

	public Banque getBanque() {
		return banque;
	}

	public void setBanque(Banque banque) {
		this.banque = banque;
	}

	//==========================
	//  Methode to string
	//===========================
	
	@Override
	public String toString() {
		return "Compte [idCompte=" + idCompte + ", numeroCompte="
				+ numeroCompte + ", solde=" + solde + ", dateCreation="
				+ dateCreation + "]";
	}


}
