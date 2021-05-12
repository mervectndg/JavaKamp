package hW5D.eCommmerce.dataAccess.abstracts;

import java.util.ArrayList;
import java.util.function.Predicate;

import hW5D.eCommmerce.entities.concretes.User;

public interface UserDao {
	void add(User user);

	void update(User user);

	void delete(User user);

	User get(Predicate<? super User> filter);

	ArrayList<User> getAll();

}
