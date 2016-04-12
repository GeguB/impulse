package pl.boguszg.impulse.service;

import java.util.List;

import pl.boguszg.impulse.model.Call;


public interface CallService {
	
	public void addCall(Call c);
	public List<Call> getCallByDialer(int dialer);

}
