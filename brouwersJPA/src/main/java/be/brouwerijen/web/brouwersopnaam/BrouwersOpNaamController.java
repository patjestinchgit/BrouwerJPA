package be.brouwerijen.web.brouwersopnaam;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import be.brouwerijen.entities.Brouwer;
import be.brouwerijen.services.BrouwerService;
import be.brouwerijen.valueobjects.BrouwersOpNaam;

@Controller
@RequestMapping("/brouwersopnaam")
class BrouwersOpNaamController {

	private static final String BROUWERS_OP_NAAM_VIEW = "brouwersopnaam/beginnaam";

	private final BrouwerService brouwersservice;

	@Autowired
	BrouwersOpNaamController(BrouwerService brouwersservice) {
		this.brouwersservice = brouwersservice;
	}

	@RequestMapping(path = "", method = RequestMethod.GET) // , params="keuze")
	ModelAndView brouwersOpNaam() {
		BrouwersOpNaam brouwersopnaam = new BrouwersOpNaam();
		brouwersopnaam.setBeginnaam("");
		return new ModelAndView(BROUWERS_OP_NAAM_VIEW).addObject(brouwersopnaam);
	}

	@RequestMapping(method = RequestMethod.GET, params = "beginnaam")
	ModelAndView brouwersOpNaam(@Valid BrouwersOpNaam beginnaam, BindingResult bindingResult) {
		System.out.println("line 40 in Brouwersopnaam"); //
		ModelAndView modelAndView = new ModelAndView(BROUWERS_OP_NAAM_VIEW);
		if (!bindingResult.hasErrors()) {
			List<Brouwer> brouwers = brouwersservice.findByNaam(beginnaam);
			if (brouwers.isEmpty()) {
				bindingResult.reject("geenBrouwers");
			} else {
				modelAndView.addObject("brouwers", brouwers);
			}
		}
		return modelAndView;
	}

	/*
	 * @InitBinder("brouwersOpNaam") void initBinderPostcodeReeks(DataBinder
	 * dataBinder) { dataBinder.setRequiredFields("beginnaam"); }
	 */
}
