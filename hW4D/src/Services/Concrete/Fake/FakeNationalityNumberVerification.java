package Services.Concrete.Fake;

import Entitties.Concrete.User;
import Services.Abstract.NationalityNumberVerification;

public class FakeNationalityNumberVerification implements NationalityNumberVerification{

	@Override
	public Boolean verification(User user) {
		int nationalityNumberLenght=user.getNationalityNumber().length();
		
		System.out.println("Tc kimlik doðrulama sistemi");
		
		if(nationalityNumberLenght!=11) 
		{
			System.out.println("Tc Kimlik numarasý 11 karakterden oluþmalýdýr. Siz " + nationalityNumberLenght + "girdiniz");
			return false;
		}
		System.out.println("Tc kimlik doðru...");
		return true;
	}
	
}
