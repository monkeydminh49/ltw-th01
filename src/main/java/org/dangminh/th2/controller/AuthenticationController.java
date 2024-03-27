package org.dangminh.th2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;

@Controller
public class AuthenticationController {

    @GetMapping("/login")
    public String login() {
//        attributes.addFlashAttribute("error", false);
        return "login";
    }

    @PostMapping("/login")
    public String login(String username, String password, RedirectAttributes attributes, Model model) {
        if (username.equals("admin") && password.equals("admin")) {
            attributes.addFlashAttribute("fromLogin", true);
            model.addAttribute("fromLogin", true);

            return "redirect:/books";
        } else {
            model.addAttribute("error", true);
            attributes.addFlashAttribute("error", true);
            return "redirect:/login";
        }
    }


}

