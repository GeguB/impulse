package pl.boguszg.impulse.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import pl.boguszg.impulse.model.User;

@Repository
public class UserDAOImpl implements UserDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addUser(User p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("User saved successfully, User Details="+p);
	}

	@Override
	public void updateUser(User p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("User updated successfully, User Details="+p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> listUsers() {
		Session session = this.sessionFactory.getCurrentSession();
		List<User> usersList = session.createQuery("from User").list();
		for(User p : usersList){
			logger.info("User List::"+p);
		}
		return usersList;
	}

	@Override
	public User getUserById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		User p = (User) session.load(User.class, new Integer(id));
		logger.info("User loaded successfully, User details="+p);
		return p;
	}

	@Override
	public void removeUser(String name) {
		Session session = this.sessionFactory.getCurrentSession();
		User p = (User) session.load(User.class, new String(name));
		if(null != p){
			session.delete(p);
		}
		logger.info("User deleted successfully, User details="+p);
	}

	@Override
	public User getUserByName(String name) {
		Session session = this.sessionFactory.getCurrentSession();		
		User p = (User) session.load(User.class, new String(name));
		logger.info("User loaded successfully, User details="+p);
		return p;
	}

}
