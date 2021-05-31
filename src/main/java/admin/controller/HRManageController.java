package admin.controller;

import admin.service.EmployeeServiceImpl;
import admin.service.HRRepositoryUserDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.apache.bcel.util.ThreadLocalAwareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/hr")
public class HRManageController {

    private HRRepositoryUserDetailsService hrservice;

    @Autowired
    public void setHrservice(HRRepositoryUserDetailsService hrservice) {
        this.hrservice = hrservice;
    }


    @GetMapping("/manage")
    public String showHrManagement(Model model){
        model.addAttribute("allhrs", hrservice.findAll());
        log.info("Get Request to /hr/manage");
        return "HRManagement";
    }

}
