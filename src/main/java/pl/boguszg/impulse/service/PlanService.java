package pl.boguszg.impulse.service;

import java.util.List;

import pl.boguszg.impulse.model.Plan;

public interface PlanService {

	public void addPlan(Plan p);
	public void updatePlan(Plan p);
	public List<Plan> listPlans();
	public Plan getPlanByName(String name);	
	public Plan getPlanById(int id);
	public void removePlan(String name);
}
