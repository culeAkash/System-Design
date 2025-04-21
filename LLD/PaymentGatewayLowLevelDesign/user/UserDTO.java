package LLD.PaymentGatewayLowLevelDesign.user;

public class UserDTO {
    private int userId;
    private String name;
    private String mail;

    public UserDTO(){}

    public UserDTO(int userId, String name, String email) {
        this.userId = userId;
        this.name = name;
        this.mail = email;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
