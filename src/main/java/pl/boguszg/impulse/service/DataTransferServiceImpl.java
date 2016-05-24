package pl.boguszg.impulse.service;

import java.util.List;

import pl.boguszg.impulse.dao.DataTransferDAO;
import pl.boguszg.impulse.model.DataTransfer;
import pl.boguszg.impulse.model.Summary;

public class DataTransferServiceImpl implements DataTransferService{
	
	private DataTransferDAO dataTransferDAO; 

	public void setDataTransferDAO(DataTransferDAO dataTransferDAO){
		this.dataTransferDAO = dataTransferDAO;
	}
	
	@Override
	public List<DataTransfer> getDataTransferByDialer(int dialer) {
		return this.dataTransferDAO.getDataTransferByDialer(dialer);

	}

	@Override
	public Summary getSummary(int dialer, String period, List<DataTransfer> connList) {
		return this.dataTransferDAO.getSummary(dialer, period, connList);
	}
}
