package com.adaming.myapp.servicecompte;

import java.util.List;

import com.adaming.myapp.daocompte.IDaoCompte;
import com.adaming.myapp.entities.Compte;
import com.adaming.myapp.exception.NullListException;
import com.adaming.myapp.service.AbstractServiceGeneriqueJPA;

public class AbstractServiceCompteJPA extends AbstractServiceGeneriqueJPA<Compte> {
	
	private IDaoCompte daoCompte;
		
	//=============================
	//    Setter
	//=============================
	
	public void setDaoCompte(IDaoCompte daoCompte) {
		this.daoCompte = daoCompte;
	}
	
	//======================================================
	// rédéfinition des méthodes spéciques de IDaoCompte
	//======================================================
	
	protected List<Compte> getCompteByEmployeAbstract(Long idEmploye) throws NullListException{
		List<Compte> comptes = daoCompte.getCompteByEmploye(idEmploye);
		if (comptes.size() <= 0) {
			throw new NullListException("No Compte for this employe");
		}
		return comptes;
	}
	
	public Compte addCompteToBanqueAbstract(Long idCompte, Long idBanque) {
		return daoCompte.addCompteToBanque(idCompte, idBanque);
	}

	public Compte addCompteToClientAbstract(Long idCompte, Long idClient) {
		return daoCompte.addCompteToClient(idCompte, idClient);
	}

	public Compte addCompteToEmployeAbstract(Long idCompte, Long idEmploye) {
		return daoCompte.addCompteToEmploye(idCompte, idEmploye);
	}

}
