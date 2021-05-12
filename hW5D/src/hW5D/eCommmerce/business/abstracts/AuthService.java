package hW5D.eCommmerce.business.abstracts;

import hW5D.eCommmerce.entities.dto.LoginDto;
import hW5D.eCommmerce.entities.dto.RegisterDto;

public interface AuthService {
	void login(LoginDto loginDto);

	void register(RegisterDto registerDto);
}
