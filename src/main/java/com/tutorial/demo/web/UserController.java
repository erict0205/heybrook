package com.tutorial.demo.web;

import com.tutorial.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    private String message = "JSP TEST";

    @RequestMapping("/my-first-page")
    public String greeting(@RequestParam(value = "title", required = false,
            defaultValue = "HeyBrook") String title, Model model) {
        model.addAttribute("name", title);
        return "first-page";
    }

    @GetMapping("/get-userid")
    public String index(Map<String, Object> model) {
        model.put("ID", userService.getUserId());
        return "index";
    }

    @GetMapping("/jsp")
    public String jsp(Map<String, Object> model) {
        model.put("message", this.message);
        return "/WEB_INF/jsp-test";
    }
}
