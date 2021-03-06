package pl.boguszg.impulse.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import pl.boguszg.impulse.model.Call;
import pl.boguszg.impulse.model.Summary;

@Repository
public class CallDAOImpl implements CallDAO {

	private static final Logger logger = LoggerFactory.getLogger(CallDAOImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void addCall(Call c) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(c);
		logger.info("Plan saved successfully, Connection Details=" + c);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Call> getCallByDialer(int dialer) {
		Session session = this.sessionFactory.openSession();
		List<Call> callsList = session.createQuery("from Call c where c.phone_number = :dialer").setParameter("dialer", dialer).list();

		for (Call c : callsList) {
			logger.info("Call List::" + c);
		}
		session.close();
		return callsList;
	}

	@Override
	public Summary getSummary(int dialer, String period, List<Call> connList) {
		connList = getCallByDialer(dialer);
		Summary summary = new Summary();
		summary.setType("call");
		summary.setCount(connList.size());
		int value = 0;
		for (Call call : connList){
			value = value + call.getDuration();
		}
		summary.setValue(value);
		return summary;
	}

}
