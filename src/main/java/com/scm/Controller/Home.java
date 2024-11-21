package com.scm.Controller;

import com.scm.Helper.Message;
import com.scm.Helper.MessageType;
import com.scm.Service.UserService;
import com.scm.entities.User;
import com.scm.forms.UserForm;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Home {

    @Autowired
    UserService userService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/home")
    public String home(Model model){
        return "Home";
    }


    @GetMapping("/")
    public String home1(){
        return "Home";
    }


    @GetMapping("/about")
    public String about(Model model){
        return "about";
    }

    @GetMapping("/services")
    public String services(Model model){
        System.out.println("I am here!");
        model.addAttribute("name", "Ayush Raghuwanshi");
        return "services";
    }

    @GetMapping("/contact")
    public String contact(Model model){
        model.addAttribute("name", "Ayush Raghuwanshi");
        return "contact";
    }


//    This is Showing login
    @GetMapping("/login")
    public String login(Model model){
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model){
        UserForm userForm = new UserForm();
        model.addAttribute("userForm", userForm);
        return "register";
    }

//  Processing register
    @PostMapping("/do-register")
    public String processRegister(@Valid @ModelAttribute  UserForm userForm, BindingResult bindingResult, HttpSession session){
        if (bindingResult.hasErrors()){
            return "register";
        }
        User user = new User();
       user.setName(userForm.getName());
       user.setEmail(userForm.getEmail());
       user.setPhoneNumber(userForm.getPhoneNumber());
       user.setPassword(userForm.getPassword());
       user.setAbout(userForm.getAbout());
       user.setProfilePic("https://upload.wikimedia.org/wikipedia/commons/thumb/2/2c/Default_pfp.svg/2048px-Default_pfp.svg.png");
       User savedUser = userService.saveUser(user);
        Message message =  Message.builder()
                .content("Registration Successfully")
                .type(MessageType.green)
                .build();
       session.setAttribute("message", message);
        System.out.println("User saved");
        return "redirect:/register";
    }




}
