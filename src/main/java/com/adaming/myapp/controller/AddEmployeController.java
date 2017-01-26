package com.adaming.myapp.controller;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.adaming.myapp.entities.Employe;
import com.adaming.myapp.model.AddEmployeModel;
import com.adaming.myapp.servicebanque.IServiceBanque;
import com.adaming.myapp.serviceemployee.IServiceEmploye;

	@Controller
public class AddEmployeController {

	//=========================
	// Attributes
	//=========================
	@Inject
	private IServiceEmploye serviceEmploye;
	@Inject
	private IServiceBanque serviceBanque;
	private final Logger LOGGER = Logger.getLogger("employeController");

	
	//=========================
	// Methods
	//=========================

	@RequestMapping(value="/addEmploye", method = RequestMethod.GET)
	public String addEmploye(Model model, AddEmployeModel employeModel){
	Employe employe =  new Employe(employeModel.getCode(), employeModel.getNom());
	serviceEmploye.add(employe);
	serviceEmploye.addEmployeToBanque(employe.getIdEmploye(), employeModel.getSelectedBanque());
	LOGGER.info("<--------------------------New Employe	 added----------------------->");
		
	return "home";
		
	}
}
