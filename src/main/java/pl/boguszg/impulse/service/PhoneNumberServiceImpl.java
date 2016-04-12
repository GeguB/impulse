package pl.boguszg.impulse.service;

import pl.boguszg.impulse.dao.PhoneNumberDAO;
import pl.boguszg.impulse.model.PhoneNumber;

public class PhoneNumberServiceImpl implements PhoneNumberService {

	private PhoneNumberDAO phoneNumberDAO;

	public void setPhoneNumberDAO(PhoneNumberDAO phoneNumberDAO) {
		this.phoneNumberDAO = phoneNumberDAO;
	}
	
	@Override
	public PhoneNumber getPhoneNumberByName(String name) {
		return this.phoneNumberDAO.getPhoneNumberByName(name);
	}

}
