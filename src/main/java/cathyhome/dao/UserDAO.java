package cathyhome.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cathyhome
.entity.User;
@Transactional
@Repository
public class UserDAO implements IUserDAO {
	@PersistenceContext	
	private EntityManager entityManager;	
	@Override
	public User getUserById(int uId) {
		return entityManager.find(User.class, uId);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers() {
		//String hql = "FROM User as u ORDER BY u.userId DESC";
		String hql= "FROM User";
		return (List<User>) entityManager.createQuery(hql).getResultList();
	}	
	@Override
	public void createUser(User user) {
		entityManager.persist(user);
	}
	@Override
	public void updateUser(User user) {
		User artcl = getUserById(user.getUserId());
		artcl.setName(user.getName());
		artcl.setEmail(user.getEmail());
		entityManager.flush();
	}
	@Override
	public void deleteUser(int uId) {
		entityManager.remove(getUserById(uId));
	}
	@Override
	public boolean userExits(String nm, String email) {
		//String hql = "FROM User as atcl WHERE atcl.title = ? and atcl.category = ?";
		String hql = "FROM User as user WHERE user.name = :myname and user.email = :myemail";
		int count = entityManager.createQuery(hql).setParameter("myname", nm)
		              .setParameter("myemail", email).getResultList().size();
		return count > 0 ? true : false;
	}
}
