package com.icegrayxtt.dao;

import com.icegrayxtt.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Валерий on 14.11.2016.
 */

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }

    @Override
    public void editUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        User existingUser = (User) session.get(User.class, user.getId());
        existingUser.setName(user.getName());
        existingUser.setAge(user.getAge());
        existingUser.setAdmin(user.isAdmin());
        existingUser.setDate(user.getDate());
        session.update(existingUser);
    }

    @Override
    public void deleteUser(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, id);

        if (user != null){
            session.delete(user);
        }
    }

    @Override
    public User getUser(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, id);
        return user;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        Session session = sessionFactory.getCurrentSession();
        List<User> userList = session.createQuery("from User").list();
        return userList;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAllPage(int begin, int num) {
        Session session = sessionFactory.getCurrentSession();
        List<User> users = session.createQuery("from User").list();
        List<User> user_end = new ArrayList<User>();
        if (users.size() <= begin) {
            return users;
        } else if (begin < users.size() && users.size() < (begin + num)) {
            for (int i = begin; i < users.size(); i++)
            {
                user_end.add(users.get(i));
            }
            return user_end;
        } else {
            for (int i = begin; i < begin + num; i++){
                user_end.add(users.get(i));
            }
            return user_end;
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getNotAll(String name) {
        Session session = sessionFactory.getCurrentSession();
        List<User> result = session.createQuery("select e from User e where e.name = :name")
                .setParameter("name", name)
                .list();
        return result;
    }
}
