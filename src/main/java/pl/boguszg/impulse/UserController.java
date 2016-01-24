package pl.boguszg.impulse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pl.boguszg.impulse.model.User;
import pl.boguszg.impulse.service.UserService;

@Controller
public class UserController {

	private UserService userService;

	@Autowired(required = true)
	@Qualifier(value = "userService")
	public void setUserService(UserService us) {
		this.userService = us;
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String listUsers(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("listUsers", this.userService.listUsers());
		return "user";
	}

	@RequestMapping(value = "/landing", method = RequestMethod.GET)
	public String landingPage(Model model) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		User u = new User();
		if (name != "anonymousUser") {
			u = this.userService.getUserByName(name);
		}
		model.addAttribute("user", u);

		return "landing";

	}

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String showProfile(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		User u = new User();
		if (name != "anonymousUser") {
			u = this.userService.getUserByName(name);
		}
		model.addAttribute("user", u);
		model.addAttribute("time", "too late");
		return "profile";
	}

	// For add and update user both
	@RequestMapping(value = "/user/add", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user") User p) {

		if (p.getId() == 0) {
			// new user, add it
			this.userService.addUser(p);
		} else {
			// existing user, call update
			this.userService.updateUser(p);
		}

		return "redirect:/users";

	}

	// For add and update user both
	@RequestMapping(value = "/register/new", method = RequestMethod.POST)
	public String registerUser(@ModelAttribute("user") User p) {

		if (p.getId() == 0) {
			// new user, add it
			this.userService.addUser(p);
		}

		return "redirect:/login";

	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView register(@ModelAttribute("user") User p) {

		ModelAndView model = new ModelAndView();

		model.setViewName("register");

		return model;
	}

	@RequestMapping("/remove/{name}")
	public String removeUser(@PathVariable("name") String name) {

		this.userService.removeUser(name);
		return "redirect:/users";
	}

	@RequestMapping("/edit/{name}")
	public String editUser(@PathVariable("name") String name, Model model) {
		model.addAttribute("user", this.userService.getUserByName(name));
		model.addAttribute("listUsers", this.userService.listUsers());
		return "user";
	}

}
