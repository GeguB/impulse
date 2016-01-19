package pl.boguszg.impulse;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



/**
 * Handles requests for the application home page.
 */


@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
	public ModelAndView welcomePage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Custom Login Form");
		model.addObject("message", "This is welcome page!");
		
		DateFormat time = new SimpleDateFormat("HH:mm:ss");
		DateFormat date = new SimpleDateFormat("dd/MM/yyyy");
		Date now = new Date();
		
		model.addObject("serverTime", time.format(now));
		model.addObject("serverDate", date.format(now));
		model.setViewName("hello");
		
		logger.info("Home page!");
		
		return model;

	}
	
	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public ModelAndView about() {
				
		ModelAndView model = new ModelAndView();
		
		String name = "Grzegorz Bogusz";
		model.addObject("author", name);
		model.setViewName("about");
		
		logger.info("Good job on access!");
		
		return model;
	}
	

	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public ModelAndView adminPage() {

		
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Custom Login Form");
		model.addObject("message", "This is protected page!");
		model.setViewName("admin");

		logger.info("Accessed admin!");
		
		return model;

	}

	// Spring Security see this :
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("login");

		return model;

	}
	
	
	//for 403 access denied page
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied() {

	  ModelAndView model = new ModelAndView();
		
	  //check if user is login
	  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	  if (!(auth instanceof AnonymousAuthenticationToken)) {
		UserDetails userDetail = (UserDetails) auth.getPrincipal();	
		model.addObject("username", userDetail.getUsername());
		
	  }
		
	  model.setViewName("403");
	  return model;

	}

	
}
