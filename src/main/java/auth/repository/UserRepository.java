package auth.repository;

import auth.domain.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;
import java.util.Queue;

@Repository
public class UserRepository {

    private SessionFactory sessionFactory;

    public UserRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public User save(User user) {
        Session session = sessionFactory.getCurrentSession();
        return (User) session.save(user);

    }

    public void edit(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.update(user);
    }

    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        User user = findById(id);
        session.delete(user);
    }

    public List<User> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query<User> userQuery = session.createQuery("from User", User.class);
        System.out.println(userQuery);
        return userQuery.getResultList();
    }

    public User findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class, id);
    }

    public User findByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class, username);
    }
}