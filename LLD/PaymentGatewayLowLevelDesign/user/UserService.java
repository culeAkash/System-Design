package LLD.PaymentGatewayLowLevelDesign.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class UserService {
    public static List<User> users = new ArrayList<>();


    public User convertUserDTOToUser(UserDTO userDto) {
        User user = new User();
        user.setUserId(userDto.getUserId());
        user.setName(userDto.getName());
        user.setEmail(userDto.getMail());
        return user;
    }

    public UserDTO convertUserToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(user.getUserId());
        userDTO.setName(user.getName());
        userDTO.setMail(user.getEmail());
        return userDTO;
    }

    public UserDTO addUser(UserDTO userDto) {
        userDto.setUserId(new Random().nextInt(100-10)+10);
        User user = convertUserDTOToUser(userDto);
        users.add(user);
        return convertUserToUserDTO(user);
    }

    public List<User> getUsers() {
        return users;
    }

    public UserDTO getUser(String email) {
        User userObj = users.stream().filter(user->user.getEmail().equals(email)).collect(Collectors.toList()).get(0);
        return convertUserToUserDTO(userObj);
    }
}
