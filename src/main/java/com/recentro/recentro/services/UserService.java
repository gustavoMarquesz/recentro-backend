package com.recentro.recentro.services;

import com.recentro.recentro.exceptions.ExistingEmail;
import com.recentro.recentro.models.user.User;
import com.recentro.recentro.models.user.UserDTO;
import com.recentro.recentro.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserDTO save(UserDTO userParam) throws ExistingEmail {
        User emailCondition = userRepository.findByEmail(userParam.getEmail());

        if (emailCondition != null) {
            throw new ExistingEmail();
        }

        User user = new User(userParam);
        User userToBeSaved = userRepository.save(user);
        UserDTO savedUser = new UserDTO(userToBeSaved);
        return savedUser;
    }
}
