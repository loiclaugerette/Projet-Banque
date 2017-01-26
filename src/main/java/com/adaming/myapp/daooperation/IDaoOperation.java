package com.adaming.myapp.daooperation;

import com.adaming.myapp.dao.IDaoGenerique;
import com.adaming.myapp.entities.Operation;
import com.adaming.myapp.entities.Retrait;
import com.adaming.myapp.entities.Versement;
import com.adaming.myapp.entities.Virement;

public interface IDaoOperation extends IDaoGenerique<Operation> {

	//=========================
	// Methods
	//=========================
	
	/*
	 * doVersement
	 * @param (versement, idCompte)
	 * @return void
	 */
	public Versement doVersement(Versement versement, Long idCompte);
	
	/*
	 * doRetrait
	 * @param (retrait, idCompte)
	 * @return void
	 */
	public Retrait doRetrait(Retrait retrait, Long idCompte);
	
	/*
	 * doVirement
	 * @param (virement, idCompteDebite, idCompteCredite);
	 */
	public Virement doVirement(Virement virement, Long idCompteDebite, Long idCompteCredite);
	
}
