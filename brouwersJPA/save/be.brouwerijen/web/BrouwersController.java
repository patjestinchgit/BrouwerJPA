package be.brouwerijen.web;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import be.brouwerijen.entities.Brouwer;
import be.brouwerijen.services.BrouwerService;

// enkele imports ...
@Controller
@RequestMapping("/brouwers")
class BrouwersController {
	private static final String BROUWERS_VIEW = "brouwers/brouwers";
	private static final String TOEVOEGEN_VIEW = "brouwers/toevoegen";
	private static final String BEGINNAAM_VIEW = "brouwers/beginnaam";
	private static final String TEST = "redirect:/";
	private static final String REDIRECT_URL_NA_TOEVOEGEN = "redirect:/";

	private static final Logger logger = Logger.getLogger(BrouwersController.class.getName());

	@RequestMapping(path = "terug", method = RequestMethod.POST)
	String test() {
		return TEST;
	}

	private final BrouwerService brouwerservice;

	@Autowired
	BrouwersController(BrouwerService brouwerservice) {
		this.brouwerservice = brouwerservice;
	}

	@RequestMapping(path = "toevoegen", method = RequestMethod.GET)
	String createForm() {
		logger.info("filiaal record toevoegen aan database");
		return TOEVOEGEN_VIEW;
	}
	
	@RequestMapping(path = "toevoegen", method = RequestMethod.POST, params= "toevoegen")
	String createForm2() {
		logger.info("filiaal record toevoegen aan database");
		return REDIRECT_URL_NA_TOEVOEGEN;
	}

	@RequestMapping(path = "beginnaam", method = RequestMethod.GET)
	String findByNaam() {
		return BEGINNAAM_VIEW;
	}

	@RequestMapping(method = RequestMethod.GET)
	ModelAndView findAll() {
		return new ModelAndView(BROUWERS_VIEW, "brouwers", brouwerservice.findAll());
	}

}