package web.service;

import org.springframework.stereotype.Component;

import web.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);

    void deleteUser(String mail);

    void updateUser(String email, String name, String lastname, String mail);

    List<User> getAllUsers();

    User getUser(String mail);
}
