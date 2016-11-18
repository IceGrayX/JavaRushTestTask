package com.icegrayxtt.dao;

import com.icegrayxtt.model.User;

import java.util.List;

/**
 * Created by Валерий on 14.11.2016.
 */
public interface UserDao {
    public void addUser(User user);
    public void editUser(User user);
    public void deleteUser(Integer id);
    public User getUser(Integer id);
    public List<User> listUsers();
    public List<User> getAllPage(int begin, int num);
    public List<User> getNotAll(String name);
}
