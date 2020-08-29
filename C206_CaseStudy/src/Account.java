
public class Account {
	private String username;
	private String password;
	private String studentid;
	private int contactnumber;
	public Account(String username, String password, String studentid, int contactnumber) {
		super();
		this.username = username;
		this.password = password;
		this.studentid = studentid;
		this.contactnumber = contactnumber;
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
	public String getStudentid() {
		return studentid;
	}
	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}
	public int getContactnumber() {
		return contactnumber;
	}
	public void setContactnumber(int contactnumber) {
		this.contactnumber = contactnumber;
	}
	



}
