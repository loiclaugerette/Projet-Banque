package com.adaming.myapp.controller;

import java.util.logging.Logger;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.adaming.myapp.exception.NullListException;
import com.adaming.myapp.model.AddCompteModel;
import com.adaming.myapp.model.GestionCompteModel;
import com.adaming.myapp.servicebanque.IServiceBanque;
import com.adaming.myapp.serviceclient.IServiceClient;
import com.adaming.myapp.servicecompte.IServiceCompte;
import com.adaming.myapp.serviceemployee.IServiceEmploye;

@Controller
public class ComptesClientController {

	//=========================
	// Attributes
	//=========================
	
	@Inject
	private IServiceClient serviceClient;
	@Inject
	private IServiceCompte serviceCompte;
	@Inject
	private IServiceBanque serviceBanque;
	@Inject
	private IServiceEmploye serviceEmploye;
	private final Logger LOGGER = Logger.getLogger("ComptesClientController");
	
	//=========================
	// Methods
	//=========================
	
	@RequestMapping(value = "/toCompte/{idCompte}", method = RequestMethod.GET)
	public String toCompte(Model model, @PathVariable Long idCompte) {
		try {
			GestionCompteModel gestionCompteModel = new GestionCompteModel();
			gestionCompteModel.setCompte(serviceCompte.getOne(idCompte));
			gestionCompteModel.setClients(serviceClient.getAll());
			model.addAttribute("gestionCompteModel", gestionCompteModel);
			LOGGER.info("<-------------------- toCompte --------------------->");
			return "gestionCompte";
		} catch (NullListException e) {
			e.printStackTrace();
			return "toCompte";
		}
	}
	
	@RequestMapping(value = "/toAddCompte/{idClient}", method = RequestMethod.GET)
	public String toAddCompte(Model model, @PathVariable Long idClient) {
		try {
			AddCompteModel addCompteModel = new AddCompteModel();
			addCompteModel.setClient(serviceClient.getOne(idClient));
			addCompteModel.setBanques(serviceBanque.getAll());
			addCompteModel.setEmployes(serviceEmploye.getAll());
			model.addAttribute("addCompteModel", addCompteModel);
			LOGGER.info("<-------------------- to addCompte ------------------------->");
			return "addCompte";
		} catch (NullListException e) {
			e.printStackTrace();
			model.addAttribute("message", "Veuillez vérifier la présence de banques et d'employé dans la base de données.");
			LOGGER.warning("<------------------ No Banque or No Employe in DataBase ----------------------->");
			return "home";
		}
	}

}
