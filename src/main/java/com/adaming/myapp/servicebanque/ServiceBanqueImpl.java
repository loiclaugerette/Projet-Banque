package com.adaming.myapp.servicebanque;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.adaming.myapp.entities.Banque;
import com.adaming.myapp.entities.Client;
import com.adaming.myapp.entities.Compte;
import com.adaming.myapp.entities.Employe;
import com.adaming.myapp.exception.NullListException;

@Transactional
public class ServiceBanqueImpl extends AbstractServiceBanqueJPA implements IServiceBanque {

	@Override
	public Banque add(Banque entity) {
		return addAbstract(entity);
	}

	@Override
	public Banque getOne(Long id) {
		return getOneAbstract(id);
	}

	@Override
	public List<Banque> getAll() throws NullListException {
		return getAllAbstract();
	}

	@Override
	public Banque update(Banque entity) {
		return updateAbstract(entity);
	}

	@Override
	public Banque delete(Long id) {
		return deleteAbstract(id);
	}

	
	//========================================
	//	Methodes specifiques a la class Banque
	//========================================
	
	@Override
	public List<Employe> getEmployeByBanque(Long idBanque) throws NullListException {
		
		return getEmployeByBanqueAbstract(idBanque);
	}

	@Override
	public List<Client> getClientByBanque(Long idBanque)throws NullListException {
		
		return getClientByBanqueAbstract(idBanque);
	}

	@Override
	public List<Compte> getCompteByBanque(Long idBanque) throws NullListException{
		
		return getCompteByBanqueAbstract(idBanque);
	}

}
