package pl.boguszg.impulse.service;

import java.util.List;

import pl.boguszg.impulse.model.Summary;
import pl.boguszg.impulse.model.Text;

public interface TextService {

	public List<Text> getTextByDialer(int dialer);
	public Summary getSummary(int dialer, String period, List<Text> connList);

}
