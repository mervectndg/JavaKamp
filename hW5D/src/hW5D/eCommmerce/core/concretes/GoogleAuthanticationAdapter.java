package hW5D.eCommmerce.core.concretes;

import hW5D.eCommmerce.core.abstracts.AuthanticationService;
import hW5D.eCommmerce.entities.dto.RegisterDto;
import hW5D.eCommmerce.googleAuthantication.GoogleAuthanticationManager;
import hW5D.eCommmerce.googleAuthantication.GoogleAuthanticationUser;

public class GoogleAuthanticationAdapter implements AuthanticationService {

	@Override
	public RegisterDto registerUser() {
		GoogleAuthanticationManager googleAuthanticationManager=new GoogleAuthanticationManager();
		GoogleAuthanticationUser googleAuthanticationUser=googleAuthanticationManager.getGoogUser();
		
		return new RegisterDto(
				googleAuthanticationUser.getFirstName(),
				googleAuthanticationUser.getLastName(),
				googleAuthanticationUser.geteMail(),
				googleAuthanticationUser.getPassword());
	}

}
