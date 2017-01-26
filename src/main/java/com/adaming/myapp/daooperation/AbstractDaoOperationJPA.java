package com.adaming.myapp.daooperation;

import java.util.logging.Logger;

import com.adaming.myapp.dao.AbstractDaoGeneriqueJPA;
import com.adaming.myapp.entities.Compte;
import com.adaming.myapp.entities.Operation;
import com.adaming.myapp.entities.Retrait;
import com.adaming.myapp.entities.Versement;
import com.adaming.myapp.entities.Virement;

public class AbstractDaoOperationJPA extends AbstractDaoGeneriqueJPA<Operation> {
	
	private final Logger LOGGER = Logger.getLogger("AbstractDaoOperationJPA");

	public Versement doVersementAbstract(Versement versement, Long idCompte) {
		em.persist(versement);
		Compte compte = em.find(Compte.class, idCompte);
		compte.getOperations().add(versement);
		compte.setSolde(compte.getSolde() + versement.getMontantOperation());
		LOGGER.info(versement + " a bien ete ajoute a " + compte);
		return versement;
	}

	public Retrait doRetraitAbstract(Retrait retrait, Long idCompte) {
		em.persist(retrait);
		Compte compte = em.find(Compte.class, idCompte);
		compte.getOperations().add(retrait);
		compte.setSolde(compte.getSolde() + retrait.getMontantOperation());
		LOGGER.info(retrait + " a bien ete ajoute a " + compte);
		return retrait;
	}

	public Virement doVirementAbstract(Virement virement, Long idCompteDebite, Long idCompteCredite) {
		em.persist(virement);
		Compte compteDebite = em.find(Compte.class, idCompteCredite);
		Compte compteCredite = em.find(Compte.class, idCompteDebite);
		compteCredite.getOperations().add(virement);
		compteCredite.setSolde(compteCredite.getSolde() - virement.getMontantOperation());
		Virement virement2 = new Virement(virement.getDateOperatiion(), 0.0 + virement.getMontantOperation());
		em.persist(virement2);
		compteDebite.getOperations().add(virement2);
		compteDebite.setSolde(compteDebite.getSolde() + virement2.getMontantOperation());
		LOGGER.info(virement + " a bien ete ajoute a " + compteDebite + " et a " + compteCredite);
		return virement;
	}
	
}
