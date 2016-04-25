package pl.boguszg.impulse.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import pl.boguszg.impulse.model.PhoneNumber;

@Repository
public class PhoneNumberDAOImpl implements PhoneNumberDAO{

	private static final Logger logger = LoggerFactory.getLogger(PlanDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@Override
	public PhoneNumber getPhoneNumberByName(String name){
		Session session = this.sessionFactory.openSession();		
		PhoneNumber pn = (PhoneNumber) session.load(PhoneNumber.class, new String(name));
		logger.info("PhoneNumber loaded successfully, PhoneNumber details="+pn);
		session.close();
		return pn;
	}
}
