package com.adaming.myapp.daobanque;

import java.util.List;

import com.adaming.myapp.entities.Banque;
import com.adaming.myapp.entities.Client;
import com.adaming.myapp.entities.Compte;
import com.adaming.myapp.entities.Employe;

public class DaoBanqueImpl extends AbstractDaoBanqueJPA implements IDaoBanque {
	
	public DaoBanqueImpl() {
		super();
		clazz = Banque.class;
	}

	//=====================
	//   Methodes CRUD
	//=====================
	
	@Override
	public Banque add(Banque entity) {
		return addAbstract(entity);
	}

	@Override
	public Banque getOne(Long id) {
		return getOneAbstract(id);
	}

	@Override
	public List<Banque> getAll() {
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
	public List<Employe> getEmployeByBanque(Long idBanque) {
		// TODO Auto-generated method stub
		return getEmployeByBanqueAbstract(idBanque);
	}

	@Override
	public List<Client> getClientByBanque(Long idBanque) {
		// TODO Auto-generated method stub
		return getClientByBanqueAbstract(idBanque);
	}

	@Override
	public List<Compte> getCompteByBanque(Long idBanque) {
		// TODO Auto-generated method stub
		return getCompteByBanqueAbstract(idBanque);
	}

}
