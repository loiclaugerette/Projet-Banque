package com.adaming.myapp.serviceoperation;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.adaming.myapp.entities.Operation;
import com.adaming.myapp.entities.Retrait;
import com.adaming.myapp.entities.Versement;
import com.adaming.myapp.entities.Virement;
import com.adaming.myapp.exception.NullListException;

@Transactional
public class ServiceOperationImpl extends AbstractServiceOperationJPA implements IServiceOperation {

	//=====================
	//   Methods CRUD
	//=====================
	
	@Override
	public Operation add(Operation entity) {
		return addAbstract(entity);
	}

	@Override
	public Operation getOne(Long id) {
		return getOneAbstract(id);
	}

	@Override
	public List<Operation> getAll() throws NullListException {
		return getAllAbstract();
	}

	@Override
	public Operation update(Operation entity) {
		return updateAbstract(entity);
	}

	@Override
	public Operation delete(Long id) {
		return deleteAbstract(id);
	}

	//=====================
	//   Methods
	//=====================
	
	@Override
	public Versement doVersement(Versement versement, Long idCompte) {
		return doVersementAbstract(versement, idCompte);
	}

	@Override
	public Retrait doRetrait(Retrait retrait, Long idCompte) {
		return doRetraitAbstract(retrait, idCompte);
	}

	@Override
	public Virement doVirement(Virement virement, Long idCompteDebite,
			Long idCompteCredite) {
		return doVirementAbstract(virement, idCompteDebite, idCompteCredite);
	}

}
