package be.brouwerijen.web;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import be.brouwerijen.entities.Brouwer;
import be.brouwerijen.services.BrouwerService;
import be.brouwerijen.entities.Brouwer;

// enkele imports ...
@Controller
@RequestMapping("/brouwers")
class BrouwersController {
	private static final String BROUWERS_VIEW = "brouwers/brouwers";
	private static final String TOEVOEGEN_VIEW = "brouwers/toevoegen";
	private static final String WIJZIGEN_VIEW = "brouwers/wijzigen";
	private static final String BEGINNAAM_VIEW = "brouwers/beginnaam";
	private static final String TEST = "redirect:/";
	private static final String REDIRECT_URL_NA_TOEVOEGEN = "redirect:/";
	private static final String REDIRECT_URL_NA_WIJZIGEN = "redirect:/brouwers";
	private static final String BROUWER_VIEW = "brouwers/brouwer";
	private static final String REDIRECT_URL_BROUWER_NIET_GEVONDEN = "redirect:/brouwers";
	private static final String REDIRECT_URL_NA_VERWIJDEREN = "redirect:/brouwers/{id}/verwijderd";
	private static final String VERWIJDERD_VIEW = "brouwers/verwijderd";

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
	ModelAndView createForm() {
		logger.info("brouwer record toevoegen aan database");
		return new ModelAndView(TOEVOEGEN_VIEW, "brouwer", new Brouwer());
	}

	@RequestMapping(method = RequestMethod.POST)
	String createForm2(@Valid Brouwer brouwer, BindingResult bindingResult) {
		logger.info("brouwer record aan het toevoegen");
		if (bindingResult.hasErrors()) {
			return TOEVOEGEN_VIEW;
		}
		brouwerservice.create(brouwer);
		logger.info("brouwer record toegevoegd");
		return REDIRECT_URL_NA_TOEVOEGEN;
	}

	@RequestMapping(path = "{id}/wijzigen", method = RequestMethod.GET)
	ModelAndView updateForm(@PathVariable long id) {
		Brouwer brouwer = brouwerservice.read(id);
		if (brouwer == null) {
			return new ModelAndView(REDIRECT_URL_BROUWER_NIET_GEVONDEN);
		}
		return new ModelAndView(WIJZIGEN_VIEW).addObject(brouwer);
	}

	@RequestMapping(path = "{id}/wijzigen", method = RequestMethod.POST)
	String update(@Valid Brouwer brouwer, BindingResult bindingResult, @PathVariable long id) {
		brouwer.setId(id);
		System.out.println("lijn 83 "+brouwer.getNaam()+" "+brouwer.getId());
		if (bindingResult.hasErrors()) {
			return WIJZIGEN_VIEW;
		}
		brouwerservice.update(brouwer);
		return REDIRECT_URL_NA_WIJZIGEN;
	}

	@RequestMapping(path = "beginnaam", method = RequestMethod.GET)
	String findByNaam() {
		return BEGINNAAM_VIEW;
	}

	@RequestMapping(method = RequestMethod.GET)
	ModelAndView findAll() {
		return new ModelAndView(BROUWERS_VIEW, "brouwers", brouwerservice.findAll());
	}

	@RequestMapping(path = "{id}", method = RequestMethod.GET)
	ModelAndView read(@PathVariable long id) {
		ModelAndView modelAndView = new ModelAndView(BROUWER_VIEW);
		Brouwer brouwer = brouwerservice.read(id);
		if (brouwer != null) {
			modelAndView.addObject(brouwer);
		}
		return modelAndView;
	}

	/*
	 * @RequestMapping(path = "verwijderen", method = RequestMethod.GET) String
	 * deleteForm() { logger.info("verwijderen"); return VERWIJDEREN_VIEW; }
	 * 
	 * @RequestMapping(path = "verwijderen", method = RequestMethod.POST, params =
	 * "verwijderen") String deteleFormStep2() {
	 * logger.info("brouwer verwijderen aan database"); return
	 * REDIRECT_URL_NA_TOEVOEGEN; }
	 */

	@RequestMapping(path = "{id}/verwijderen", method = RequestMethod.POST)
	String delete(@PathVariable long id, RedirectAttributes redirectAttributes) {
		Brouwer brouwer = brouwerservice.read(id);
		System.out.println("lijn 93 verwijderen");
		if (brouwer == null) {

			return REDIRECT_URL_BROUWER_NIET_GEVONDEN;
		}

		brouwerservice.delete(id);
		redirectAttributes.addAttribute("id", id)

				.addAttribute("naam", brouwer.getNaam());

		return REDIRECT_URL_NA_VERWIJDEREN;
	}

	@RequestMapping(path = "{id}/verwijderd", method = RequestMethod.GET)
	ModelAndView deleted(String naam) {
		return new ModelAndView(VERWIJDERD_VIEW, "naam", naam);
	}

	@InitBinder("brouwer")
	void initBinderFiliaal(WebDataBinder binder) {
		binder.initDirectFieldAccess();
	}

}