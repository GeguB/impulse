package pl.boguszg.impulse.dao;

import java.util.List;

import pl.boguszg.impulse.model.Call;
import pl.boguszg.impulse.model.Summary;

public interface CallDAO {

	public void addCall(Call c);
	public List<Call> getCallByDialer(int dialer);
	public Summary getSummary(int dialer, String period, List<Call> connList);

}
