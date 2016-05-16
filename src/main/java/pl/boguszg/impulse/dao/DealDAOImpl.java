package pl.boguszg.impulse.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pl.boguszg.impulse.model.Deal;

public class DealDAOImpl implements DealDAO {

	private static final Logger logger = LoggerFactory.getLogger(PlanDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@Override
	//I hope this will work
	public void addDeal(int userId, int planId) {
		Session session = this.sessionFactory.getCurrentSession();
		Deal d = new Deal();
		d.setUser_Id(userId);
		d.setPlan_ID(planId);
		session.persist(d);
		logger.info("Deal saved successfully, Deal Details="+d);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Deal> listDeals() {
		Session session = this.sessionFactory.openSession();
		List<Deal> dealsList = session.createQuery("from Deal").list();
		for(Deal d : dealsList){
			logger.info("Deal List::"+d);
		}
		session.close();
		return dealsList;
	}

	@Override
	public List<Deal> listUserDeals(int userId) {
		Session session = this.sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Deal> dealsList = session.createQuery("from Deal d where d.user_ID = :user").setParameter("user", userId).list();

		for (Deal d : dealsList) {
			logger.info("List::" + d);
		}
		session.close();
		return dealsList;
	}

	@Override
	public Deal getDealById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
