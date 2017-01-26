package com.adaming.myapp.serviceemployee;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.adaming.myapp.entities.Employe;
import com.adaming.myapp.exception.NullListException;

@Transactional
public class ServiceEmployeImpl extends AbstractServiceEmployeJPA implements IServiceEmploye {

	@Override
	public Employe add(Employe entity) {
		return addAbstract(entity);
	}

	@Override
	public Employe getOne(Long id) {
		return getOneAbstract(id);
	}

	@Override
	public List<Employe> getAll() throws NullListException {
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
	
	@Override
	public Employe addEmployeToBanque(Long idEmploye, Long idBanque) {
		return addEmployeToBanqueAbstract(idEmploye, idBanque);
	}

}
