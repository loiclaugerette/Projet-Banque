package com.adaming.myapp.daogroupe;

import java.util.List;

import org.apache.log4j.Logger;

import com.adaming.myapp.dao.AbstractDaoGeneriqueJPA;
import com.adaming.myapp.entities.Employe;
import com.adaming.myapp.entities.Groupe;

public class AbstractDaoGroupeJPA extends AbstractDaoGeneriqueJPA<Groupe> {

	private final Logger LOGGER = Logger.getLogger("AbstractDaoGroupeJPA");
	
	//=====================================
	//  Definition des methodes en abstract
	//=====================================
	
	public Groupe addEmToGrAbstract(Long idGroupe, Long idEmploye) {
		Groupe groupe = em.find(Groupe.class, idGroupe);
		Employe employe = em.find(Employe.class, idEmploye);
		groupe.getEmployes().add(employe);
		em.merge(groupe);
		LOGGER.info(employe + "a bien ete rajoute au " + groupe );
		return groupe;
	}
	
	
	@SuppressWarnings("unchecked")
	public List <Employe> getEmployeByGroupeAbstract(Long idGroupe) {
		Groupe groupe = em.find(Groupe.class, idGroupe);
		List<Employe> employes = groupe.getEmployes();
		LOGGER.info("la liste des employes par groupe" + employes );
		return employes;
	}
	
}
