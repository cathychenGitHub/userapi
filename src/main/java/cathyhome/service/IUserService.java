package cathyhome.service;

import java.util.List;

import cathyhome
.entity.User;

public interface IUserService {
     List<User> getAllUsers();
     User getUserById(int uidd);
     boolean createUser(User user);
     void updateUser(User user);
     void deleteUser(int uId);
}

