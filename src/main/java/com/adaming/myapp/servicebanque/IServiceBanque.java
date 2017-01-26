package com.adaming.myapp.servicebanque;

import java.util.List;

import com.adaming.myapp.entities.Banque;
import com.adaming.myapp.entities.Client;
import com.adaming.myapp.entities.Compte;
import com.adaming.myapp.entities.Employe;
import com.adaming.myapp.exception.NullListException;
import com.adaming.myapp.service.IServiceGenerique;

public interface IServiceBanque extends IServiceGenerique<Banque> {
	
	/*
	 * Les  méthodes spécifiques
	 * 
	 */
	
	List <Employe> getEmployeByBanque(Long idBanque) throws NullListException;
	List <Client> getClientByBanque (Long idBanque)throws NullListException;
	List <Compte> getCompteByBanque (Long idBanque)throws NullListException;

}
