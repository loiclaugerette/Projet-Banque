package com.adaming.myapp.controller;

import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.adaming.myapp.entities.Employe;
import com.adaming.myapp.exception.NullListException;
import com.adaming.myapp.model.GestionGroupeModel;
import com.adaming.myapp.serviceemployee.IServiceEmploye;
import com.adaming.myapp.servicegroupe.IServiceGroupe;

@Controller
public class GestionGroupeController {

	//=========================
	// Attributes
	//=========================
	
	@Inject
	private IServiceGroupe serviceGroupe;
	@Inject
	private IServiceEmploye serviceEmploye;
	private final Logger LOGGER = Logger.getLogger("groupeController");

	//=========================
	// Methods
	//=========================
	
	@RequestMapping(value="/printEmployeByGroupe", method = RequestMethod.GET)
	public String getEmployeByGroupe(Model model, GestionGroupeModel groupeModel){
		try {
			Long idGroupe = groupeModel.getSelectedGroupe();
			List<Employe> employes =  serviceGroupe.getEmployeByGroupe(idGroupe);
			groupeModel.setEmployesByGroupe(employes);
			groupeModel.setEmployes(serviceEmploye.getAll());
			groupeModel.setGroupes(serviceGroupe.getAll());
			LOGGER.info("<-----------------List of employes generated----------------->");
			model.addAttribute("gestionGroupeModel", groupeModel);
			return "gestionGroupe";
		} catch (NullListException e) {
			e.printStackTrace();
			try {
				groupeModel.setEmployes(serviceEmploye.getAll());
				groupeModel.setGroupes(serviceGroupe.getAll());
				model.addAttribute("gestionGroupeModel", groupeModel);
			} catch (NullListException e1) {
				e1.printStackTrace();
			}
			LOGGER.warn("<-------------- No Employe in this group in DataBase ---------------------->");
			model.addAttribute("message", "Il n'y a aucun employé le groupe " + serviceGroupe.getOne(groupeModel.getSelectedGroupe()).getNom());
			return "gestionGroupe";
		}
	}
	
	@RequestMapping(value="/addEmToGr", method = RequestMethod.GET)
	public String addEmToGre(Model model, GestionGroupeModel gestionGroupeModel){
		serviceGroupe.addEmToGr(gestionGroupeModel.getSelectedGroupe1(), gestionGroupeModel.getSelectedEmploye());
		LOGGER.info("<-----------------List of employes generated----------------->");
		model.addAttribute("gestionGroupeModel", gestionGroupeModel);
		return "home";
	}

}
