package com.recentro.recentro.services;

import com.recentro.recentro.exceptions.ExistingEmail;
import com.recentro.recentro.models.User;
import com.recentro.recentro.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User save(User user) throws ExistingEmail {
        User emailCondicion = userRepository.findByEmail(user.getEmail());

        if (emailCondicion != null) {
            throw new ExistingEmail();
        }
        return userRepository.save(user);
    }
}
