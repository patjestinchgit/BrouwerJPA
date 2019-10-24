package be.brouwerijen.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.SimpleTimeZoneAwareLocaleContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.LocaleContextResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import be.brouwerijen.services.BrouwerService;
import be.brouwerijen.services.IndexService;

// enkele imports ...
@Controller
@RequestMapping("/")
class IndexController {
	private static final String VIEW = "index";
	private static final String VIEW_INDEX_BROUWERS = "indexbrouwers";
	private static final String VIEW_NOWFMT = "indexlanguagetime";
	private static final String VIEW_LANGUAGETIME = "indexlanguagetime";

	private final IndexService indexservice;
	private final TimePicture timepicture;
	// private final LocaleResolver localeresolver;

	@Autowired
	IndexController(IndexService indexservice, TimePicture timepicture) { // , LocaleResolver localeresolver) {
		this.indexservice = indexservice;
		this.timepicture = timepicture;
		// this.localeresolver= localeresolver;
	}

	@RequestMapping(method = RequestMethod.GET) // , params = "nowfmt")
	ModelAndView index(Date dateclient) {

		return new ModelAndView(VIEW, "foto", timepicture.getFoto());
	}

	/*
	 * @RequestMapping(method = RequestMethod.GET) ModelAndView index() {
	 * ModelAndView modelView = new ModelAndView(); modelView.setViewName(VIEW); //
	 * modelView.addObject(VIEW_NOWFMT, indexservice.getGreetings("")); return
	 * modelView; }
	 */

	@RequestMapping(method = RequestMethod.GET, path = "/indexlanguagetime")
	ModelAndView indexlanguagetime() {
		ModelAndView modelView = new ModelAndView();
		modelView.setViewName(VIEW_LANGUAGETIME);
		// modelView.addObject(VIEW_NOWFMT, indexservice.getGreetings(""));
		modelView.addObject("foto", timepicture.getFoto());
		return modelView;
	}

	@RequestMapping(method = RequestMethod.GET, params = "nowfmt") // path="{letter}",
	ModelAndView index(@RequestParam("nowfmt") String nowfmt, Locale locale, HttpServletRequest req) {
		System.out.println("line 50");
		// Locale currentLocale = req.getLocale();
		System.out.println(locale.getDisplayLanguage());
		System.out.println(locale.getDisplayCountry());

		System.out.println(locale.getLanguage());
		System.out.println(locale.getCountry());
		ModelAndView modelView = new ModelAndView();
		modelView.setViewName(VIEW_INDEX_BROUWERS);
		modelView.addObject(VIEW_NOWFMT, indexservice.getGreetings(nowfmt));
		modelView.addObject("foto", timepicture.getFoto());
		return modelView;
	}

	@RequestMapping(method = RequestMethod.GET, params = "foto")
	String kleurKeuze(String foto) {
		timepicture.setFoto(foto);
		return "redirect:/";
	}
	

	/*
	 * @RequestMapping(value = "/", method = RequestMethod.POST) public String
	 * handleTzValue(Locale locale, HttpServletRequest req, HttpServletResponse res,
	 * 
	 * @RequestParam("requestedUrl") String
	 * requestedUrl, @RequestParam("timeZoneOffset") int timeZoneOffset) {
	 * 
	 * ZoneOffset zoneOffset = ZoneOffset.ofTotalSeconds(-timeZoneOffset * 60);
	 * 
	 * TimeZone timeZone = TimeZone.getTimeZone(zoneOffset);
	 * 
	 * LocaleContextResolver localeResolver = (LocaleContextResolver)
	 * RequestContextUtils.getLocaleResolver(req);
	 * 
	 * localeResolver.setLocaleContext(req, res, new
	 * SimpleTimeZoneAwareLocaleContext(locale, timeZone));
	 * 
	 * return VIEW;
	 * 
	 * }
	 */

}