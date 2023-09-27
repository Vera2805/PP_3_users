package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;

import web.model.User;

import java.util.ArrayList;
import java.util.List;
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    private final List<User> users = new ArrayList<>();

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public User getUser(String mail) {
        return userDao.getUser(mail);

    }
    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }
    @Override
    public void updateUser(String email,String name,String lastname,String mail) {
        userDao.updateUser(email,name,lastname,mail);
    }
    @Override
    public void deleteUser(String mail) {
        userDao.deleteUser(mail);

    }

}


