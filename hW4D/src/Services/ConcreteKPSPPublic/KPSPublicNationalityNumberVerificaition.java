package Services.ConcreteKPSPPublic;

import Entitties.Concrete.User;
import Services.Abstract.NationalityNumberVerification;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoap;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class KPSPublicNationalityNumberVerificaition implements NationalityNumberVerification  {

	@Override
	public Boolean verification(User user) {
	
		KPSPublicSoap nationalityCheck=new KPSPublicSoapProxy();
		System.out.println("Tc kimlik doðrulama sistemi");
		
		Boolean result;
		
		try {
			result=nationalityCheck.TCKimlikNoDogrula(Long.parseLong(user.getNationalityNumber()),
					user.getFirstName(),
					user.getLastName(),
					user.getBirthYear());
		}catch (Exception e){
			System.out.println(e.toString());
			result=false;;
		}
		
		return result;
	}

	

}
