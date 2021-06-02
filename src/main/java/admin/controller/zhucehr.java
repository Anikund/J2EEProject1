package admin.controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Slf4j
@Controller
@RequestMapping("/Registerhr")
public class zhucehr {
    @GetMapping
    public String Registerhr(){
        return "new_template/Registerhr";
    }
}
