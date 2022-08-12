package dao;

import models.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDAO {
    private static int USER_COUNT = 1;
    private List<User> users;

    {
        users = new ArrayList<>();
        users.add(new User(++USER_COUNT, "I","m"));
        users.add(new User(++USER_COUNT, "YOU","w"));
    }

    public List<User> getUsers() {
        return users;
    }
    public User getUser(int id) {
        return users.stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }
    public void save(User user) {
        user.setId(++USER_COUNT);
        users.add(user);
    }

    public void update(int id, User user) {
        getUser(id).setName(user.getName());
        getUser(id).setSex(user.getSex());
    }

    public void delete(int id) {
        users.removeIf(user -> user.getId() == id);
    }
}
