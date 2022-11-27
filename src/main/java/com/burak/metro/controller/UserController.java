package com.burak.metro.controller;

import com.burak.metro.dto.UserDTO;
import com.burak.metro.model.User;
import com.burak.metro.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Objects;

/**
 * metro
 * Created by Alexey Burak
 * Nov 2022
 */

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userService;
    private final ModelMapper modelMapper;

    @GetMapping("/registration")
    public String registration(@ModelAttribute("user") UserDTO user) {
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("user") @Valid UserDTO user,
                               BindingResult bindingResult,
                               Model model) {
        if (bindingResult.hasErrors()) {
            return "registration";
        }

        User userDb = this.modelMapper.map(user, User.class);

        if (!userService.addUserToDatabase(userDb)) {
            model.addAttribute("errorMessage", "User with username is already exists");
            return "registration";
        }
        return "redirect:/login";
    }

    @GetMapping("/users/account")
    public String userAccount(Model model,
                              Principal principal) {
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        return "user-account";
    }

    @GetMapping("/users/account/{id}")
    public String userAccountEdit(@PathVariable("id") Long id,
                                  Model model,
                                  Principal principal) {
        if (!Objects.equals(id, userService.getUserByPrincipal(principal).getId()))
            throw new IllegalArgumentException("Access restriction");

        model.addAttribute("user", userService.getUserById(id));
        return "user-account-edit";
    }

    @PostMapping("/users/account/{id}")
    public String userAccountEdit(@PathVariable("id") Long id,
                                  @ModelAttribute("user") @Valid User user,
                                  BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user-account-edit";
        }

        userService.updateUserById(id, user);

        return "redirect:/";
    }

}
