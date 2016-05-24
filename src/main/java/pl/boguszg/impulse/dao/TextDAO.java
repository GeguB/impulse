package pl.boguszg.impulse.dao;

import java.util.List;

import pl.boguszg.impulse.model.Summary;
import pl.boguszg.impulse.model.Text;

public interface TextDAO {

	public List<Text> getTextByDialer(int dialer);
	public Summary getSummary(int dialer, String period, List<Text> connList);

}
