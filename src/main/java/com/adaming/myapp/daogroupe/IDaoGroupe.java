package com.adaming.myapp.daogroupe;

import java.util.List;

import com.adaming.myapp.dao.IDaoGenerique;
import com.adaming.myapp.entities.Employe;
import com.adaming.myapp.entities.Groupe;
import com.adaming.myapp.exception.NullListException;

public interface IDaoGroupe extends IDaoGenerique<Groupe> {
	 Groupe addEmToGr(Long idGroupe, Long idEmploye);
	 List <Employe> getEmployeByGroupe(Long idGroupe);
	
}
