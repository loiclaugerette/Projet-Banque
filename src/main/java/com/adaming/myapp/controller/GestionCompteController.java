package com.adaming.myapp.controller;

import java.util.Date;
import java.util.logging.Logger;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.adaming.myapp.entities.Retrait;
import com.adaming.myapp.entities.Versement;
import com.adaming.myapp.entities.Virement;
import com.adaming.myapp.model.GestionCompteModel;
import com.adaming.myapp.serviceclient.IServiceClient;
import com.adaming.myapp.servicecompte.IServiceCompte;
import com.adaming.myapp.serviceoperation.IServiceOperation;

@Controller
@RequestMapping(value = "toCompte/")
public class GestionCompteController {

	//=========================
	// Attributes
	//=========================
	
	@Inject
	private IServiceCompte serviceCompte;
	@Inject
	private IServiceOperation serviceOperation;
	@Inject
	private IServiceClient serviceClient;
	private final Logger LOGGER = Logger.getLogger("ComptesClientController");
	
	//=========================
	// Methods
	//=========================
	
	@RequestMapping(value = "deleteCompte/{idCompte}", method = RequestMethod.GET)
	public String deleteCompte(Model model, @PathVariable Long idCompte) {
		serviceCompte.delete(idCompte);
		LOGGER.info("<---------------------- delete Compte ------------------------>");
		return "../home";
	}
	
	@RequestMapping(value = "doVersement/{idCompte}", method = RequestMethod.GET)
	public String doVersement(Model model, GestionCompteModel gestionCompteModel, @PathVariable Long idCompte) {
		Versement versement = new Versement(new Date(), gestionCompteModel.getMontantOperation());
		serviceOperation.doVersement(versement, idCompte);
		model.addAttribute("gestionCompteModel", gestionCompteModel);
		LOGGER.info("<----------------Versement added---------------->");
		return "redirect:/toHome";
	}
	
	@RequestMapping(value ="doRetrait/{idCompte}", method = RequestMethod.GET)
	public String doRetrait(Model model, GestionCompteModel gestionCompteModel, @PathVariable Long idCompte){
		Retrait retrait = new Retrait(new Date(), gestionCompteModel.getMontantOperation());
		serviceOperation.doRetrait(retrait, idCompte);
		model.addAttribute("gestionCompteModel", gestionCompteModel);
		LOGGER.info("<-----------------Retrait added-------------->");
		return"redirect:/toHome"; //redirect:/toHome"
	}
	
	@RequestMapping(value ="doVirement/{idCompte}", method = RequestMethod.GET)
	public String doVirement(Model model, GestionCompteModel gestionCompteModel, @PathVariable Long idCompte){
		gestionCompteModel.setMontantOperation(gestionCompteModel.getMontantOperation());
		gestionCompteModel.setCompte(serviceCompte.getOne(idCompte));
		gestionCompteModel.setClient(serviceClient.getOne(gestionCompteModel.getSelectedClient()));
		gestionCompteModel.setComptes(serviceClient.getCompteByClient(gestionCompteModel.getSelectedClient()));
		model.addAttribute("gestionCompteModel", gestionCompteModel);
		LOGGER.info("<------------------ to virement ----------------->");		
		return "virement";
	}
	
	@RequestMapping(value = "doVirement/virement/{idCompte}/{montantOperation}", method = RequestMethod.GET)
	public String virement(GestionCompteModel gestionCompteModel, @PathVariable Long idCompte, @PathVariable double montantOperation) {
		Virement virement = new Virement(new Date(), Math.abs(montantOperation));
		serviceOperation.doVirement(virement, idCompte, gestionCompteModel.getIdCompteCible());
		LOGGER.info("<---------------- Virement added ----------------->");
		return "redirect:/toHome";
	}
	
}
