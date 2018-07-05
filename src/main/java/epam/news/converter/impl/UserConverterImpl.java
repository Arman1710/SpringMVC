package epam.news.converter.impl;

import epam.news.converter.UserConverter;
import epam.news.model.dto.UserDTO;
import epam.news.model.entity.User;
import org.springframework.stereotype.Component;


@Component
public class UserConverterImpl implements UserConverter {
    @Override
    public User DTOToEntity(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        return user;
    }

    @Override
    public UserDTO entityToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        userDTO.setRole(user.getRole());
        userDTO.setUserId(user.getUserId());
        return userDTO;
    }
}
