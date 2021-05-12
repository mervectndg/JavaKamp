package hW5D.eCommmerce;

import hW5D.eCommmerce.business.abstracts.AuthService;
import hW5D.eCommmerce.business.abstracts.UserService;
import hW5D.eCommmerce.business.concretes.AuthManager;
import hW5D.eCommmerce.business.concretes.UserManager;
import hW5D.eCommmerce.core.concretes.FakeAuthanticationAdapter;
import hW5D.eCommmerce.core.concretes.GoogleAuthanticationAdapter;
import hW5D.eCommmerce.dataAccess.abstracts.UserDao;
import hW5D.eCommmerce.dataAccess.concretes.InMemory;
import hW5D.eCommmerce.entities.dto.LoginDto;
import hW5D.eCommmerce.entities.dto.RegisterDto;

public class Main {

	public static void main(String[] args) {
		UserDao userDao = new InMemory();
		UserService userManager = new UserManager(userDao);
		AuthService authManager = new AuthManager(userManager);
		FakeAuthanticationAdapter fakeAuthanticationAdapter = new FakeAuthanticationAdapter();
		GoogleAuthanticationAdapter googleAuthanticationAdapter = new GoogleAuthanticationAdapter();

		RegisterDto registerDto = new RegisterDto("Merve", "�etinda�", "merve@gmail.com", "123456789");
		RegisterDto fakeRegister = fakeAuthanticationAdapter.registerUser();
		RegisterDto googleRegister = googleAuthanticationAdapter.registerUser();

		System.out.println("----------------------------------------");

		System.out.println("Normal ");
		authManager.register(registerDto);

		System.out.println("----------------------------------------");

		System.out.println("Fake ");
		authManager.register(fakeRegister);

		System.out.println("----------------------------------------");

		System.out.println("Google ");
		authManager.register(googleRegister);

		System.out.println("----------------------------------------");

		System.out.println("T�m validasyon hatalar� olan kay�tlar ");
		authManager.register(new RegisterDto("", "", "", ""));

		System.out.println("----------------------------------------");
		System.out.println("----------------------------------------");
		System.out.println("----------------------------------------");

		System.out.println("Do�ru aktivasyon ");
		userManager.activateUser(userManager.getByEmail(registerDto.geteMail()).getActivationCode());

		System.out.println("----------------------------------------");

		System.out.println("Hatal� aktivasyon ");
		userManager.activateUser("Hatal� aktivasyon kodu");

		System.out.println("----------------------------------------");
		System.out.println("----------------------------------------");
		System.out.println("----------------------------------------");

		System.out.println("Aktif hesaba giri� ");
		authManager.login(new LoginDto(registerDto.geteMail(), registerDto.getPassword()));

		System.out.println("----------------------------------------");

		System.out.println("Paif hesap ");
		authManager.login(new LoginDto(googleRegister.geteMail(), googleRegister.getPassword()));

		System.out.println("----------------------------------------");

		System.out.println("Kay�ts�z hesap ");
		authManager.login(new LoginDto("merve@gmail.com", "123456789"));

		System.out.println("----------------------------------------");

		System.out.println("Kay�tl� hesap haatl� �ifre");
		authManager.login(new LoginDto(registerDto.geteMail(), "123456789"));

		System.out.println("----------------------------------------");

	}

}
