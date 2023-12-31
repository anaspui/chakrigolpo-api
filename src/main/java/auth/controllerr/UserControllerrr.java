package auth.controllerr;


import auth.service.UserService;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserControllerrr {

    private UserService userService;



    public UserControllerrr(UserService userService) {
        this.userService = userService;
    }

    @InitBinder
    public void intiBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @RequestMapping("/all")
    public String sixth() {
        return "index";
    }
}