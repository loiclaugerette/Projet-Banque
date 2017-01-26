package com.adaming.myapp.daoemployee;

import java.util.logging.Logger;

import com.adaming.myapp.dao.AbstractDaoGeneriqueJPA;
import com.adaming.myapp.entities.Banque;
import com.adaming.myapp.entities.Employe;

public class AbstractDaoEmployeJPA extends AbstractDaoGeneriqueJPA<Employe> {
	
	private final Logger LOGGER = Logger.getLogger("AbstractDaoEmployeJPA");
	
	public Employe addEmployeToBanqueAbstract(Long idEmploye, Long idBanque) {
		Employe employe = em.find(Employe.class, idEmploye);
		Banque banque = em.find(Banque.class, idBanque);
		employe.setBanque(banque);
		banque.getEmployes().add(employe);
		em.merge(employe);
		em.merge(banque);
		LOGGER.info("<------------------ " + employe + " added to " + banque + " ------------------->");
		return employe;
	}

}
