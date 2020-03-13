package com.boots.controller;

import com.boots.repository.RoleRepository;
import com.boots.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleRepository repo;

    @GetMapping("/main")
    public String userList(Model model){
        model.addAttribute("allUsers", userService.allUsers());
        model.addAttribute("allRights", repo.findAll());
        return "main";
    }
}
