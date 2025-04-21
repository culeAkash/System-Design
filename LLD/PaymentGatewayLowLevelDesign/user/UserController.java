package LLD.PaymentGatewayLowLevelDesign.user;

public class UserController {
    UserService userService;

    public UserController() {
        userService = new UserService();
    }

    public void addUser(UserDTO userDto) {
        userService.addUser(userDto);
    }

    public UserDTO getUser(String email) {
        return userService.getUser(email);
    }
}
