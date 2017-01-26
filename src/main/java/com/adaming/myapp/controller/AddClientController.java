package com.adaming.myapp.controller;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.adaming.myapp.entities.Client;
import com.adaming.myapp.model.AddClientModel;
import com.adaming.myapp.serviceclient.IServiceClient;
@Controller
public class AddClientController {

	//=========================
	// Attributes
	//=========================
	
	@Inject
	private IServiceClient serviceClient;
	private final Logger LOGGER = Logger.getLogger("clientController");
	
	//=========================
	// Methods
	//=========================
	
	@RequestMapping(value ="/addClient", method = RequestMethod.GET)
	public String addClient(AddClientModel clientModel){
		Client client = new Client(clientModel.getCode(), clientModel.getNom(), clientModel.getPrenom(), clientModel.getDateEntree(), clientModel.getAdresse());
		serviceClient.add(client);
		LOGGER.info("<--------------------------New Client added----------------------->");
		return "home";
	}

}
