package hW5D.eCommmerce.googleAuthantication;

public class GoogleAuthanticationUser {

	private int googleId;
	private String eMail;
	private String password;
	private String firstName;
	private String lastName;

	public GoogleAuthanticationUser(int googleId, String eMail, String password, String firstName, String lastName) {
		super();
		this.googleId = googleId;
		this.eMail = eMail;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getGoogleId() {
		return googleId;
	}

	public void setGoogleId(int googleId) {
		this.googleId = googleId;
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
