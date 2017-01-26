package com.adaming.myapp.daocompte;

import java.util.List;

import com.adaming.myapp.entities.Compte;

public class DaoCompteImpl extends AbstractDaoCompteJPA implements IDaoCompte {

	public DaoCompteImpl() {
		super();
		clazz = Compte.class;
	}

	//=====================
	//   Methodes CRUD
	//=====================
	
	@Override
	public Compte add(Compte entity) {
		return addAbstract(entity);
	}

	@Override
	public Compte getOne(Long id) {
		return getOneAbstract(id);
	}

	@Override
	public List<Compte> getAll() {
		return getAllAbstract();
	}

	@Override
	public Compte update(Compte entity) {
		return updateAbstract(entity);
	}

	@Override
	public Compte delete(Long id) {
		return deleteAbstract(id);
	}
	
	//=====================
	//   Methodes spécifiques
	//=====================
	
	/*
	 * getCompteByEmploye
	 * récupérer la liste de compte créé par un employé
	 * @param (idEmploye)
	 * @return comptesByEmploye
	 */
	@Override
	public List<Compte> getCompteByEmploye(Long idEmploye) {
		return getCompteByEmployeAbstract(idEmploye);
	}
	
	public Compte addCompteToBanque(Long idCompte, Long idBanque) {
		return addCompteToBanqueAbstract(idCompte, idBanque);
	}

	public Compte addCompteToClient(Long idCompte, Long idClient) {
		return addCompteToClientAbstract(idCompte, idClient);
	}

	public Compte addCompteToEmploye(Long idCompte, Long idEmploye) {
		return addCompteToEmployeAbstract(idCompte, idEmploye);
	}

}
