package pl.sda.findyourfriends.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sda.findyourfriends.repository.UserRepository;
import pl.sda.findyourfriends.users.User;

import javax.validation.Valid;

@Controller

public class RegisterController {


    @Autowired
    private UserRepository userRepository;



        @GetMapping("/signup")
        public String showSignUpForm() {
            return "add-user";
        }

        @PostMapping("/adduser")
        public String addUser(@Valid @RequestBody User user) {


            userRepository.save(user);
            return "redirect:/hello";
        }

    }
