package wuhan.vp.userservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wuhan.vp.userservice.dao.UserDao;
import wuhan.vp.userservice.model.User;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    UserDao userDao;


    @Override
    public User getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }

    @Override
    public User userLogin(User user) {
        return userDao.userLogin(user);
    }
}
