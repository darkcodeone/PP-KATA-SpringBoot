package Nick.main.dao;

import Nick.main.model.User;


import java.util.List;

public interface UserDao {
    List<User> getUserList();

    User getUserById(int id);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(int id);

}
