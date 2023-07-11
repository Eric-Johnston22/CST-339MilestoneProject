package com.GCU;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class RegisterController {
	
	

	    @GetMapping("/register")
	    public String loadRegister(Model model) {
	    	User user = new User();
	    	model.addAttribute("user", user);
	        return "register";
	    }
	    
	    @PostMapping("/registerUser")
	    public String registerUser() {
	    	return "login";
	    }

	}



