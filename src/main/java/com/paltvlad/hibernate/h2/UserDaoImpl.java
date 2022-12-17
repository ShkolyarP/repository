package com.paltvlad.hibernate.h2;

import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class UserDaoImpl implements UserDao {


    private SessionFactoryUtils sfu;

    public UserDaoImpl(SessionFactoryUtils sfu) {
        this.sfu = sfu;
    }

    @Override
    public Optional<User> findById(Long id) {
        try (Session session = sfu.getSession()) {

            session.beginTransaction();
            Optional<User> user = Optional.ofNullable(session.get(User.class, id));
            session.getTransaction().commit();
            return user;
        }
    }

    @Override
    public Optional<User> findByName(String name) {
        try (Session session = sfu.getSession()) {

            session.beginTransaction();
            Optional<User> user = Optional.ofNullable(session
                    .createQuery("select user from User user where user.name=:name", User.class)
                    .setParameter("name", name)
                    .getSingleResult());
            session.getTransaction().commit();
            return user;
        }
    }

    @Override
    public List<User> findAll() {
        try (Session session = sfu.getSession()) {

            session.beginTransaction();

            List<User> users = session.createQuery("select u from User u").getResultList();

            session.getTransaction().commit();
            return users;
        }
    }

    @Override
    public void save(User user) {
        try (Session session = sfu.getSession()) {

            session.beginTransaction();
            session.saveOrUpdate(user);
            session.getTransaction().commit();

        }
    }

    @Override
    public void updateNameById(Long id, String newName) {
        try (Session session = sfu.getSession()) {

            session.beginTransaction();
//            User user = session.get(User.class, id);
//            user.setName(newName);

            session.createQuery("update User u set u.name =:name where u.id= :id")
                    .setParameter("name", newName)
                    .setParameter("id", id)
                    .executeUpdate();

            session.getTransaction().commit();

        }
    }
}
