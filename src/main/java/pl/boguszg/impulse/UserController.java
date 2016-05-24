package pl.boguszg.impulse;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pl.boguszg.impulse.model.Call;
import pl.boguszg.impulse.model.DataTransfer;
import pl.boguszg.impulse.model.Deal;
import pl.boguszg.impulse.model.PhoneNumber;
import pl.boguszg.impulse.model.Plan;
import pl.boguszg.impulse.model.Summary;
import pl.boguszg.impulse.model.Text;
import pl.boguszg.impulse.model.User;
import pl.boguszg.impulse.service.CallService;
import pl.boguszg.impulse.service.DataTransferService;
import pl.boguszg.impulse.service.PhoneNumberService;
import pl.boguszg.impulse.service.PlanService;
import pl.boguszg.impulse.service.TextService;
import pl.boguszg.impulse.service.UserService;
import pl.boguszg.impulse.service.DealService;

@Controller
public class UserController {

	private UserService userService;
	private PlanService planService;
	private PhoneNumberService phoneNumberService;
	private CallService callService;
	private TextService textService;
	private DataTransferService dataTransferService;
	private DealService dealService;

	@Autowired(required = true)
	@Qualifier(value = "userService")
	public void setUserService(UserService us) {
		this.userService = us;
	}

	@Autowired
	@Qualifier(value = "planService")
	public void setPlanService(PlanService ps) {
		this.planService = ps;
	}

	@Autowired
	@Qualifier(value = "phoneNumberService")
	public void setPhoneNumberService(PhoneNumberService pn) {
		this.phoneNumberService = pn;
	}

	@Autowired
	@Qualifier(value = "callService")
	public void setCallService(CallService c) {
		this.callService = c;
	}

	@Autowired
	@Qualifier(value = "textService")
	public void setTextService(TextService t) {
		this.textService = t;
	}

	@Autowired
	@Qualifier(value = "dataTransferService")
	public void setDataTransferService(DataTransferService dt) {
		this.dataTransferService = dt;
	}

	@Autowired
	@Qualifier(value = "dealService")
	public void setDealService(DealService d) {
		this.dealService = d;
	}

	@RequestMapping(value = { "/", "/index", "/welcome**" }, method = RequestMethod.GET)
	public String welcomePage(Model model) {

		model.addAttribute("title", "Welcome to the main page!");

		DateFormat time = new SimpleDateFormat("HH:mm:ss");
		DateFormat date = new SimpleDateFormat("dd/MM/yyyy");
		Date now = new Date();

		model.addAttribute("serverTime", time.format(now));
		model.addAttribute("serverDate", date.format(now));

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		User u = new User();
		if (name != "anonymousUser") {
			u = this.userService.getUserByName(name);
		}
		model.addAttribute("user", u);

		return "index";

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

	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public String aboutPage(Model model) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		User u = new User();
		if (name != "anonymousUser") {
			u = this.userService.getUserByName(name);
		}
		model.addAttribute("user", u);

		return "about";

	}

	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String contactPage(Model model) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		User u = new User();
		if (name != "anonymousUser") {
			u = this.userService.getUserByName(name);
		}
		model.addAttribute("user", u);

