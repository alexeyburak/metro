package com.burak.metro.controller;

import com.burak.metro.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * metro
 * Created by Alexey Burak
 * Dec 2022
 */

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasAuthority('ADMIN')")
@RequiredArgsConstructor
public class AdminController {

    private final UserServiceImpl userService;

    @GetMapping("/")
    public String adminPanel(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "admin-panel";
    }

}
