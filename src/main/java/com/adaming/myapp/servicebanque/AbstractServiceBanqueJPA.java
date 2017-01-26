package com.adaming.myapp.servicebanque;

import java.util.List;

import com.adaming.myapp.daobanque.IDaoBanque;
import com.adaming.myapp.entities.Banque;
import com.adaming.myapp.entities.Client;
import com.adaming.myapp.entities.Compte;
import com.adaming.myapp.entities.Employe;
import com.adaming.myapp.exception.NullListException;
import com.adaming.myapp.service.AbstractServiceGeneriqueJPA;

public class AbstractServiceBanqueJPA extends AbstractServiceGeneriqueJPA<Banque> {

	private IDaoBanque daobanque;
	
	//===========================
	// Setter
	//===========================

	public void setDaobanque(IDaoBanque daobanque) {
		this.daobanque = daobanque;
		this.clazz = Banque.class;
	}
	
	//======================================================
	// rédéfinition des méthodes spéciques de IDaoBanque 
	//======================================================

	
	public List <Employe> getEmployeByBanqueAbstract(Long idBanque) throws NullListException{
		List<Employe> employes = daobanque.getEmployeByBanque(idBanque);
		if(employes.size() <=0){
			throw new NullListException("No Employe in the Bank " +dao.getOne(idBanque));
		}
		return employes;
		
	}
	
	public List<Client> getClientByBanqueAbstract(Long idBanque) throws NullListException {
		List<Client> clients = daobanque.getClientByBanque(idBanque);
		if(clients.size() <=0){
			throw new NullListException("No Clients in the Bank " +dao.getOne(idBanque));
		}
		return clients ;
	}
	
	public List<Compte> getCompteByBanqueAbstract(Long idBanque) throws NullListException {
		List<Compte> comptes = daobanque.getCompteByBanque(idBanque);
		if(comptes.size() <=0){
			throw new NullListException("No Comptes in the Bank " +dao.getOne(idBanque));
		}
		return comptes;
	}

}
