package com.adaming.myapp.controller;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.adaming.myapp.entities.Groupe;
import com.adaming.myapp.model.AddGroupeModel;
import com.adaming.myapp.servicegroupe.IServiceGroupe;

@Controller
public class AddGroupeController {

	//=========================
	// Attributes
	//=========================
	
	@Inject
	private IServiceGroupe serviceGroupe;
	private final Logger LOGGER = Logger.getLogger("GroupeController");
	
	
	//=========================
	// Methods
	//=========================
	
	@RequestMapping(value = "/addGroupe", method = RequestMethod.GET)
	public String addGroupe (AddGroupeModel groupeModel){
		Groupe groupe = new Groupe(groupeModel.getCode(), groupeModel.getNom());
		serviceGroupe.add(groupe);
		LOGGER.info("<--------------New Groupe added------------>");
		return "redirect:/";
	}
}
