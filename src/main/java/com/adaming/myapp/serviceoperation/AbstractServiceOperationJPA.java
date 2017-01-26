package com.adaming.myapp.serviceoperation;

import com.adaming.myapp.daooperation.IDaoOperation;
import com.adaming.myapp.entities.Operation;
import com.adaming.myapp.entities.Retrait;
import com.adaming.myapp.entities.Versement;
import com.adaming.myapp.entities.Virement;
import com.adaming.myapp.service.AbstractServiceGeneriqueJPA;

public class AbstractServiceOperationJPA extends AbstractServiceGeneriqueJPA<Operation> {
	
	//=========================
	// Attributes
	//=========================

	private IDaoOperation daoOperation;
	
	//=============================
	//    Setter
	//=============================
	
	public void setDaoOperation(IDaoOperation daoOperation) {
		this.daoOperation = daoOperation;
	}
	
	//=========================
	// Methods
	//=========================

	public Versement doVersementAbstract(Versement versement, Long idCompte) {
		return daoOperation.doVersement(versement, idCompte);
	}

	public Retrait doRetraitAbstract(Retrait retrait, Long idCompte) {
		return daoOperation.doRetrait(retrait, idCompte);
	}

	public Virement doVirementAbstract(Virement virement, Long idCompteDebite, Long idCompteCredite) {
		return daoOperation.doVirement(virement, idCompteDebite, idCompteCredite);
	}
	
}
