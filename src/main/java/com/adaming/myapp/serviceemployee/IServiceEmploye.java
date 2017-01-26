package com.adaming.myapp.serviceemployee;

import com.adaming.myapp.entities.Employe;
import com.adaming.myapp.service.IServiceGenerique;

public interface IServiceEmploye extends IServiceGenerique<Employe>{
	
	Employe addEmployeToBanque(Long idEmploye, Long idBanque);

}
