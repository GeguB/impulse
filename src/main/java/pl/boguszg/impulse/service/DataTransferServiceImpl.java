package pl.boguszg.impulse.service;

import java.util.List;

import pl.boguszg.impulse.dao.DataTransferDAO;
import pl.boguszg.impulse.model.DataTransfer;

public class DataTransferServiceImpl implements DataTransferService{
	
	private DataTransferDAO dataTransferDAO; 

	public void setDataTransferDAO(DataTransferDAO dataTransferDAO){
		this.dataTransferDAO = dataTransferDAO;
	}
	
	@Override
	public List<DataTransfer> getDataTransferByDialer(int dialer) {
		return this.dataTransferDAO.getDataTransferByDialer(dialer);

	}
}
