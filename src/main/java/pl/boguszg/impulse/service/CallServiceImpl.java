package pl.boguszg.impulse.service;

import java.util.List;

import pl.boguszg.impulse.dao.CallDAO;
import pl.boguszg.impulse.model.Call;
import pl.boguszg.impulse.model.Summary;

public class CallServiceImpl implements CallService {

	private CallDAO callDAO;
	
	public void setCallDAO(CallDAO callDAO){
		this.callDAO = callDAO;
	}
	
	
	@Override
	public void addCall(Call c) {
		this.callDAO.addCall(c);
		
	}

	@Override
	public List<Call> getCallByDialer(int dialer) {
		return this.callDAO.getCallByDialer(dialer);
	}


	@Override
	public Summary getSummary(int dialer, String period, List<Call> connList) {
		return this.callDAO.getSummary(dialer, period, connList);
	}

}
