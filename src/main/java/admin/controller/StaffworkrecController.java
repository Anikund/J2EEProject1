package admin.controller;

import admin.dao.domain.Staffworkrec;
import admin.service.StaffWorkRecServicelmpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.cert.TrustAnchor;

@Slf4j
@Controller
@RequestMapping("/staffworkrec")
public class StaffworkrecController {
    //injection of service
    private StaffWorkRecServicelmpl staffworkrecService;

    @Autowired
    public void setStaffworkrecService(StaffWorkRecServicelmpl staffworkrecService) {
        this.staffworkrecService = staffworkrecService;
    }

    @GetMapping("/register")
    public String showRegisterStaffworkrec(Model model) {
        Staffworkrec e = new Staffworkrec();
        model.addAttribute("staffworkrec", e);
        log.info("Get Request to /staffworkrec/register");
        return "StaffworkrecRegistration";
    }

    @PostMapping("/register")
    public String processEmployeeRegistration(@Valid @ModelAttribute("staffworkrec") Staffworkrec staffworkrec,
                                              BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {//back to registration form when having errors
            log.info("Error in the form");
            return "StaffworkrecRegistration";
        }
        //if no errors, create employee
        else {
            //staffworkrecService.addStaffworkrec(staffworkrec);
            log.info("new staffworkrec is added");
            return "test";
        }

    }

    @GetMapping("/manage")
    public String showStaffworkrecManagement(Model model){
        model.addAttribute("allStaffworkrecs", staffworkrecService.findAll());
        log.info("Get Request to /staffworkrec/manage");
        return "StaffworkrecManagement";
    }
}

