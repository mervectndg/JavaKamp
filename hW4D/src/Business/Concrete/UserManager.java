package Business.Concrete;

import java.util.ArrayList;

import Business.Abstract.UserService;
import Entitties.Concrete.User;
import Services.Abstract.NationalityNumberVerification;
import Services.ConcreteKPSPPublic.KPSPublicNationalityNumberVerificaition;

public class UserManager implements UserService {

	ArrayList<User> users;
	NationalityNumberVerification natinoalityNumberVerification;

	public UserManager() {
		super();
		natinoalityNumberVerification = new KPSPublicNationalityNumberVerificaition();

		users = new ArrayList<User>();

	}

	@Override
	public User get(int id) {
		User userGet = users.stream().filter(c -> c.getId() == id).findFirst().get();
		System.out.println("Id " + userGet.getId());
		System.out.println("Tc Kimlik " + userGet.getNationalityNumber());
		System.out.println("Ýsim " + userGet.getFirstName());
		System.out.println("Soyisim " + userGet.getLastName());
		System.out.println("Doðum Yýlý " + userGet.getBirthYear());
		return userGet;
	}

	@Override
	public void getAll() {
		for (User user : users) {
			System.out.println("Id " + user.getId());
			System.out.println("Tc Kimlik " + user.getNationalityNumber());
			System.out.println("Ýsim " + user.getFirstName());
			System.out.println("Soyisim " + user.getLastName());
			System.out.println("Doðum Yýlý " + user.getBirthYear());

		}
	}

	@Override
	public void update(User user) {
		Boolean validate = natinoalityNumberVerification.verification(user);
		if (validate) {
			User userUpdate = users.stream().filter(c -> c.getId() == user.getId()).findFirst().get();
			users.remove(userUpdate);
			users.add(user);
			System.out.println(" Kullanýcý baþarýyla güncellendi.");
		} else {
			System.out.println(" Kullanýcý güncellenirken bir hata oluþtu.");
		}

	}

	@Override
	public void add(User user) {
		Boolean validate = natinoalityNumberVerification.verification(user);
		if (validate) {
			users.add(user);
			System.out.println(" Kullanýcý baþarýyla eklendi.");
		} else {
			System.out.println(" Kullanýcý eklerken bir hata oluþtu.");
		}
	}

	@Override
	public void delete(int id) {
		User userDelete = users.stream().filter(c -> c.getId() == id).findFirst().get();
		users.remove(userDelete);
		System.out.println(" Kullanýcý basarýyla silindi.");
	}

}
