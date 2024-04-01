package com.sptek.demo.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sptek.demo.user.model.Users;
import com.sptek.demo.user.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value = "") // 2
    public String homePage(Model model) { 
        model.addAttribute("user", new Users()); // 3
        return "makeUser"; // 4
    }

    @RequestMapping(value = "/user")
    public String getPagePerson(Model model) {
        model.addAttribute("user", userService.getAllUsers()); // 5
        return "result"; 
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST) // 6
    public String addPagePerson(@ModelAttribute Users users, Model model) { // 7
        userService.createUser(users); 
        model.addAttribute("user", userService.getAllUsers());
        return "result";
    }

    @RequestMapping(value = "/user/delete/{id}")
    public String deletePagePerson(@PathVariable Long id) { // 8
        userService.deleteUser(id); 
        return "redirect:/user"; // 9
    }

}
