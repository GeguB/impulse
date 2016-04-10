package pl.boguszg.impulse.service;

import java.util.List;

import pl.boguszg.impulse.dao.PlanDAO;
import pl.boguszg.impulse.model.Plan;

public class PlanServiceImpl implements PlanService {

	private PlanDAO planDAO;

	public void setPlanDAO(PlanDAO planDAO) {
		this.planDAO = planDAO;
	}

	@Override
	public void addPlan(Plan p) {
		this.planDAO.addPlan(p);
	}

	@Override
	public void updatePlan(Plan p) {
		this.planDAO.updatePlan(p);
	}

	@Override
	public List<Plan> listPlans() {
		return this.planDAO.listPlans();
	}

	@Override
	public Plan getPlanByName(String name) {
		return this.planDAO.getPlanByName(name);
	}

	@Override
	public void removePlan(String name) {
		this.planDAO.removePlan(name);
	}

}
