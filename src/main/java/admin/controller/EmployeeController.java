package admin.controller;

import admin.dao.domain.Employee;
import admin.service.EmployeeService;
import admin.service.EmployeeServiceImpl;
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
@RequestMapping("/employee")
public class EmployeeController {
    //injection of service
    private EmployeeServiceImpl employeeService;

    @Autowired
    public void setEmployeeService(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/register")
    public String showRegisterEmployeeForm(Model model) {
        Employee e = new Employee();
        e.setIsOnTheJob(Boolean.TRUE);
        model.addAttribute("employee", e);
        log.info("Get Request to /employee/register");
        return "EmployeeRegistration";
    }

    @PostMapping("/register")
    public String processEmployeeRegistration(@Valid @ModelAttribute("employee") Employee employee,
                                              BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {//back to registration form when having errors
            log.info("Error in the form");
            return "EmployeeRegistration";
        }
        //if no errors, create employee
        else {

            employee.setIsOnTheJob(Boolean.TRUE);
            employeeService.addEmployee(employee);
            log.info("new employee is added");
            return "test";
        }

    }

    @GetMapping("/manage")
    public String showEmployeeManagement(Model model){
        model.addAttribute("allEmployees", employeeService.findAll());
        log.info("Get Request to /employee/manage");
        return "EmployeeManagement";
    }
}
