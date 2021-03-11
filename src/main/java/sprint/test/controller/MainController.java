package sprint.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sprint.test.entity.Message;
import sprint.test.repository.MessageRepository;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    MessageRepository messageRepository;

    @GetMapping("/main")
    public String getAll(Model model) {
        List<Message> messages = messageRepository.getAll();
        model.addAttribute("messages", messages);
        return "main";
    }

    @PostMapping("/create")
    public String add(@RequestParam String text) {
        Message message = new Message();
        message.setText(text);
        messageRepository.addMessage(message);
        return "redirect:/main";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam String text) {
        messageRepository.delMessage(text);
        return "redirect:/main";
    }
}
