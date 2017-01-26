package com.adaming.myapp.daoclient;

import java.util.List;
import java.util.Set;

import com.adaming.myapp.entities.Client;
import com.adaming.myapp.entities.Compte;

public class DaoClientImpl extends AbstractDaoClientJPA implements IDaoClient {

	public DaoClientImpl() {
		super();
		clazz = Client.class;
	}

	//=====================
	//   Methodes CRUD
	//=====================
	
	@Override
	public Client add(Client entity) {
		return addAbstract(entity);
	}

	@Override
	public Client getOne(Long id) {
		return getOneAbstract(id);
	}

	@Override
	public List<Client> getAll() {
		return getAllAbstract();
	}

	@Override
	public Client update(Client entity) {
		return updateAbstract(entity);
	}

	@Override
	public Client delete(Long id) {
		return deleteAbstract(id);
	}

	//=====================
	//   Methodes spécifique
	//=====================
	
	/*
	 * getCompteClient
	 * récupérer la liste de compte d'un client
	 * @param (idClient)
	 * @return List<Compte> comptesClient
	 */	
	@Override
	public Set<Compte> getCompteByClient(Long idClient) {
		return getCompteByClientAbstract(idClient);
	}

	@Override
	public List<Client> getClientByMc(String MC) {
		return getClientByMcAbstract(MC);
	}
	
	public Client addClientToBanque(Long idClient, Long idBanque) {
		return addClientToBanqueAbstract(idClient, idBanque);
	}

}
