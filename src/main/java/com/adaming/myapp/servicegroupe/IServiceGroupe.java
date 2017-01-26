package com.adaming.myapp.servicegroupe;

import java.util.List;

import com.adaming.myapp.entities.Employe;
import com.adaming.myapp.entities.Groupe;
import com.adaming.myapp.exception.NullListException;
import com.adaming.myapp.service.IServiceGenerique;

public interface IServiceGroupe extends IServiceGenerique<Groupe> {
	 Groupe addEmToGr(Long idGroupe, Long idEmploye);
	 List <Employe> getEmployeByGroupe(Long idGroupe) throws NullListException;

}
