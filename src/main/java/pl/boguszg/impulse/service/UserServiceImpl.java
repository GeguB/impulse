package pl.boguszg.impulse.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.boguszg.impulse.dao.UserDAO;
import pl.boguszg.impulse.model.User;

@Service
public class UserServiceImpl implements UserService {
	
	private UserDAO userDAO;

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	@Transactional
	public void addUser(User u) {
		this.userDAO.addUser(u);
	}

	@Override
	@Transactional
	public void updateUser(User u) {
		this.userDAO.updateUser(u);
	}

	@Override
	@Transactional
	public List<User> listUsers() {
		return this.userDAO.listUsers();
	}

	@Override
	@Transactional
	public User getUserById(int id) {
		return this.userDAO.getUserById(id);
	}

	@Override
	@Transactional
	public void removeUser(String name) {
		this.userDAO.removeUser(name);
	}

	@Override
	@Transactional
	public User getUserByName(String name) {
		return this.userDAO.getUserByName(name);
	}

}
