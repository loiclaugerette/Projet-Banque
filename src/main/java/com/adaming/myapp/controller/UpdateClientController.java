package com.adaming.myapp.controller;

import java.util.logging.Logger;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.adaming.myapp.entities.Client;
import com.adaming.myapp.model.UpdateClientModel;
import com.adaming.myapp.serviceclient.IServiceClient;

@Controller
public class UpdateClientController {

	//=========================
	// Attributes
	//=========================
	
	@Inject
	private IServiceClient serviceClient;
	private final Logger LOGGER = Logger.getLogger("UpdateClientController");

	//=========================
	// Methods
	//=========================

	@RequestMapping(value = "/updateClient/{idClient}", method = RequestMethod.GET)
	public String updateClient(UpdateClientModel updateClientModel, @PathVariable Long idClient) {
		Client client = serviceClient.getOne(idClient);
		client.setNom(updateClientModel.getNom());
		client.setPrenom(updateClientModel.getPrenom());
		client.setAdresse(updateClientModel.getAdresse());
		serviceClient.update(client);
		LOGGER.info("<--------------------- client updated ------------------->");
		return "redirect:/toHome";
	}

}
