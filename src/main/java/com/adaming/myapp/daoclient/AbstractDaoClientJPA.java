package com.adaming.myapp.daoclient;

import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import javax.persistence.Query;

import com.adaming.myapp.dao.AbstractDaoGeneriqueJPA;
import com.adaming.myapp.entities.Banque;
import com.adaming.myapp.entities.Client;
import com.adaming.myapp.entities.Compte;

public class AbstractDaoClientJPA extends AbstractDaoGeneriqueJPA<Client> {
	
	private final Logger LOGGER = Logger.getLogger("AbstractDaoClientJPA");
	
	//=====================
	//   Methodes spécifique
	//=====================
	
	/*
	 * getCompteClient
	 * récupérer la liste de compte d'un client
	 * @param (idClient)
	 * @return List<Compte> comptesClient
	 */
	protected Set<Compte> getCompteByClientAbstract(Long idClient){
		
		Client client = em.find(Client.class, idClient);
		Set<Compte> comptesByClient = client.getComptes();		
		LOGGER.info("<------------------List of Compte by Client generated ------------------->");
		return comptesByClient;
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Client> getClientByMcAbstract(String MC){
		Query query = em.createQuery("from Client c where c.nom like :x");
		query.setParameter("x", "%"+MC+"%");
		LOGGER.info("<------------------List of Client by MC generated ------------------->");
		return query.getResultList();
	}
	
	public Client addClientToBanqueAbstract(Long idClient, Long idBanque) {
		Client client = em.find(Client.class, idClient);
		Banque banque = em.find(Banque.class, idBanque);
		client.getBanques().add(banque);
		banque.getClients().add(client);
		em.merge(client);
		em.merge(banque);
		LOGGER.info("<------------------ " + client + " added to " + banque + " ------------------->");
		return client;
	}
	
}
