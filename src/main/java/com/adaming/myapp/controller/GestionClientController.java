package com.adaming.myapp.controller;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.adaming.myapp.entities.Client;
import com.adaming.myapp.model.ComptesClientModel;
import com.adaming.myapp.model.GestionClientModel;
import com.adaming.myapp.model.UpdateClientModel;
import com.adaming.myapp.serviceclient.IServiceClient;



@Controller

public class GestionClientController {

	//=========================
	// Attributes
	//=========================
	@Inject
	private IServiceClient serviceClient;
	private final Logger LOGGER = Logger.getLogger("GestionClientController");
	

	//=========================
	// Methods
	//=========================

	@RequestMapping(value = "/rechercheMc", method = RequestMethod.GET)
	public String rechercheMc(Model model, GestionClientModel gestionClientModel){
		gestionClientModel.setClients(serviceClient.getClientByMc(gestionClientModel.getMc()));
		model.addAttribute("gestionClientModel", gestionClientModel);
		return "gestionClient";
	}
	@RequestMapping(value = "/actionClient", method = RequestMethod.GET)
	public String actionClient(Model model, GestionClientModel gestionClientModel){
		String action = gestionClientModel.getAction();
			LOGGER.info("----------------action---------------------------------" + action);
		if(action.equals("Afficher")){
			ComptesClientModel comptesClientModel = new ComptesClientModel();
			comptesClientModel.setClient(serviceClient.getOne(gestionClientModel.getSelectedClient()));
			comptesClientModel.setComptes(serviceClient.getCompteByClient(gestionClientModel.getSelectedClient()));
			model.addAttribute("comptesClientModel", comptesClientModel);
			LOGGER.info("<--------------la liste des comptes par client--------------->");
			return "comptesClient";
		}
		
		else if(action.equals("Supprimer")){
			serviceClient.delete(gestionClientModel.getSelectedClient());
			LOGGER.info("<---------le client selectionné a été supprimé--------------->");
			
			return "../home";
		}
		
		else if (action.equals("Modifier")){
			Client client = serviceClient.getOne(gestionClientModel.getSelectedClient());
			UpdateClientModel updateClientModel = new UpdateClientModel();
			updateClientModel.setIdClient(client.getIdClient());
			updateClientModel.setCode(client.getCode());
			updateClientModel.setNom(client.getNom());
			updateClientModel.setPrenom(client.getPrenom());
			updateClientModel.setDateEntree(client.getDateEntree());
			updateClientModel.setAdresse(client.getAdresse());
			model.addAttribute("updateClientModel", updateClientModel);
			return "updateClient";	
		}
		return "redirect:/";
		
	}
}
