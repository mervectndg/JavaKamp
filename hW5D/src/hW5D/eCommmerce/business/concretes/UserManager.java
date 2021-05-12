package hW5D.eCommmerce.business.concretes;

import java.util.Random;

import hW5D.eCommmerce.business.abstracts.UserService;
import hW5D.eCommmerce.business.validationRules.UserValidation;
import hW5D.eCommmerce.core.MailSender;
import hW5D.eCommmerce.dataAccess.abstracts.UserDao;
import hW5D.eCommmerce.entities.concretes.User;
import hW5D.eCommmerce.entities.dto.RegisterDto;

public class UserManager implements UserService {

	UserDao _userDao;
	Random rand;

	private boolean checkIfEmail(String eMail) {
		if (getByEmail(eMail) == null) {
			return true;
		}

		System.out.println("Boyle bir kullanici sisteme kayitlidir.");
		return false;

	}

	public UserManager(UserDao _userDao) {
		rand = new Random();
		this._userDao = _userDao;
	}

	@Override
	public User getByEmail(String eMail) {
		return _userDao.get(a -> a.geteMail() == eMail);
	}

	@Override
	public User getByActivationCode(String activationCode) {
		return _userDao.get(a -> a.getActivationCode() == activationCode);

	}

	@Override
	public void add(RegisterDto registerDto) {
		User user = new User(registerDto.getFirstName(), registerDto.getLastName(), registerDto.geteMail(),
				registerDto.getPassword());
		if (UserValidation.validation(user) == false || checkIfEmail(user.geteMail()) == false) {
			System.out.println("Kayýt olamadýnýz.");
			return;
		}

		String activationCode = "AC-" + rand.nextInt(Integer.MAX_VALUE) + rand.nextInt(Integer.MAX_VALUE);
		user.setActivationCode(activationCode);
		_userDao.add(user);
		System.out.println("hesabýnýz oluþturuldu.");
		MailSender.send(activationCode);

	}

	@Override
	public void getAll() {
		for (User user : _userDao.getAll()) {
			System.out.println("Adýnýz : " + user.getFirstName());
			System.out.println("Soyadýnýz : " + user.getLastName());
			System.out.println("Þifreniz : " + user.getPassword());
			System.out.println("Statünüz : " + user.getStatus());
			System.out.println("Email adresiniz : " + user.geteMail());
			System.out.println("Aktivasyon kodunuz : " + user.getActivationCode());

		}
	}

	@Override
	public boolean chekIfActive(User user) {
		if (user != null && user.getStatus() == true) {
			return false;
		}
		return true;
	}

	@Override
	public void activateUser(String activationCode) {
		User user = getByActivationCode(activationCode);
		if (user == null) {
			System.out.println("Aktivasyon kodunuzu yanlýþ girdiniz.");
			return;
		}
		user.setStatus(true);
		user.setActivationCode("");
		_userDao.update(user);
		System.out.println("Hesabýnýzý aktifleþtirdi.");

	}

}
