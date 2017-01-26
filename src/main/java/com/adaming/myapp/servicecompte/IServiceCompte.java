package com.adaming.myapp.servicecompte;

import java.util.List;

import com.adaming.myapp.entities.Compte;
import com.adaming.myapp.exception.NullListException;
import com.adaming.myapp.service.IServiceGenerique;

public interface IServiceCompte extends IServiceGenerique<Compte> {
	
	// =====================
	// Methodes sp�cifiques
	// =====================

	/*
	 * getCompteByEmploye r�cup�rer la liste de compte cr�� par un employ�
	 * @param (idEmploye)
	 * @return comptesByEmploye
	 */
	List<Compte> getCompteByEmploye(Long idEmploye) throws NullListException;
	
	Compte addCompteToBanque(Long idCompte, Long idBanque);

	Compte addCompteToClient(Long idCompte, Long idClient);

	Compte addCompteToEmploye(Long idCompte, Long idEmploye);


}
