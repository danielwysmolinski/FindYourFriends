package pl.sda.findyourfriends.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.sda.findyourfriends.repository.UserRepository;
import pl.sda.findyourfriends.users.User;

import java.util.List;

@RestController         //Controller ma obsługiwać dane przychodzące ze strony web aplikacji
@RequestMapping(path = "/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping(path = "/add")
    public User addNewUser (@RequestBody String firstName, @RequestBody String lastName,
                                            @RequestBody String email) {

        //ZAPIS DO BAZY
        // Zapis nowego użytkownika po firstName, lastName, email do userRepository
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        return userRepository.save(user);

    }

    //ODCZYT Z BAZY ??? na razie odczytuje wszystkich użytkowników
    @GetMapping(path = "/all")
    public List<User> getAllUsers() {
        //ta metoda zwraca wszystkich uzytkowników z userRepository
        return userRepository.findAll();
    }
}