		return "contact";

	}

	@RequestMapping(value = "/billing", method = RequestMethod.GET)
	public String billingPage(Model model) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		User u = new User();
		int dialer;
		if (name != "anonymousUser") {
			u = this.userService.getUserByName(name);
			dialer = this.phoneNumberService.getPhoneNumberByName(name).getNumber();
			
			List<Call> calls = this.callService.getCallByDialer(dialer);
			Summary callSum = this.callService.getSummary(dialer, "all", calls);
			model.addAttribute("callList", calls);
			
			List<Text> texts = this.textService.getTextByDialer(dialer);
			Summary textSum = this.textService.getSummary(dialer, "all", texts);
			model.addAttribute("textList", texts);
			
			List<DataTransfer> dataTransfer = this.dataTransferService.getDataTransferByDialer(dialer);
			Summary dtSum = this.dataTransferService.getSummary(dialer, "all", dataTransfer);
			model.addAttribute("dataTransferList", dataTransfer);
			
			model.addAttribute("callSum", callSum);
			model.addAttribute("textSum", textSum);
			model.addAttribute("dtSum", dtSum);
			
		}
		model.addAttribute("user", u);

		return "billing";

	}

	@RequestMapping(value = "/purchased", method = RequestMethod.GET)
	public String purchasedPage(Model model) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		User u = new User();
		if (name != "anonymousUser") {
			u = this.userService.getUserByName(name);
			int userId = u.getId();
			List<Deal> deals = this.dealService.listUserDeals(userId);
			model.addAttribute("dealsList", deals);
		}
		model.addAttribute("user", u);

		return "purchased";

	}

	@RequestMapping(value = "/plans", method = RequestMethod.GET)
	public String plansPage(Model model) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		User u = new User();
		if (name != "anonymousUser") {
			u = this.userService.getUserByName(name);
		}
		model.addAttribute("user", u);
		model.addAttribute("listPlans", this.planService.listPlans());
		return "plans";

	}

	@RequestMapping(value = "/transaction", method = RequestMethod.POST)
	public String plansBuy(@RequestParam int planid, Model model, @ModelAttribute("user") User u,
			@ModelAttribute("deal") Deal d) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		Plan p = new Plan();
		if (name != "anonymousUser") {
			u = this.userService.getUserByName(name);
			p = this.planService.getPlanById(planid);
			if (p.getPrice() <= u.getAccount()) {
				u.setAccount(u.getAccount() - p.getPrice());
				switch (p.getType()) {
				case "text":
					u.setTexts_left(u.getTexts_left() + p.getValue());
					break;
				case "call":
					u.setMinutes_left(u.getMinutes_left() + p.getValue());
					break;
				case "transfer":
					u.setKb_left(u.getKb_left() + p.getValue());
					break;
				}
				userService.updateUser(u);
				model.addAttribute("plan", p);
				d.setPlan_ID(p.getId());
				d.setUser_ID(u.getId());
				this.dealService.addDeal(d);
				System.out.println(d);
				model.addAttribute("deal", d);
			} else {
				System.out.println("Not enough money");
			}
		}
		model.addAttribute("user", u);

		return "transaction";

	}

	@RequestMapping(value = "/recharge", method = RequestMethod.GET)
	public String rechargeAccount(Model model) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		User u = new User();
		if (name != "anonymousUser") {
			u = this.userService.getUserByName(name);
		}
		model.addAttribute("user", u);

		return "recharge";

	}

	@RequestMapping(value = "/rechargeWith", method = RequestMethod.POST)
	public String rechargeWith(@RequestParam("price") float price, Model model) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		User u = new User();
		model.addAttribute("user", u);
		u = this.userService.getUserByName(name);
		if (name != "anonymousUser") {
			double account = u.getAccount();
			u.setAccount(account + price);
			userService.updateUser(u);
		}

		return "redirect:/recharge";

	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String listUsers(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		User u = new User();
		if (name != "anonymousUser") {
			u = this.userService.getUserByName(name);
		}
		model.addAttribute("user", u);
		model.addAttribute("listUsers", this.userService.listUsers());
		return "user";
	}

	@RequestMapping("/edit/{name}")
	public String editUser(@PathVariable("name") String name, Model model) {
		User editedUser = this.userService.getUserByName(name);
		model.addAttribute("user", editedUser);
		model.addAttribute("listUsers", this.userService.listUsers());
		return "user";
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
		DateFormat time = new SimpleDateFormat("HH:mm:ss");
		Date now = new Date();
		PhoneNumber pn = new PhoneNumber();
		try {
			pn = this.phoneNumberService.getPhoneNumberByName(name);
			model.addAttribute("phone_number", pn);
		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("serverTime", time.format(now));
		return "profile";
	}

	// For add and update user both
	@RequestMapping(value = "/user/add", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user") User u, BindingResult result,
			final RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			System.out.println("User already exists");
			return "index";
		} else {
			if (u.getId() == 0) {
				// new user, add it
				this.userService.addUser(u);
			} else {
				// existing user, call update
				this.userService.updateUser(u);
			}

			return "redirect:/users";
		}

	}

	// For add and update user both
	@RequestMapping(value = "/register/new", method = RequestMethod.POST)
	public String registerUser(@ModelAttribute("user") User u, BindingResult result,
			final RedirectAttributes redirectAttributes) {

		if (u.getId() == 0) {
			// new user, add it
			int phone_number = this.phoneNumberService.UnusedPhoneNumber(u).getNumber(); 
			u.setPhone_number(phone_number);
			this.userService.addUser(u);
		}

		return "redirect:/login";

	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView register(@ModelAttribute("user") User u) {

		ModelAndView model = new ModelAndView();

		model.setViewName("register");

		return model;
	}

	@RequestMapping("/remove/{name}")
	public String removeUser(@PathVariable("name") String name) {

		this.userService.removeUser(name);
		return "redirect:/users";
	}

}
