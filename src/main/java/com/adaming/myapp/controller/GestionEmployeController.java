package com.adaming.myapp.controller;

import java.util.logging.Logger;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.adaming.myapp.exception.NullListException;
import com.adaming.myapp.model.GestionEmployeModel;
import com.adaming.myapp.servicecompte.IServiceCompte;
import com.adaming.myapp.serviceemployee.IServiceEmploye;

@Controller
public class GestionEmployeController {

	//=========================
	// Attributes
	//=========================
	
	@Inject
	private IServiceEmploye serviceGestionEmploye;
	@Inject
	private IServiceCompte serviceCompte;
	private final Logger LOGGER = Logger.getLogger("GestionEmploye");

	//=========================
	// Methods
	//=========================
	
	/*
	 * getbymc
	 */
	
	/*
	 * suppression employe
	 */
	@RequestMapping(value = "/gestionEmploye/deleteEmploye", method= RequestMethod.GET)
	public String deleteEmploye(GestionEmployeModel employeModel){
		serviceGestionEmploye.delete(employeModel.getIdEmploye());
		LOGGER.info("<-------------------Employe deleted----------------->");
		return "gestionEmploye";
	}
	
	
	/*
	 * afficher la liste de compte
	 */
	@RequestMapping(value ="/getComptesByEmploye", method=RequestMethod.GET)
	public String getComptesByEmploye(Model model, GestionEmployeModel gestionEmployeModel){
		try {
			gestionEmployeModel.setComptes(serviceCompte.getCompteByEmploye(gestionEmployeModel.getSelectedEmploye()));
			gestionEmployeModel.setEmployes(serviceGestionEmploye.getAll());
			model.addAttribute("gestionEmployeModel", gestionEmployeModel);
			return "gestionEmploye";
		} catch (NullListException e) {
			e.printStackTrace();
			try {
				gestionEmployeModel.setEmployes(serviceGestionEmploye.getAll());
			} catch (NullListException e1) {
				e1.printStackTrace();
			}
			model.addAttribute("gestionEmployeModel", gestionEmployeModel);
			model.addAttribute("message", "L'employé " + serviceGestionEmploye.getOne(gestionEmployeModel.getSelectedEmploye()).getNom() + " ne gère aucun compte.");
			LOGGER.warning("<-------------------- No comptes for this Employe -------------------->");
			return "gestionEmploye";
		}
	}

}
