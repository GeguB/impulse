package pl.boguszg.impulse.dao;

import java.util.List;

import pl.boguszg.impulse.model.Plan;

public interface PlanDAO {

	public void addPlan(Plan p);
	public void updatePlan(Plan p);
	public List<Plan> listPlans();
	public Plan getPlanByName(String name);
	public void removePlan(String name);
	
}
