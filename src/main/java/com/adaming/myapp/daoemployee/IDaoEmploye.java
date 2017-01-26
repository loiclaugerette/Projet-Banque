package com.adaming.myapp.daoemployee;

import com.adaming.myapp.dao.IDaoGenerique;
import com.adaming.myapp.entities.Employe;

public interface IDaoEmploye extends IDaoGenerique<Employe>{
	
	Employe addEmployeToBanque(Long idEmploye, Long idBanque);

}
