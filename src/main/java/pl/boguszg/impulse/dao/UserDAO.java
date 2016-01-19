package pl.boguszg.impulse.dao;

import java.util.List;

import pl.boguszg.impulse.model.User;

public interface UserDAO {

	public void addUser(User u);
	public void updateUser(User u);
	public List<User> listUsers();
	public User getUserById(int id);
	public void removeUser(int id);
}
