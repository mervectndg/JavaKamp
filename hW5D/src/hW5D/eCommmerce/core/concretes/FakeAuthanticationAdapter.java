package hW5D.eCommmerce.core.concretes;

import hW5D.eCommmerce.core.abstracts.AuthanticationService;
import hW5D.eCommmerce.entities.dto.RegisterDto;
import hW5D.eCommmerce.fakeAuthantication.FakeAuthanticationManager;
import hW5D.eCommmerce.fakeAuthantication.FakeAuthanticationUser;

public class FakeAuthanticationAdapter implements AuthanticationService {

	@Override
	public RegisterDto registerUser() {
		FakeAuthanticationManager fakeAuthanticationManager = new FakeAuthanticationManager();
		FakeAuthanticationUser authanticationUser = fakeAuthanticationManager.getUser();

		return new RegisterDto(authanticationUser.getFirstName(), authanticationUser.getLastName(),
				authanticationUser.geteMail(), authanticationUser.getPassword());
	}

}
