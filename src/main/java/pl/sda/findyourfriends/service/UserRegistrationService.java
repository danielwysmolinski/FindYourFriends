package pl.sda.findyourfriends.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.sda.findyourfriends.repository.UserRepository;
import pl.sda.findyourfriends.users.User;

@Service
public class UserRegistrationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserRegistrationService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(User user) {
        userRepository.save(withEncodedPassword(user));
    }

    private User withEncodedPassword(User user) {
        return new User(user.getUsername(),
                user.getFirstName(),
                user.getLastName(),
                passwordEncoder.encode(user.getPassword()),
                user.getEmail()
        );
    }
}
