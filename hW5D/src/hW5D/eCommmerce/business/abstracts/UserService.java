package hW5D.eCommmerce.business.abstracts;

import hW5D.eCommmerce.entities.concretes.User;
import hW5D.eCommmerce.entities.dto.RegisterDto;

public interface UserService {
	User getByEmail(String eMail);

	User getByActivationCode(String activationCode);

	void add(RegisterDto registerDto);

	void getAll();

	boolean chekIfActive(User user);

	void activateUser(String activationCode);
}
