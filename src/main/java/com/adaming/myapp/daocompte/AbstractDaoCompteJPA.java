package com.adaming.myapp.daocompte;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.adaming.myapp.dao.AbstractDaoGeneriqueJPA;
import com.adaming.myapp.entities.Banque;
import com.adaming.myapp.entities.Client;
import com.adaming.myapp.entities.Compte;
import com.adaming.myapp.entities.Employe;

public class AbstractDaoCompteJPA extends AbstractDaoGeneriqueJPA<Compte> {
	
	//D�finition du Logger
	private final Logger LOGGER = Logger.getLogger("AbstractDaoClientJPA");
	
	//=====================
	//   Methodes sp�cifiques
	//=====================
	
	/*
	 * getCompteByEmploye
	 * r�cup�rer la liste de compte cr�� par un employ�
	 * @param (idEmploye)
	 * @return comptesByEmploye
	 */
	protected List<Compte> getCompteByEmployeAbstract(Long idEmploye){		
		List<Compte> comptesByEmploye = new ArrayList<Compte>();					//cr�ation liste vide
		List<Compte> comptes = getAllAbstract();									//r�cup�tation de tous les comptes
		for (Compte c : comptes) {
			if(c.getEmploye() != null) {
				if(c.getEmploye().getIdEmploye() == idEmploye){							//si employ� compte c = id employ� cherch�
					comptesByEmploye.add(c);											// ajout du compte dans la liste
				}				
			}
		}
		LOGGER.info("<------------------List of Compte by Employe generated ------------------->");
		return comptesByEmploye;
	}
	
	public Compte addCompteToBanqueAbstract(Long idCompte, Long idBanque) {
		Compte compte = em.find(Compte.class, idCompte);
		Banque banque = em.find(Banque.class, idBanque);
		compte.setBanque(banque);
		banque.getComptes().add(compte);
		em.merge(compte);
		em.merge(banque);
		LOGGER.info("<------------------ " + compte + " added to " + banque + " ------------------->");
		return compte;
	}

	public Compte addCompteToClientAbstract(Long idCompte, Long idClient) {
		Compte compte = em.find(Compte.class, idCompte);
		Client client = em.find(Client.class, idClient);
		client.getComptes().add(compte);
		em.merge(client);
		LOGGER.info("<------------------ " + compte + " added to " + client + " ------------------->");
		return compte;
	}
	
	public Compte addCompteToEmployeAbstract(Long idCompte, Long idEmploye) {
		Compte compte = em.find(Compte.class, idCompte);
		Employe employe = em.find(Employe.class, idEmploye);
		compte.setEmploye(employe);
		em.merge(compte);
		LOGGER.info("<------------------ " + compte + " added to " + employe + " ------------------->");
		return compte;
	}
	
}
