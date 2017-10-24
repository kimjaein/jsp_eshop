package vo;

public class Member {
	private String id;
	private String pw;
	private String name;
	private String phone;
	private String address;
	private String email;

	/////////////////////////////////////////////////////////////
	public Member(String id, String pw, String name, String phone, String address, String email) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.email = email;
	}

	public Member() {
	}
	/////////////////////////////////////////////////////////////
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getphone() {
		return phone;
	}

	public void setphone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	/////////////////////////////////////////////////////////////
	
	@Override
	public String toString() {
		return "Member [id=" + id + ", pw=" + pw + ", name=" + name + ", phone=" + phone + ", address=" + address
				+ ", email=" + email + "]";
	}

}
