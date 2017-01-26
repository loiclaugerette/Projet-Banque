package com.adaming.myapp.daogroupe;

import java.util.List;

import com.adaming.myapp.entities.Employe;
import com.adaming.myapp.entities.Groupe;
import com.adaming.myapp.exception.NullListException;

public class DaoGroupeImpl extends AbstractDaoGroupeJPA implements IDaoGroupe {

	public DaoGroupeImpl() {
		super();
		clazz = Groupe.class;
	}

	//=====================
	//   Methodes CRUD
	//=====================
	
	@Override
	public Groupe add(Groupe entity) {
		return addAbstract(entity);
	}

	@Override
	public Groupe getOne(Long id) {
		return getOneAbstract(id);
	}

	@Override
	public List<Groupe> getAll() {
		return getAllAbstract();
	}

	@Override
	public Groupe update(Groupe entity) {
		return updateAbstract(entity);
	}

	@Override
	public Groupe delete(Long id) {
		return deleteAbstract(id);
	}

	
	//========================================
	//	Methodes specifiques a la class Groupe
	//========================================
	
	@Override
	public Groupe addEmToGr(Long idGroupe, Long idEmploye) {
		return addEmToGrAbstract(idGroupe, idEmploye);
	}

	@Override
	public List<Employe> getEmployeByGroupe(Long idGroupe) {
		return getEmployeByGroupeAbstract(idGroupe);
	}




}
