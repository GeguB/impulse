package pl.boguszg.impulse.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import pl.boguszg.impulse.model.DataTransfer;

@Repository
public class DataTransferDAOImpl implements DataTransferDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(DataTransferDAOImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	@Override
	public List<DataTransfer> getDataTransferByDialer(int dialer) {
		Session session = this.sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<DataTransfer> dataTransferList = session.createQuery("from DataTransfer dt where dt.phone_number = :dialer").setParameter("dialer", dialer).list();

		for (DataTransfer dt : dataTransferList) {
			logger.info("DataTransfer List::" + dt);
		}
		return dataTransferList;
	}
}
