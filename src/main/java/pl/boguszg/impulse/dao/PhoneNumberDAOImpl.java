package pl.boguszg.impulse.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import pl.boguszg.impulse.model.PhoneNumber;
import pl.boguszg.impulse.model.User;

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

	@Override
	public PhoneNumber UnusedPhoneNumber(User user) {
		Session session = this.sessionFactory.openSession();
		//AND WHERE pn.user_email = NULL AND WHERE pn.assigned = NULL
		@SuppressWarnings("unchecked")
		List<PhoneNumber> freeNumbers = session.createQuery("FROM PhoneNumber WHERE username IS NULL").list();
		PhoneNumber freeNumber = freeNumbers.get(0);
		
		freeNumber.setUsername(user.getUsername());
		freeNumber.setUser_email(user.getEmail());
		System.out.println(freeNumber);
		session.saveOrUpdate(freeNumber);
		session.close();
		return freeNumber;
	}
}
