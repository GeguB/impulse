package pl.boguszg.impulse.service;

import java.util.List;

import pl.boguszg.impulse.model.Text;

public interface TextService {

	public List<Text> getTextByDialer(int dialer);

}
