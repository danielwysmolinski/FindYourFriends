package pl.sda.findyourfriends.controller.view;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sda.findyourfriends.service.UserRegistrationService;
import pl.sda.findyourfriends.users.User;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class RegisterController {

    private final UserRegistrationService userRegistrationService;

    @GetMapping("/signup")
    public String showSignUpForm(Model model) {
        model.addAttribute("user", new User());
        return "add-user";
    }

    @PostMapping(path = "/adduser")
    public String addUser(@Valid @ModelAttribute User user) {
        userRegistrationService.registerUser(user);
        return "redirect:/login";
    }

}
