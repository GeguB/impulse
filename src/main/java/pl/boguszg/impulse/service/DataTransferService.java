package pl.boguszg.impulse.service;

import java.util.List;

import pl.boguszg.impulse.model.DataTransfer;

public interface DataTransferService {
	
	public List<DataTransfer> getDataTransferByDialer(int dialer);

}
