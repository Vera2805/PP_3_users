package web.dao;


import org.springframework.stereotype.Component;

import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Component
@Transactional
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Transactional
    public void deleteUser(String mail) {
        User user = entityManager.merge(getUser(mail));
        entityManager.remove(user);
    }

    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Transactional
    public void updateUser(String email, String name, String lastname, String mail) {
        User user = getUser(email);
        user.setName(name);
        user.setLastname(lastname);
        user.setMail(mail);
        entityManager.merge(user);
    }

    @Transactional
    public User getUser(String mail) {
        TypedQuery<User> q = entityManager.createQuery("select u from User u where u.mail = :mail", User.class);
        q.setParameter("mail", mail);
        return q.getResultList().stream().findAny().orElse(null);
    }
}
