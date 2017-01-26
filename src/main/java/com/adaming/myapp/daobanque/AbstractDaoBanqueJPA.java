package com.adaming.myapp.daobanque;

import java.util.List;

import org.apache.log4j.Logger;

import com.adaming.myapp.dao.AbstractDaoGeneriqueJPA;
import com.adaming.myapp.entities.Banque;
import com.adaming.myapp.entities.Client;
import com.adaming.myapp.entities.Compte;
import com.adaming.myapp.entities.Employe;

public class AbstractDaoBanqueJPA extends AbstractDaoGeneriqueJPA<Banque> {
	private final Logger LOGGER = Logger.getLogger("AbstractDaoBanqueJPA");
	
	/*
	 * rédéfinition des méthodes spéciques de IDaoBanque 
	 */

	public List <Employe> getEmployeByBanqueAbstract(Long idBanque){
		Banque banque = em.find(Banque.class, idBanque);
		List <Employe> employes = banque.getEmployes();
		LOGGER.info("la liste des employes d'une banque" + employes);
		return employes;
	}
	
	public List <Client> getClientByBanqueAbstract (Long idBanque){
		Banque banque = em.find(Banque.class, idBanque);
		List <Client> clients = banque.getClients();
		LOGGER.info("la liste des clients d'une banque" + clients);
		return clients;
	}
	
	public List <Compte> getCompteByBanqueAbstract (Long idBanque){
		Banque banque = em.find(Banque.class, idBanque);
		List <Compte> comptes = banque.getComptes();
		LOGGER.info("la liste des comptes d'une banque" + comptes);
		return comptes;
	}

}
