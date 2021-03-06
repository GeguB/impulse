package pl.boguszg.impulse.dao;

import java.util.List;

import pl.boguszg.impulse.model.Deal;

public interface DealDAO {
	
	public void addDeal(Deal d);
	public List<Deal> listDeals();
	public List<Deal> listUserDeals(int userId);
	public Deal getDealById(int id);
	
}
