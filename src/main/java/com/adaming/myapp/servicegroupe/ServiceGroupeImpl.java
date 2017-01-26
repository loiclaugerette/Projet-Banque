package com.adaming.myapp.servicegroupe;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.adaming.myapp.entities.Employe;
import com.adaming.myapp.entities.Groupe;
import com.adaming.myapp.exception.NullListException;

@Transactional
public class ServiceGroupeImpl extends AbstractServiceGroupeJPA implements IServiceGroupe {

	@Override
	public Groupe add(Groupe entity) {
		return addAbstract(entity);
	}

	@Override
	public Groupe getOne(Long id) {
		return getOneAbstract(id);
	}

	@Override
	public List<Groupe> getAll() throws NullListException {
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
	public List<Employe> getEmployeByGroupe(Long idGroupe) throws NullListException {
		
		return getEmployeByGroupeAbstract(idGroupe);
	}

}
