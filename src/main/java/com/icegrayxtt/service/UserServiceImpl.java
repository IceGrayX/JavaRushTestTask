package com.icegrayxtt.service;

import com.icegrayxtt.dao.UserDao;
import com.icegrayxtt.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Валерий on 14.11.2016.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public void addUser(User user) {
        this.userDao.addUser(user);
    }

    @Override
    public void editUser(User user) {
        this.userDao.editUser(user);
    }

    @Override
    public void deleteUser(Integer id) {
        this.userDao.deleteUser(id);
    }

    @Override
    public User getUser(Integer id) {
        return this.userDao.getUser(id);
    }

    @Override
    public List<User> listUsers() {
        return this.userDao.listUsers();
    }

    @Override
    public List<User> getAllPage(int begin, int num) {
        return this.userDao.getAllPage(begin, num);
    }

    @Override
    public List<User> getNotAll(String name) {
        return this.userDao.getNotAll(name);
    }
}
