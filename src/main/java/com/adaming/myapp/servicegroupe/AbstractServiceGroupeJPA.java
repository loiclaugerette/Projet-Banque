package com.adaming.myapp.servicegroupe;

import java.util.List;

import com.adaming.myapp.daogroupe.IDaoGroupe;
import com.adaming.myapp.entities.Employe;
import com.adaming.myapp.entities.Groupe;
import com.adaming.myapp.exception.NullListException;
import com.adaming.myapp.service.AbstractServiceGeneriqueJPA;

public class AbstractServiceGroupeJPA extends AbstractServiceGeneriqueJPA<Groupe> {

	private IDaoGroupe daoGroupe;	
	
	//=============================
	//    Setter
	//=============================
	
	public void setDaogroupe(IDaoGroupe daoGroupe) {
		this.daoGroupe = daoGroupe;
	}
	
	//======================================================
	// rédéfinition des méthodes spéciques de IDaoGroupe 
	//======================================================
	
	public Groupe addEmToGrAbstract(Long idGroupe, Long idEmploye) {
		return daoGroupe.addEmToGr(idGroupe, idEmploye);
	}
	
	public List <Employe> getEmployeByGroupeAbstract(Long idGroupe) throws NullListException {
		List<Employe> employes = daoGroupe.getEmployeByGroupe(idGroupe);
		if (employes.size() <= 0) {
			throw new NullListException("No Employe in the groupe " + dao.getOne(idGroupe));
		}
		return employes;
	}
	
}
