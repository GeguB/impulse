package pl.boguszg.impulse.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import pl.boguszg.impulse.model.Text;

@Repository
public class TextDAOImpl implements TextDAO{

	private static final Logger logger = LoggerFactory.getLogger(TextDAOImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	@Override
	public List<Text> getTextByDialer(int dialer) {
		Session session = this.sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Text> textsList = session.createQuery("from Text t where t.phone_number = :dialer").setParameter("dialer", dialer).list();

		for (Text t : textsList) {
			logger.info("Text List::" + t);
		}
		session.close();
		return textsList;
	}

}
