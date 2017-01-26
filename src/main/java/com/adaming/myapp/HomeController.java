package com.adaming.myapp;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.adaming.myapp.exception.NullListException;
import com.adaming.myapp.model.AddEmployeModel;
import com.adaming.myapp.model.GestionBanqueModel;
import com.adaming.myapp.model.GestionClientModel;
import com.adaming.myapp.model.GestionEmployeModel;
import com.adaming.myapp.model.GestionGroupeModel;
import com.adaming.myapp.servicebanque.IServiceBanque;
import com.adaming.myapp.serviceclient.IServiceClient;
import com.adaming.myapp.serviceclient.ServiceClientImpl;
import com.adaming.myapp.servicecompte.IServiceCompte;
import com.adaming.myapp.serviceemployee.IServiceEmploye;
import com.adaming.myapp.serviceemployee.ServiceEmployeImpl;
import com.adaming.myapp.servicegroupe.IServiceGroupe;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(HomeController.class);
	@Inject
	private IServiceBanque serviceBanque;
	@Inject
	private IServiceClient serviceClient;
	@Inject
	private IServiceGroupe serviceGroupe;
	@Inject
	private IServiceEmploye serviceEmploye;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		LOGGER.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);
		// comments
		model.addAttribute("serverTime", formattedDate);

		return "home";

	}

	// ============================
	// Home
	// ============================

	@RequestMapping(value = "/toHome", method = RequestMethod.GET)
	public String toHome() {
		LOGGER.info("<-----------toHome-------------->");
		return "redirect:/";
	}

	// ============================
	// Banque
	// ============================

	@RequestMapping(value = "/toAddBanque", method = RequestMethod.GET)
	public String toAddBanque() {
		LOGGER.info("<-----------toAddBnaque-------------->");
		return "addBanque";
	}

//	@RequestMapping(value = "/toAddBanque", method = RequestMethod.GET)
//	public String toAddBanque(Model model) {
//		
//		LOGGER.info("<-----------toAddBnaque-------------->");
//		return "sessionTest";
//	}

	@RequestMapping(value = "/toGestionBanque", method = RequestMethod.GET)
	public String toGestionBanque(Model model) {
		try {
			GestionBanqueModel gestionBanqueModel = new GestionBanqueModel();
			gestionBanqueModel.setBanques(serviceBanque.getAll());
			model.addAttribute("gestionBanqueModel", gestionBanqueModel);
			LOGGER.info("<-----------toGestionBanque-------------->");
			return "gestionBanque";
		} catch (NullListException e) {
			e.printStackTrace();
			LOGGER.warn("<------------ No Banque in DataBase ------------->");
			return "home";
		}
	}

	// ============================
	// Client
	// ============================

	@RequestMapping(value = "/toAddClient", method = RequestMethod.GET)
	public String toAddClient() {
		LOGGER.info("<-----------toAddClient-------------->");
		return "addClient";
	}

	@RequestMapping(value = "/toGestionClient", method = RequestMethod.GET)
	public String toGestionClient(Model model) {
		try {
			GestionClientModel gestionClientModel = new GestionClientModel();
			gestionClientModel.setClients(serviceClient.getAll());
			model.addAttribute("gestionClientModel", gestionClientModel);
			LOGGER.info("<-----------toGestionClient-------------->");
			return "gestionClient";
		} catch (NullListException e) {
			e.printStackTrace();
			LOGGER.warn("<------------------ No Client in DataBase ------------------>");
			model.addAttribute("message", "Veuillez creer un client avant de passer en mode gestion.");
			return "home";
		}
	}

	// ============================
	// Employe
	// ============================

	@RequestMapping(value = "/toAddEmploye", method = RequestMethod.GET)
    public String toAddEmploye(Model model) {
        try {
            AddEmployeModel employeModel =new AddEmployeModel();
			employeModel.setBanques(serviceBanque.getAll());
	        model.addAttribute("employeModel", employeModel);
	        System.out.println("------------------------ " + employeModel.getBanques());
	        LOGGER.info("<-----------toAddEmploye-------------->");
	        return "addEmploye";
		} catch (NullListException e) {
			e.printStackTrace();
			LOGGER.warn("<------------------ No Banque in DataBase ------------------>");
			model.addAttribute("message", "Veuillez creer une banque avant de creer un employé.");
			return "home";
		}
    }

	@RequestMapping(value = "/toGestionEmploye", method = RequestMethod.GET)
	public String toGestionEmploye(Model model) {
		try {
			GestionEmployeModel gestionEmployeModel = new GestionEmployeModel();
			gestionEmployeModel.setEmployes(serviceEmploye.getAll());
			model.addAttribute("gestionEmployeModel", gestionEmployeModel);
			LOGGER.info("<-----------toGestionEmploye-------------->");
			return "gestionEmploye";
		} catch (NullListException e) {
			e.printStackTrace();
			LOGGER.warn("<------------------ No Employe in DataBase ------------------>");
			model.addAttribute("message", "Veuillez creer un employé avant de passer en mode gestion.");
			return "home";
		}
	}

	// ============================
	// Groupe
	// ============================

	@RequestMapping(value = "/toAddGroupe", method = RequestMethod.GET)
	public String toAddGroupe() {
		LOGGER.info("<-----------toAddGroupe-------------->");
		return "addGroupe";
	}

	@RequestMapping(value = "/toGestionGroupe", method = RequestMethod.GET)
	public String toGestionGroupe(Model model) {
		try {
			GestionGroupeModel gestionGroupeModel = new GestionGroupeModel();
			gestionGroupeModel.setGroupes(serviceGroupe.getAll());
			gestionGroupeModel.setEmployes(serviceEmploye.getAll());
			model.addAttribute("gestionGroupeModel", gestionGroupeModel);
			LOGGER.info("<-----------toGestionGroupe-------------->");
			return "gestionGroupe";
		} catch (NullListException e) {
			e.printStackTrace();
			LOGGER.warn("<------------------ No Employe or No Groupe in DataBase ------------------>");
			model.addAttribute("message", "Veuillez vérifier que la DataBase possède des Employés et des Groupes avant de passer en mode gestion.");
			return "home";
		}
	}
	
	

}
