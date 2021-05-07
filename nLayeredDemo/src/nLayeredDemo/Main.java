package nLayeredDemo;

import nLayeredDemo.business.absracts.UserService;
import nLayeredDemo.business.concretes.UserManager;
import nLayeredDemo.core.GoogleLogIn;
import nLayeredDemo.dataAccess.concretes.HibernateDao;
import nLayeredDemo.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		UserService userService = new UserManager(new HibernateDao(), new GoogleLogIn());

		User user1 = new User(1, "Hatice Nur", " KAYA", "hnk@gmail.com", "123456");
		userService.register("hnk@gmail.com", "123456", user1);

		userService.logIn("hnk@gmail.com", "123456");
       
		userService.googleRegister(user1);

		System.out.println("***************************************************");
		User user2 = new User(1, "HNK", " K", "hnk", "123");
		userService.register("hnk", "123", user2);

		userService.logIn("hnk", "123");

		userService.googleRegister(user2);
		
		System.out.println("***************************************************");
		User user3 = new User(1, "H", " KAYA", "hnk@gmail.com", "123456");
		userService.register("hnk@gmail.com", "123456", user3);

		userService.logIn("hnk@gmail.com", "123456");

		userService.googleRegister(user3);

	}

}
