package web.dao;


import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserDAOImp implements UserDAO {


    @PersistenceContext
    private EntityManager entityManager;

    public List<User> index() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public User show(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    @Transactional
    public void save(User user) {
            entityManager.persist(user);
    }


    @Override
    @Transactional
    public void update(User user) {

        entityManager.merge(user);
    }

    @Override
    @Transactional
    public void delete (int id) {
        User user = show(id);
        entityManager.remove(user);

    }
}
