package admin.controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Slf4j
@Controller
@RequestMapping("/ManageEmployees")
public class liulanyuangong {
    @GetMapping
    public String ManageEmployees(Model model){
        return "new_template/ManageEmployees";
    }
}
