package user.dto;

public class JoinRequestDto {
	private String userId;
	private String password;
    private String name;
    private String role;
    private String email;
    private String phone;
    
	public JoinRequestDto() { }

	public JoinRequestDto(String userId, String password, String name, String role, String email, String phone) {
		this.userId = userId;
		this.password = password;
		this.name = name;
		this.role = role;
		this.email = email;
		this.phone = phone;
	}

	public String getUserId() {
		return userId;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public String getRole() {
		return role;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
