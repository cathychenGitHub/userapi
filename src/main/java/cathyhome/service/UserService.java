package cathyhome.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cathyhome.dao.IUserDAO;
import cathyhome.entity.User;
@Service
public class UserService implements IUserService {
	@Autowired
	private IUserDAO userDAO;
	@Override
	public User getUserById(int uId) {
		User obj = userDAO.getUserById(uId);
		return obj;
	}	
	@Override
	public List<User> getAllUsers(){
		return userDAO.getAllUsers();
	}
	@Override
	public synchronized boolean createUser(User user){
       if (userDAO.userExits(user.getName(), user.getEmail())) {
    	   return false;
       } else {
    	   userDAO.createUser(user);
    	   return true;
       }
	}
	@Override
	public void updateUser(User user) {
		userDAO.updateUser(user);
	}
	@Override
	public void deleteUser(int uId) {
		userDAO.deleteUser(uId);
	}
}

