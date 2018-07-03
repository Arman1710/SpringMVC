package epam.news.dao.impl;

import epam.news.dao.UserDAO;
import epam.news.model.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {


        @Autowired
        private SessionFactory sessionFactory;

        @Override
        public List<User> read() {
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            List<User> userList = session.createCriteria(User.class).list();

            session.getTransaction().commit();
            session.close();

            return userList;
        }

        @Override
        public void update(User user) {
            Session session = sessionFactory.openSession();

            session.beginTransaction();

            session.saveOrUpdate(user);

            session.getTransaction().commit();
            session.close();
        }

        @Override
        public void delete(User user) {
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            session.delete(user);

            session.getTransaction().commit();
            session.close();
        }

        @Override
        public void create(User user) {
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            session.save(user);

            session.getTransaction().commit();
            session.close();
        }

        @Override
        public User getByUserName(String username) {
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            User news = session.get(User.class, username);

            session.getTransaction().commit();
            session.close();

            return news;
        }
}
