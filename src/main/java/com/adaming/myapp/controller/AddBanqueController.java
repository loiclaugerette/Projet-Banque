package com.adaming.myapp.controller;

import java.util.logging.Logger;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.adaming.myapp.entities.Banque;
import com.adaming.myapp.model.AddBanqueModel;
import com.adaming.myapp.servicebanque.IServiceBanque;

@Controller
public class AddBanqueController {

	//=========================
	// Attributes
	//=========================

	@Inject
	private IServiceBanque serviceBanque;
	private final Logger LOGGER = Logger.getLogger("BanqueController");
	
	//=========================
	// Methods
	//=========================

	 @RequestMapping(value = "/addBanque", method = RequestMethod.GET)
	 public String addBanque(AddBanqueModel banqueModel){
		 Banque banque = new Banque(banqueModel.getNom(), banqueModel.getAdresse(), banqueModel.getCodePostal());
		 serviceBanque.add(banque);
		 LOGGER.info("<--------------------new Banque added-------------------->");
		 return "redirect:/";
		 
	 }
}
