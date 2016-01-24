package pl.boguszg.impulse.service;

import java.util.List;

import pl.boguszg.impulse.model.User;

public interface UserService {

	public void addUser(User p);
	public void updateUser(User p);
	public List<User> listUsers();
	public User getUserById(int id);
	public User getUserByName(String name);
	public void removeUser(String name);
	
}
