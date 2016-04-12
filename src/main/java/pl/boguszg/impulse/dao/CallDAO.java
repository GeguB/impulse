package pl.boguszg.impulse.dao;

import java.util.List;

import pl.boguszg.impulse.model.Call;

public interface CallDAO {

	public void addCall(Call c);
	public List<Call> getCallByDialer(int dialer);
}
