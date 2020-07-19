package pl.sda.findyourfriends.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sda.findyourfriends.repository.UserRepository;
import pl.sda.findyourfriends.service.UserRegistrationService;
import pl.sda.findyourfriends.users.User;

import javax.validation.Valid;

@Controller
public class RegisterController {

    @Autowired
    private UserRegistrationService userRegistrationService;


    @GetMapping("/signup")
    public String showSignUpForm(Model model) {
        model.addAttribute("user", new User());
        return "add-user";
    }

    @PostMapping(path = "/adduser", consumes = {"application/x-www-form-urlencoded"})
    public String addUser(@Valid @ModelAttribute User user) {
        userRegistrationService.registerUser(user);
        return "redirect:/hello";
    }

}
