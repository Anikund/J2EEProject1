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
       return "hrlogin";
   }

    @PostMapping
    public String processLogin() {
        return "test";
    }
}
