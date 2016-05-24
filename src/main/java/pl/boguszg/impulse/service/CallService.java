package pl.boguszg.impulse.service;

import java.util.List;

import pl.boguszg.impulse.model.Call;
import pl.boguszg.impulse.model.Summary;


public interface CallService {
	
	public void addCall(Call c);
	public List<Call> getCallByDialer(int dialer);
	public Summary getSummary(int dialer, String period, List<Call> connList);


}
