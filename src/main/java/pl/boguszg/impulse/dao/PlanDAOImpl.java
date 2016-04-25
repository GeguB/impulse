package pl.boguszg.impulse.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import pl.boguszg.impulse.model.Plan;

@Repository
public class PlanDAOImpl implements PlanDAO {

	private static final Logger logger = LoggerFactory.getLogger(PlanDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@Override
	public void addPlan(Plan p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Plan saved successfully, Plan Details="+p);
	}

	@Override
	public void updatePlan(Plan p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Plan saved successfully, Plan Details="+p);		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Plan> listPlans() {
		Session session = this.sessionFactory.openSession();
		List<Plan> plansList = session.createQuery("from Plan").list();
		for(Plan p : plansList){
			logger.info("Plan List::"+p);
		}
		session.close();
		return plansList;
	}

	@Override
	public Plan getPlanByName(String name) {
		Session session = this.sessionFactory.getCurrentSession();		
		Plan p = (Plan) session.load(Plan.class, new String(name));
		logger.info("Plan loaded successfully, Plan details="+p);
		return p;
	}

	@Override
	public void removePlan(String name) {
		Session session = this.sessionFactory.getCurrentSession();
		Plan p = (Plan) session.load(Plan.class, new String(name));
		if(null != p){
			session.delete(p);
		}
		logger.info("Plan deleted successfully, Plan details="+p);		
	}

}
