package pl.boguszg.impulse.service;

import pl.boguszg.impulse.model.PhoneNumber;
import pl.boguszg.impulse.model.User;

public interface PhoneNumberService {

	public PhoneNumber getPhoneNumberByName(String name);
	public PhoneNumber UnusedPhoneNumber(User user);


}
