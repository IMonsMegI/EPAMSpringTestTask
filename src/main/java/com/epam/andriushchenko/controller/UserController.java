package com.epam.andriushchenko.controller;

import com.epam.andriushchenko.model.User;
import com.epam.andriushchenko.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {
    @Inject
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "/loginForm")
    public String getLoginForm() {
        return "login";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public String login(@ModelAttribute User userForm, ModelMap modelMap, HttpServletRequest request) {
        User user = userService.getByLogin(userForm);
        request.getSession().setAttribute("user", user);
        modelMap.addAttribute("user", user);
        return user != null ? "redirect:/" : "login";
    }
}
