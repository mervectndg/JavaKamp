package hW5D.eCommmerce.fakeAuthantication;

public class FakeAuthanticationManager {

	public FakeAuthanticationUser getUser() {
		FakeAuthanticationUser fakeAuthanticationUser = new FakeAuthanticationUser(0, "fake@gmail.com", "987654321",
				"fake", "account");
		return fakeAuthanticationUser;
	}

}
