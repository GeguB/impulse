package pl.boguszg.impulse.dao;

import pl.boguszg.impulse.model.PhoneNumber;
import pl.boguszg.impulse.model.User;

public interface PhoneNumberDAO {

	public PhoneNumber getPhoneNumberByName(String name);
	public PhoneNumber UnusedPhoneNumber(User user);
	
}
