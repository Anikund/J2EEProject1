package admin.controller;

import admin.dao.domain.Employee;
import admin.dao.domain.HR;
import admin.service.CorporationService;
import admin.service.CorporationServiceImpl;
import admin.service.EmployeeServiceImpl;
import admin.service.HRRepositoryUserDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.apache.bcel.util.ThreadLocalAwareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/hr")
public class HRManageController {

    private HRRepositoryUserDetailsService hrservice;
    private CorporationService corporationService;
    @Autowired
    public void setHrservice(HRRepositoryUserDetailsService hrservice) {
        this.hrservice = hrservice;
    }

    @Autowired
    public void setCorporationService(CorporationServiceImpl service){
        this.corporationService = service;
    }
    @GetMapping("/delete")
    public String deletehr(@Valid @ModelAttribute("hr") HR hr){
        hrservice.delHR(hr);
        log.info("Get Request to /hr/delete");
        return "test";
    }


    @GetMapping("/manage")
    public String showHrManagement(Model model){
        model.addAttribute("allhrs", hrservice.findAll());
        log.info("Get Request to /hr/manage");
//        return "HRManagement";
        return "new_template/Managehr";
    }

    @GetMapping("/register")
    public String registerhr(Model model){
        HR hr = new HR();
        hr.setPassword("1111");
        model.addAttribute("hr", hr);
        List<String> allCorps = corporationService.getAllCorporationName();
        model.addAttribute("allCorps", allCorps);
        log.info("Get Request to /hr/register");
        return "HRRegistration";
    }

    @PostMapping("/register")
    public String processHRRegistration(@Valid @ModelAttribute("hr") HR hr,
                                        BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.info("Error in the form");
            return "HRRegistration";
        }
        else {
            hr.setPassword("1111");
            hrservice.addhr(hr);
            log.info("new hr is added");
            return "test";
        }

    }
}
