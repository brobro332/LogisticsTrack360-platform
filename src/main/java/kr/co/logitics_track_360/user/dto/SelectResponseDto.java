package kr.co.logitics_track_360.user.dto;

public class SelectResponseDto {
    private String userId;
    private String name;
    private String role;
    private String email;
    private String phone;
    
	public SelectResponseDto() { }

	public SelectResponseDto(String userId, String name, String role, String email, String phone) {
		this.userId = userId;
		this.name = name;
		this.role = role;
		this.email = email;
		this.phone = phone;
	}
	
	public String getUserId() {
		return userId;
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
	
	public static class Builder {
        private String userId;
        private String name;
        private String role;
        private String email;
        private String phone;

        public Builder userId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder role(String role) {
            this.role = role;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public SelectResponseDto build() {
            return new SelectResponseDto(userId, name, role, email, phone);
        }
    }
}
