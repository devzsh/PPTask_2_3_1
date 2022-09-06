package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.model.User;
import web.dao.UserDAO;
import java.util.List;

@Service
public class UserServiceImp implements UserService{

    private final UserDAO userDao;

    public UserServiceImp(UserDAO userDao) {
        this.userDao = userDao;
    }


    @Override
    public List<User> index() {

        return userDao.index();
    }

    @Override
    public User show(int id) {
        return userDao.show(id);
    }

    @Override
    public void save(User user) {
        userDao.save(user);

    }

    @Override
    public void update(User user) {
        userDao.update(user);

    }

    @Override
    public void delete(int id) {
         userDao.delete(id);
    }
}
