package epam.news.services;

import epam.news.Validator.UserValidator;
import epam.news.converter.impl.UserConverterImpl;
import epam.news.dao.impl.UserDAOImpl;
import epam.news.model.dto.UserDTO;
import epam.news.model.entity.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;


@Service
public class UserService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserConverterImpl userConverterImpl;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    UserDAOImpl userDAOImpl;

    private final static Logger LOGGER = Logger.getLogger(UserService.class);

    public String createUser (UserDTO userDTO, BindingResult bindingResult) {
        LOGGER.trace("creating user");
        User user = userConverterImpl.DTOToEntity(userDTO);
        userValidator.validate(user, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }
        user.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
        userDAOImpl.create(user);
        LOGGER.trace("User is created: " + user);
        return "main";
    }

    public User getUserByUsername (String username){
        return userDAOImpl.getByUserName(username);
    }
}
