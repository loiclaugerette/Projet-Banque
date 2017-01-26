package com.adaming.myapp.controller;

import java.util.logging.Logger;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.adaming.myapp.exception.NullListException;
import com.adaming.myapp.model.GestionBanqueModel;
import com.adaming.myapp.servicebanque.IServiceBanque;

@Controller
@SessionAttributes(value="gestionBanqueModel")
public class GestionBanqueController {

	// =========================
	// Attributes
	// =========================

	@Inject
	private IServiceBanque serviceBanque;
	private final Logger LOGGER = Logger.getLogger("GestionBanqueController");

	// =========================
	// Methods
	// =========================

	@RequestMapping(value = "/printBanque", method = RequestMethod.GET)
	public String printBanque(Model model, GestionBanqueModel gestionBanqueModel)
			throws NullListException {
		String action = gestionBanqueModel.getAction();

		if (action.equals("employes")) {
			try {
				gestionBanqueModel.setEmployes(serviceBanque
						.getEmployeByBanque(gestionBanqueModel
								.getSelectedBanque()));
				model.addAttribute("gestionBanqueModel", gestionBanqueModel);
				LOGGER.info("<-------------------- Print Employe list by Banque -------------------->");
				return "printBanqueEmployes";
			} catch (Exception e) {
				e.printStackTrace();
				LOGGER.warning("<-------------No Employes in this Bank------------------>");
				gestionBanqueModel.setBanques(serviceBanque.getAll());
				model.addAttribute("gestionBanqueModel", gestionBanqueModel);
				model.addAttribute("message", "Il n'existe pas d'Employes dans cette banque");
				return "gestionBanque";
			}

		} else if (action.equals("clients")) {
			try {
				gestionBanqueModel.setClients(serviceBanque
						.getClientByBanque(gestionBanqueModel
								.getSelectedBanque()));
				model.addAttribute("gestionBanqueModel", gestionBanqueModel);
				LOGGER.info("<-------------------- Print Client list by Banque -------------------->");
				return "printBanqueClients";
			} catch (Exception e) {
				e.printStackTrace();
				LOGGER.warning("<-------------No Clients in this Bank------------------>");
				gestionBanqueModel.setBanques(serviceBanque.getAll());
				model.addAttribute("gestionBanqueModel", gestionBanqueModel);
				model.addAttribute("message", "Il n'existe pas de Clients dans cette banque");
				return "gestionBanque";
			}

		} else if (action.equals("comptes")) {
			try {
				gestionBanqueModel.setComptes(serviceBanque
						.getCompteByBanque(gestionBanqueModel
								.getSelectedBanque()));
				model.addAttribute("gestionBanqueModel", gestionBanqueModel);
				LOGGER.info("<-------------------- Print Compte list by Banque -------------------->");
				return "printBanqueComptes";
			} catch (Exception e) {
				e.printStackTrace();
				LOGGER.warning("<-------------No Comptes in this Bank------------------>");
				gestionBanqueModel.setBanques(serviceBanque.getAll());
				model.addAttribute("gestionBanqueModel", gestionBanqueModel);
				model.addAttribute("message", "Il n'existe pas de Comptes dans cette banque");
				return "gestionBanque";
			}

		}
		return "redirect:/";
	}

}
