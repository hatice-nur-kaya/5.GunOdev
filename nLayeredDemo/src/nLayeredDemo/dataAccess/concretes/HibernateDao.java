package nLayeredDemo.dataAccess.concretes;

import nLayeredDemo.dataAccess.absracts.UserDao;
import nLayeredDemo.entities.concretes.User;

public class HibernateDao implements UserDao {

	@Override
	public void add(User user) {
		System.out.println("Hibernate ile eklendi : " + user.getFirstName() + user.getLasttName());
		
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User get(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
