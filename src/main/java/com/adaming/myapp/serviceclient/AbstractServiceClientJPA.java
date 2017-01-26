package com.adaming.myapp.serviceclient;

import java.util.List;
import java.util.Set;

import com.adaming.myapp.daoclient.IDaoClient;
import com.adaming.myapp.entities.Banque;
import com.adaming.myapp.entities.Client;
import com.adaming.myapp.entities.Compte;
import com.adaming.myapp.exception.AlreadyLinkedException;
import com.adaming.myapp.service.AbstractServiceGeneriqueJPA;

public class AbstractServiceClientJPA extends AbstractServiceGeneriqueJPA<Client> {
	
	private IDaoClient daoclient;	
	
	//===========================
	// Setter
	//===========================
	
	public void setDaoclient(IDaoClient daoclient) {
		this.daoclient = daoclient;
	}
	
	//======================================================
	// rédéfinition des méthodes spéciques de IDaoBanque 
	//======================================================

	
	public Set<Compte> getCompteByClientAbstract(Long idClient){
		return daoclient.getCompteByClient(idClient);	
	}
	
	public List<Client> getClientByMcAbstract(String MC){
		return daoclient.getClientByMc(MC);	
	}
	
	public Client addClientToBanqueAbstract(Long idClient, Long idBanque) throws AlreadyLinkedException {
		Client client = dao.getOne(idClient);
		List<Banque> banques = client.getBanques();
		for (Banque banque:banques) {
			if (banque.getIdBanque() == idBanque) {
				throw new AlreadyLinkedException("The client " + client + " is already linked with the banque " + banque);
			}
		}
		return daoclient.addClientToBanque(idClient, idBanque);
	}
	
}
