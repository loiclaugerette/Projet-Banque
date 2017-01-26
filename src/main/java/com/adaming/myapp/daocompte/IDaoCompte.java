package com.adaming.myapp.daocompte;

import java.util.List;

import com.adaming.myapp.dao.IDaoGenerique;
import com.adaming.myapp.entities.Compte;

public interface IDaoCompte extends IDaoGenerique<Compte> {
	
		//=====================
		//   Methodes sp�cifiques
		//=====================
	
	/*
	 * getCompteByEmploye
	 * r�cup�rer la liste de compte cr�� par un employ�
	 * @param (idEmploye)
	 * @return comptesByEmploye
	 */
	List<Compte> getCompteByEmploye(Long idEmploye);
	
	Compte addCompteToBanque(Long idCompte, Long idBanque);

	Compte addCompteToClient(Long idCompte, Long idClient);

	Compte addCompteToEmploye(Long idCompte, Long idEmploye);

}
