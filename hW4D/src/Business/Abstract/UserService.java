package Business.Abstract;

import Entitties.Concrete.User;

public interface UserService {
	User get(int id);
	void getAll();
	void update(User user);
	void add(User user);
	void delete(int id);
}
