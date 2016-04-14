package pl.boguszg.impulse.service;

import java.util.List;

import pl.boguszg.impulse.dao.TextDAO;
import pl.boguszg.impulse.model.Text;

public class TextServiceImpl implements TextService {

	private TextDAO textDAO;
	
	public void setTextDAO(TextDAO textDAO){
		this.textDAO = textDAO;
	}
	
	@Override
	public List<Text> getTextByDialer(int dialer) {
		return this.textDAO.getTextByDialer(dialer);

	}

}
