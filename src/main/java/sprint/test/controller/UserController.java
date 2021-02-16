package sprint.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sprint.test.entity.User;
import sprint.test.repository.UserRepository;

import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    public String greeting(Model model) {
        List<User> users = userRepository.getAll();
        model.addAttribute("users", users);
        return "index";
    }

    @PostMapping("/create")
    public String add(@RequestParam String user_name, Model model) {
        User user = new User();
        user.setName(user_name);
        userRepository.addUser(user);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam String del_user, Model model) {
        userRepository.delUser(del_user);
        return "redirect:/";
    }
}
