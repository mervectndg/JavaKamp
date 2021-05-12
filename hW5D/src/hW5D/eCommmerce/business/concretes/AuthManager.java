package hW5D.eCommmerce.business.concretes;

import hW5D.eCommmerce.business.abstracts.AuthService;
import hW5D.eCommmerce.business.abstracts.UserService;
import hW5D.eCommmerce.entities.concretes.User;
import hW5D.eCommmerce.entities.dto.LoginDto;
import hW5D.eCommmerce.entities.dto.RegisterDto;

public class AuthManager implements AuthService {
	UserService _userService;

	public AuthManager(UserService _userService) {
		super();
		this._userService = _userService;
	}

	@Override
	public void login(LoginDto loginDto) {
		System.out.println(loginDto.geteMail());

		User userToCheck = _userService.getByEmail(loginDto.geteMail());
		if (userToCheck == null) {
			System.out.println("Email yanlýþ girdiniz.");
			return;
		}
		if (userToCheck.getPassword() != loginDto.getPassword()) {
			System.out.println("Þifrenizi yanlýþ girdiniz.");
			return;
		}
		if (_userService.chekIfActive(userToCheck)) {
			System.out.println("Hesap aktif deðil.");
			return;
		}
		System.out.println("Giriþ baþaýyla gerçekleþtirildi.");
	}

	@Override
	public void register(RegisterDto registerDto) {
		_userService.add(registerDto);

	}

}
