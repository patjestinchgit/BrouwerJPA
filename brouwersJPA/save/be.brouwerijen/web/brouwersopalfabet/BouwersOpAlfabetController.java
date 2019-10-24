package be.brouwerijen.web.brouwersopalfabet;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import be.brouwerijen.entities.Brouwer;
import be.brouwerijen.services.BrouwerService;

// enkele imports ...
@Controller
//@RequestMapping("/brouwers/brouwersopalfabet")
@RequestMapping("/brouwersopalfabet")
class BrouwersOpAlfabetController {
	// private static final String ALFABET_VIEW_STP1 =
	// "brouwers/brouwersopalfabet/brouwersopalfabetstp1";
	private static final String ALFABET_VIEW_STP1 = "brouwersopalfabet/brouwersopalfabetstp1";
	// private static final String ALFABET_VIEW_STP2 =
	// "brouwers/brouwersopalfabet/brouwersopalfabetstp2";
	private static final String ALFABET_VIEW_STP2 = "brouwersopalfabet/brouwersopalfabetstp2";
	private static final Logger logger = Logger.getLogger(BrouwersOpAlfabetController.class.getName());

	private final BrouwerService brouwerservice;

	@Autowired
	BrouwersOpAlfabetController(BrouwerService brouwerservice) {
		this.brouwerservice = brouwerservice;
	}

	@RequestMapping(path = "", method = RequestMethod.GET) //, params="keuze")
	String brouwersOpAlfabetstp1() {
		System.out.println("line 40 in brouwersopalfabetstp1"); //
		return ALFABET_VIEW_STP1;
	}
	
	
	@RequestMapping( method = RequestMethod.POST, params = "volgende")
	String brouwersopalfabetstp1Tostp2() { //@PathVariable char letter) {
		char letter= 'b';
		System.out.println("line 46 in brouwersopalfabetstp1"); 
		ModelAndView modelAndView = new ModelAndView(ALFABET_VIEW_STP2);
		List<Brouwer> brouwers = new ArrayList<Brouwer>();
		brouwers = brouwerservice.findByAlphabet(letter);

		if (brouwers.isEmpty() == false) modelAndView.addObject(brouwers);
		else System.out.println("is emtpy"); // modelAndView.addObject(brouwers.get(0));

		//return new ModelAndView(ALFABET_VIEW_STP2, "brouwers", brouwers);
		return ALFABET_VIEW_STP2;
	}
	
	@RequestMapping( method = RequestMethod.POST, params = "vorige")
	String brouwersopalfabetstp2Tostp1() { //@PathVariable char letter) {
				return ALFABET_VIEW_STP1;
	}

	/*
	 * @RequestMapping(path = "brouwersopalfabet/{letter}", params = "letter" ,
	 * method = RequestMethod.GET) ModelAndView
	 * brouwersopalfabetstp1Tostp2(@PathVariable char letter) {
	 * 
	 * 
	 * System.out.println("line 46 in brouwersopalfabetstp1"); ModelAndView
	 * modelAndView = new ModelAndView(ALFABET_VIEW_STP2); List<Brouwer> brouwers =
	 * new ArrayList<Brouwer>(); brouwers = brouwerservice.findByAlphabet(letter);
	 * 
	 * if (brouwers.isEmpty() == false) modelAndView.addObject(brouwers); else
	 * System.out.println("is emtpy"); // modelAndView.addObject(brouwers.get(0));
	 * 
	 * return new ModelAndView(ALFABET_VIEW_STP2, "brouwers", brouwers); }
	 */
	
	/*
	 * @RequestMapping(path = "{letter}", method = RequestMethod.GET, params =
	 * "letter") ModelAndView brouwersopalfabetstp2Tostp2(@PathVariable char letter)
	 * { System.out.println("in brouwersopalfabetstp1"); ModelAndView modelAndView =
	 * new ModelAndView(ALFABET_VIEW_STP2); List<Brouwer> brouwers = new
	 * ArrayList<Brouwer>(); brouwers = brouwerservice.findByAlphabet(letter);
	 * 
	 * if (brouwers.isEmpty() == false) modelAndView.addObject(brouwers); else
	 * System.out.println("is emtpy"); // modelAndView.addObject(brouwers.get(0));
	 * 
	 * return new ModelAndView(ALFABET_VIEW_STP2, "brouwers", brouwers); }
	 */
	
	

	/*
	 * // @RequestMapping(path = "brouwersopalfabetstp2", method =
	 * RequestMethod.GET, // params = "letter")
	 * 
	 * @RequestMapping(path = "brouwersopalfabetstp2/{letter}", method =
	 * RequestMethod.GET, params = "letter") // ModelAndView
	 * newBrouwersOpAlfabetstp2(char letter) { ModelAndView
	 * newBrouwersOpAlfabetstp2(@PathVariable char letter) {
	 * System.out.println("in brouwersopalfabetstp1"); // ModelAndView modelAndView=
	 * new ModelAndView(ALFABET_VIEW_STP2); List<Brouwer> brouwers = new
	 * ArrayList<Brouwer>(); brouwers = brouwerservice.findByAlphabet(letter);
	 * 
	 * if(brouwers.isEmpty()==false) modelAndView.addObject(brouwers); else
	 * System.out.println("is emtpy");
	 * 
	 * 
	 * return new ModelAndView(ALFABET_VIEW_STP2, "brouwers", brouwers); }
	 * 
	 * // @RequestMapping(path = "brouwersopalfabetstp1", method = //
	 * RequestMethod.GET,params = "letter")
	 * 
	 * 
	 * @RequestMapping(path = "{letter}", method = RequestMethod.GET, params =
	 * "letter") ModelAndView brouwersopalfabetstp1(@PathVariable char letter) {
	 * System.out.println("in brouwersopalfabetstp1"); // ModelAndView
	 * modelAndView=new ModelAndView(ALFABET_VIEW_STP2); List<Brouwer> brouwers =
	 * new ArrayList<Brouwer>(); brouwers = brouwerservice.findByAlphabet(letter);
	 * 
	 * if (brouwers.isEmpty() == false) modelAndView.addObject(brouwers); else
	 * System.out.println("is emtpy"); // modelAndView.addObject(brouwers.get(0));
	 * 
	 * return new ModelAndView(ALFABET_VIEW_STP2, "brouwers", brouwers); }
	 * 
	 * 
	 * @RequestMapping(path = "brouwersopalfabetstp2", method = RequestMethod.POST,
	 * params = "vorige") String brouwersOpAlfabetstp2Tostp1() { return
	 * ALFABET_VIEW_STP1; }
	 * 
	 * @RequestMapping(path = "brouwersopalfabetstp1", method = RequestMethod.POST,
	 * params = "vorige") String brouwersOpAlfabetstp1Tostp1() { return
	 * ALFABET_VIEW_STP1; }
	 */
}