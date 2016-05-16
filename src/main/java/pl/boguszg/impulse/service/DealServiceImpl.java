package pl.boguszg.impulse.service;

import java.util.List;

import pl.boguszg.impulse.dao.DealDAO;
import pl.boguszg.impulse.model.Deal;

public class DealServiceImpl implements DealService {

	private DealDAO dealDAO;
	
	public void setDealDAO(DealDAO dealDAO) {
		this.dealDAO = dealDAO;
	}
	
	@Override
	public void addDeal(int userId, int planId) {
		this.dealDAO.addDeal(userId, planId);
	}

	@Override
	public List<Deal> listDeals() {
		return null;
	}
	
	@Override
	public List<Deal> listUserDeals(int userId) {
		return null;
	}

	@Override
	public Deal getDealById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
