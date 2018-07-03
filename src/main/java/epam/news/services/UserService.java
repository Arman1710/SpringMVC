package epam.news.services;

import epam.news.dao.impl.UserDAOImpl;
import epam.news.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    UserDAOImpl userDAOImpl;

    public void createUser (User user) {

    }

    public User getUserByUsername (String username){
        return userDAOImpl.getByUserName(username);
    }
}
