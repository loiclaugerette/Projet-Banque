package com.adaming.myapp.serviceclient;

import java.util.List;
import java.util.Set;

import com.adaming.myapp.entities.Client;
import com.adaming.myapp.entities.Compte;
import com.adaming.myapp.exception.AlreadyLinkedException;
import com.adaming.myapp.service.IServiceGenerique;

public interface IServiceClient extends IServiceGenerique<Client> {
	 Set<Compte> getCompteByClient(Long idClient);
	 List<Client> getClientByMc(String MC);
	 Client addClientToBanque(Long idClient, Long idBanque) throws AlreadyLinkedException;
	 
}
