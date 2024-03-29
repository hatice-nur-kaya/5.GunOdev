package nLayeredDemo.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import nLayeredDemo.business.absracts.UserService;
import nLayeredDemo.core.GoogleLogInService;
import nLayeredDemo.dataAccess.absracts.UserDao;
import nLayeredDemo.entities.concretes.User;

public class UserManager implements UserService {

	UserDao userDao;
	GoogleLogInService googleLogInService;

	private ArrayList<String> emailList = new ArrayList<String>();
	private ArrayList<String> paswordList = new ArrayList<String>();

	//regex
	public static boolean isEmailValid(String email) {
		final Pattern EMAIL_REGEX = Pattern.compile(
				"[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
				Pattern.CASE_INSENSITIVE);
		return EMAIL_REGEX.matcher(email).matches();
	}

	public static boolean isEmailValidOnClick() {

		return true;
	}

	public UserManager(UserDao userDao, GoogleLogInService googleLogInService) {
		super();
		this.userDao = userDao;
		this.googleLogInService=googleLogInService;
	}
	
	@Override
	public void register(String email, String password, User user) {
		if (isEmailValid(email) != true) {
			System.out.println("E-posta adresi ge�erli de�il. Ge�erli bir E-posta adresi giriniz.");
			return;
		} else if (user.geteMail().equals(emailList.contains(email))) {
			System.out.println("Bu e-posta zaten kay�tl�. L�tfen ba�ka bir tane deneyin.");
			return;
		} else if (password.length() < 6) {
			System.out.println("Parola minimum 6 karakterden olu�mal�d�r.");
			return;
		} else if (user.getFirstName().length() < 2) {
			System.out.println("�sim en az 2 karakter i�ermelidir.");
			return;
		} else if (user.getLasttName().length() < 2) {
			System.out.println("Soyad� en az 2 karakter i�ermelidir.");
			return;
		} else {
			System.out.println("Kay�t ba�ar�l�.");

			emailList.add(email);
			paswordList.add(password);
			userDao.add(user);
		}
	}

	@Override
	public void logIn(String email, String password) {
		if (isEmailValidOnClick()) {
			System.out.println("Giri� yapmadan �nce e-postan�z� onaylay�n.");
		}
		if (isEmailValid(email) && paswordList.contains(password)) {
			System.out.println("Giri� ba�ar�l�");
			return;
		} else if (!paswordList.contains(password) || !isEmailValid(email)) {
			System.out.println("Giri� ba�ar�s�z. L�tfen tekrar kontrol edin.");
		}
	}


	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void googleRegister(User user) {
		// TODO Auto-generated method stub
		
	}

	
	
}
