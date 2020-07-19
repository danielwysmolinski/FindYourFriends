package pl.sda.findyourfriends.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.findyourfriends.repository.UserRepository;
import pl.sda.findyourfriends.users.User;

import java.util.List;

@RestController         //Controller ma obsługiwać dane przychodzące ze strony web aplikacji
@RequestMapping(path = "/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    //ODCZYT Z BAZY ??? na razie odczytuje wszystkich użytkowników
    @GetMapping(path = "/all")
    public List<User> getAllUsers() {
        //ta metoda zwraca wszystkich uzytkowników z userRepository
        return userRepository.findAll();
    }
}
