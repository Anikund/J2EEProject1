package admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Slf4j
@Controller
@RequestMapping("/")
public class HRLoginController {
   @GetMapping
   public String showHRLoginForm(Model model){
       log.info("Show login form");
       return "hrlogin2";       //start page
   }

    @PostMapping
    public String processLogin() {
        log.info("Process Login");
        return "test";              //login succeeded
    }
}
