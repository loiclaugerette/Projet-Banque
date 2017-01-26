package com.adaming.myapp.serviceclient;

import java.util.List;
import java.util.Set;

import org.springframework.transaction.annotation.Transactional;

import com.adaming.myapp.entities.Client;
import com.adaming.myapp.entities.Compte;
import com.adaming.myapp.exception.AlreadyLinkedException;
import com.adaming.myapp.exception.NullListException;

@Transactional
public class ServiceClientImpl extends AbstractServiceClientJPA implements IServiceClient {

	@Override
	public Client add(Client entity) {
		return addAbstract(entity);
	}

	@Override
	public Client getOne(Long id) {
		return getOneAbstract(id);
	}

	@Override
	public List<Client> getAll() throws NullListException {
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

	
	//========================================
	//	Methodes specifiques a la class Client
	//========================================
	@Override
	public List<Client> getClientByMc(String MC) {
		return getClientByMcAbstract(MC);
	}

	@Override
	public Set<Compte> getCompteByClient(Long idClient) {
		
		return getCompteByClientAbstract(idClient);
	}
	
	public Client addClientToBanque(Long idClient, Long idBanque) throws AlreadyLinkedException {
		return addClientToBanqueAbstract(idClient, idBanque);
	}

}
