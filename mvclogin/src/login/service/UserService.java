package login.service;

import login.dao.UserDao;
import login.model.User;

public class UserService {

	UserDao userDao = new UserDao();
	public boolean checkUser(String username, String pass) {
		return userDao.fetchUserByUsernameAndPassword(username,pass);
	}
	public User getUser(String username) {
		return userDao.getUserByUsername(username);
		
	}
	public boolean editUser(User user) {
		// TODO Auto-generated method stub
		return userDao.updateUser(user);
	}

}
