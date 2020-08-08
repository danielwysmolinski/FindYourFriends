package pl.sda.findyourfriends.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sda.findyourfriends.repository.UserRepository;
import pl.sda.findyourfriends.users.User;

import java.util.Optional;

@AllArgsConstructor
@Service
public class UserSearchService {

    UserRepository userRepository;
    public Optional <User> findByUserName(String query) {
        return userRepository.findByUsername(query);
    }
}
