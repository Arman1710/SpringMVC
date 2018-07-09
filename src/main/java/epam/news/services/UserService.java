package epam.news.services;

import epam.news.converter.impl.UserConverterImpl;
import epam.news.dao.impl.UserDAOImpl;
import epam.news.model.dto.UserDTO;
import epam.news.model.entity.Role;
import epam.news.model.entity.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserConverterImpl userConverterImpl;

    @Autowired
    UserService userService;

    @Autowired
    UserDAOImpl userDAOImpl;

    private final static Logger LOGGER = Logger.getLogger(UserService.class);

    public void createUser(UserDTO userDTO) {
        LOGGER.trace("creating user");
        Role role = new Role();
        role.setRoleName("ROLE_USER");
        role.setRoleId(2L);
        User user = userConverterImpl.DTOToEntity(userDTO);
        user.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
        user.setRole(role);
        userDAOImpl.create(user);
        LOGGER.trace("User is created: " + user);
    }

    public User getUserByUsername(String username) {
        return userDAOImpl.getByUserName(username);
    }
}
