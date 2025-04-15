package LLD.InventorySystemDesign;

import java.util.ArrayList;
import java.util.List;

public class UserController {
    private List<User> users;

    public UserController() {
        this.users = new ArrayList<>();
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }
}
