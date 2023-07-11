package com.JonahBillerbeck;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpSession;

import org.springframework.validation.BindingResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class LoginController {

    // Handler method for GET request to "/login" endpoint
    @GetMapping("/login")
    public String display(Model model) {
        // Add attributes to the model
        model.addAttribute("title", "Login Form");
        model.addAttribute("loginModel", new LoginModel());
        return "login"; // Return the name of the view template
    }


    // Handler method for POST request to "/doLogin" endpoint
    @PostMapping("/dohome")
    public String doLogin(
            @ModelAttribute("loginModel") LoginModel loginModel,
            BindingResult bindingResult,
            HttpSession session
    ) {
        if (bindingResult.hasErrors()) {
            return "login";
        }

        String username = loginModel.getUsername();
        if (username.length() < 3 || username.length() > 20) {
            bindingResult.rejectValue("username", "username.length", "Username length must be between 3 and 20 characters");
            return "login";
        }

        String password = loginModel.getPassword();
        if (password.length() < 8 || password.length() > 20) {
            bindingResult.rejectValue("password", "password.length", "Password length must be between 8 and 20 characters");
            return "login";
        }
        System.out.println("Username: " + loginModel.getUsername());
        System.out.println("Password: " + loginModel.getPassword());
        // Store the login information in the session or authentication context
        session.setAttribute("loggedInUser", loginModel);

        return "home";
    }





    // Handler method for GET request to "/orders" endpoint
    @GetMapping("/orders")
    public String display1(Model model) {
        // Add attributes to the model
        model.addAttribute("title", "My Orders");
        // Add code to populate order list and set it as a model attribute
        return "orders"; // Return the name of the view template
    }
}
