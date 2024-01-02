package auth.repository;

import auth.domain.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public class UserRepository {

    private SessionFactory sessionFactory;

    public UserRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Object create(User user)throws SQLException, ClassNotFoundException {
        Session session = sessionFactory.getCurrentSession();
        Object sa = session.save(user);
        return sa;

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
        return userQuery.getResultList();
    }

    public User findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class, id);
    }

    public User findByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        Query<User> query = session.createQuery("FROM User WHERE username = :username", User.class);
        query.setParameter("username", username);
        return query.uniqueResult();
    }

}