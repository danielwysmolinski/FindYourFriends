package pl.sda.findyourfriends.controller.view;

import lombok.AllArgsConstructor;
import org.dom4j.rule.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.sda.findyourfriends.service.UserSearchService;
import pl.sda.findyourfriends.users.User;

import java.util.Optional;

@AllArgsConstructor
@Controller
public class SearchController {
    UserSearchService userSearchService;
    @RequestMapping(path = "/search", method = RequestMethod.POST)
    public String home(@ModelAttribute UserSearchDTO userSearchDTO, Model model) {
       Optional<User>  foundUser = userSearchService.findByUserName(userSearchDTO.getQuery());
       if (foundUser.isPresent()){
           model.addAttribute("foundUser", foundUser.get());
        }
       model.addAttribute("input", userSearchDTO);
        return "home";
    }
}
