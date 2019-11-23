package beans;

public class User {
	private int user_id;
	private String fname;
	private String lname;
	private String username;
	private String password;
	
	public User() {
		super();
		
	}

	public User(int user_id, String fname, String lname, String username, String password) {
		super();
		this.user_id = user_id;
		this.fname = fname;
		this.lname = lname;
		this.username = username;
		this.password = password;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
}
