package pl.sda.findyourfriends.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping(path = "/")
    public String indexHtml(Model model) {
        model.addAttribute("input", new UserSearchDTO());
        return "home";
    }
}
