package pl.sda.findyourfriends.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.sda.findyourfriends.repository.UserRepository;
import pl.sda.findyourfriends.users.User;

@Controller         //Controller ma obsługiwać dane przychodzące ze strony web aplikacji
@RequestMapping(path = "/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping(path = "/add")
    public @ResponseBody String addNewUser (@RequestParam String firstName, @RequestParam String lastName,
                                            @RequestParam String email) {

        //ZAPIS DO BAZY
        // Zapis nowego użytkownika po firstName, lastName, email do userRepository
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        userRepository.save(user);
        return "Saved";
    }

    //ODCZYT Z BAZY ??? na razie odczytuje wszystkich użytkowników
    @GetMapping(path = "/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        //ta metoda zwraca wszystkich uzytkowników z userRepository
        return userRepository.findAll();
    }
}
