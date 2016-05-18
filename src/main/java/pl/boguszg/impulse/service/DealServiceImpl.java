package pl.boguszg.impulse.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import pl.boguszg.impulse.dao.DealDAO;
import pl.boguszg.impulse.model.Deal;

public class DealServiceImpl implements DealService {

	private DealDAO dealDAO;
	
	public void setDealDAO(DealDAO dealDAO) {
		this.dealDAO = dealDAO;
	}
	
	@Override
	@Transactional
	public void addDeal(Deal d) {
		this.dealDAO.addDeal(d);
	}

	@Override
	public List<Deal> listDeals() {
		return this.dealDAO.listDeals();
	}
	
	@Override
	public List<Deal> listUserDeals(int userId) {
		return this.dealDAO.listUserDeals(userId);
	}

	@Override
	public Deal getDealById(int id) {
		return this.dealDAO.getDealById(id);
	}

}
