package Nick.main.service;

import Nick.main.model.User;

import java.util.List;

public interface UserService {
    List<User> getUserList();

    User getUserById(int id);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(int id);
}
