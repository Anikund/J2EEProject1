package admin.controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Slf4j
@Controller
@RequestMapping("/ManageMyEmployees")
public class guanliyuangong {
    @GetMapping
    public String ManagerMyEmployees(){
        return "new_template/ManageMyEmployees";
//        return "MyEmployeeManagement";
    }
}
