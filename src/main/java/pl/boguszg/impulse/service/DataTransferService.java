package pl.boguszg.impulse.service;

import java.util.List;

import pl.boguszg.impulse.model.DataTransfer;
import pl.boguszg.impulse.model.Summary;

public interface DataTransferService {
	
	public List<DataTransfer> getDataTransferByDialer(int dialer);
	public Summary getSummary(int dialer, String period, List<DataTransfer> connList);

}
