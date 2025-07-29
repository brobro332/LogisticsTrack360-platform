package kr.co.logistics_track_360.user.vo;

public class UserVO {
    private final String userId;
    private final String password;
    private final String name;
    private final String role;     /* CUSTOMER, ADMIN */
    private final String email;
    private final String phone;

    public UserVO(String userId, String password, String name, String role, String email, String phone) {
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
}