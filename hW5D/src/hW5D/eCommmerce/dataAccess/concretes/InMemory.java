package hW5D.eCommmerce.dataAccess.concretes;

import java.util.ArrayList;
import java.util.function.Predicate;

import hW5D.eCommmerce.dataAccess.abstracts.UserDao;
import hW5D.eCommmerce.entities.concretes.User;

public class InMemory implements UserDao {

	ArrayList<User> users;

	public InMemory() {
		super();
		users = new ArrayList<User>();
	}

	@Override
	public void add(User user) {
		users.add(user);
		System.out.println(" Kullanýcý basarýyla eklendi.");
	}

	@Override
	public void update(User user) {
		User updatedUser = users.stream().filter(a -> a.geteMail() == user.geteMail()).findFirst().get();
		users.remove(updatedUser);
		users.add(user);
		System.out.println(" Kullanýcý basarýyla güncellendi.");
	}

	@Override
	public void delete(User user) {
		User deletedUser = users.stream().filter(a -> a.geteMail() == user.geteMail()).findFirst().get();
		users.remove(deletedUser);
		System.out.println(" Kullanýcý basarýyla silindi.");

	}

	@Override
	public User get(Predicate<? super User> filter) {
		return users.stream().filter(filter).findFirst().orElse(null);
	}

	@Override
	public ArrayList<User> getAll() {
		return users;
	}

}
