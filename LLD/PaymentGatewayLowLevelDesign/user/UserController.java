package LLD.PaymentGatewayLowLevelDesign.user;

public class UserController {
    UserService userService;

    public UserController() {
        userService = new UserService();
    }

    public UserDTO addUser(UserDTO userDto) {
        return userService.addUser(userDto);
    }

    public UserDTO getUser(String email) {
        return userService.getUser(email);
    }
}
