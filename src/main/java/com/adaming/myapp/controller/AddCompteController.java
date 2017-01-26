package com.adaming.myapp.controller;



import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.adaming.myapp.entities.Compte;
import com.adaming.myapp.entities.CompteCourant;
import com.adaming.myapp.entities.CompteEpargne;
import com.adaming.myapp.exception.AlreadyLinkedException;
import com.adaming.myapp.model.AddCompteModel;
import com.adaming.myapp.serviceclient.IServiceClient;
import com.adaming.myapp.servicecompte.IServiceCompte;

@Controller
public class AddCompteController {

	//=========================
	// Attributes
	//=========================
	@Inject
	private IServiceCompte serviceCompte;
	@Inject
	private IServiceClient serviceClient;
	private final Logger LOGGER = Logger.getLogger("CompteController");
	

	//=========================
	// Methods
	//=========================
	@RequestMapping(value= "toAddCompte/addCompte/{idClient}", method = RequestMethod.GET)
	public String addCompte(AddCompteModel compteModel, @PathVariable Long idClient){
		String action = compteModel.getAction();
		try {
			serviceClient.addClientToBanque(idClient, compteModel.getIdBanque());
		} catch (AlreadyLinkedException e) {
			e.printStackTrace();
		}
		if(action.equals("courant")){
			
			Compte compteCourant = new CompteCourant(compteModel.getNumeroCompte(), compteModel.getSolde(), compteModel.getDateCreation(), compteModel.getDecouvert());
			serviceCompte.add(compteCourant);
			serviceCompte.addCompteToClient(compteCourant.getIdCompte(), idClient);
			serviceCompte.addCompteToBanque(compteCourant.getIdCompte(), compteModel.getIdBanque());
			serviceCompte.addCompteToEmploye(compteCourant.getIdCompte(), compteModel.getIdEmploye());
			LOGGER.info("<--------new compteCourant added-------------->");
			return "home";
		}
		if(action.equals("epargne")){
			Compte compteEpargne = new CompteEpargne(compteModel.getNumeroCompte(), compteModel.getSolde(), compteModel.getDateCreation(), compteModel.getTauxInteret());
			serviceCompte.add(compteEpargne);
			serviceCompte.addCompteToClient(compteEpargne.getIdCompte(), idClient);
			serviceCompte.addCompteToBanque(compteEpargne.getIdCompte(), compteModel.getIdBanque());
			serviceCompte.addCompteToEmploye(compteEpargne.getIdCompte(), compteModel.getIdEmploye());
			LOGGER.info("<--------new compteEpargne added-------------->");
			return "home";
		}
		return "redirect:/";
	}
}
