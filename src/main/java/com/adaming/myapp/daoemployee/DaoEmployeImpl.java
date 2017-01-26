package com.adaming.myapp.daoemployee;

import java.util.List;

import com.adaming.myapp.entities.Employe;

public class DaoEmployeImpl extends AbstractDaoEmployeJPA implements IDaoEmploye {

	public DaoEmployeImpl() {
		super();
		clazz = Employe.class;
	}

	//=====================
	//   Methodes CRUD
	//=====================
	
	@Override
	public Employe add(Employe entity) {
		return addAbstract(entity);
	}

	@Override
	public Employe getOne(Long id) {
		return getOneAbstract(id);
	}

	@Override
	public List<Employe> getAll() {
		return getAllAbstract();
	}

	@Override
	public Employe update(Employe entity) {
		return updateAbstract(entity);
	}

	@Override
	public Employe delete(Long id) {
		return deleteAbstract(id);
	}
	
	public Employe addEmployeToBanque(Long idEmploye, Long idBanque) {
		return addEmployeToBanqueAbstract(idEmploye, idBanque);
	}

}
