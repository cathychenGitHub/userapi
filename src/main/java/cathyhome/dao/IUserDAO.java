package cathyhome.dao;
import java.util.List;
import cathyhome
.entity.User;
public interface IUserDAO {
    List<User> getAllUsers();
    User getUserById(int uId);
    void createUser(User user);
    void updateUser(User user);
    void deleteUser(int u);
    boolean userExits(String nm, String email);
}