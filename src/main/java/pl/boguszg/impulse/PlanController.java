package pl.boguszg.impulse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.boguszg.impulse.service.PlanService;
import pl.boguszg.impulse.service.UserService;

@Controller
public class PlanController {

	private PlanService planService; 
	
	@Autowired(required = true)
	@Qualifier(value = "planService")
	public void setPlanService(PlanService ps){
		this.planService = ps;
	}

	
//	@RequestMapping(value = "/plans", method = RequestMethod.GET)
//	public String plansPage(Model model) {
//		model.addAttribute("listPlans", this.planService.listPlans());		
//
//		return "plans";
//
//	}
	
}
