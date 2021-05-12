package hW5D.eCommmerce.fakeAuthantication;

public class FakeAuthanticationUser {
	private int fakeId;
	private String eMail;
	private String password;
	private String firstName;
	private String lastName;

	public FakeAuthanticationUser(int fakeId, String eMail, String password, String firstName, String lastName) {
		super();
		this.fakeId = fakeId;
		this.eMail = eMail;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getFakeId() {
		return fakeId;
	}

	public void setFakeId(int fakeId) {
		this.fakeId = fakeId;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
