package pl.boguszg.impulse.dao;

import java.util.List;

import pl.boguszg.impulse.model.DataTransfer;

public interface DataTransferDAO {

	public List<DataTransfer> getDataTransferByDialer(int dialer);

}
