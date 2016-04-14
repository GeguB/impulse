package pl.boguszg.impulse.dao;

import java.util.List;

import pl.boguszg.impulse.model.Text;

public interface TextDAO {

	public List<Text> getTextByDialer(int dialer);
}
