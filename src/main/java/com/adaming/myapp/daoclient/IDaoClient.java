package com.adaming.myapp.daoclient;

import java.util.List;
import java.util.Set;

import com.adaming.myapp.dao.IDaoGenerique;
import com.adaming.myapp.entities.Client;
import com.adaming.myapp.entities.Compte;

public interface IDaoClient extends IDaoGenerique<Client> {
	
	//=====================
	//   Methodes spécifiques
	//=====================
	
	/*
	 * getCompteClient
	 * récupérer la liste de compte d'un client
	 * @param (idClient)
	 * @return comptesByClient
	 */
	Set<Compte> getCompteByClient(Long idClient);
	List<Client> getClientByMc(String MC);
	Client addClientToBanque(Long idClient, Long idBanque);
	

}
