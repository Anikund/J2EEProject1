package admin.controller;

import admin.dao.domain.Employee;
import admin.dao.domain.HR;
import admin.dao.domain.StaffWorkRec;
import admin.service.EmployeeService;
import admin.service.EmployeeServiceImpl;
import admin.service.StaffWorkRecService;
import admin.service.StaffWorkRecServicelmpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.cert.TrustAnchor;
import java.util.Date;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/employee")
public class EmployeeController {
    //injection of service
    private EmployeeServiceImpl employeeService;
    private StaffWorkRecServicelmpl staffWorkRecService;
    @Autowired
    public void setEmployeeService(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }
    @Autowired
    public void setStaffWorkRecService(StaffWorkRecServicelmpl service){
        staffWorkRecService = service;
    }
    @GetMapping("/register")
    public String showRegisterEmployeeForm(Model model) {
        Employee e = new Employee();
        e.setIsOnTheJob(Boolean.TRUE);

        model.addAttribute("employee", e);
        log.info("Get Request to /employee/register");
//        return "EmployeeRegistration";
        return "new_template/RegisterEmployees";
    }


    @PostMapping("/register")
    public String processEmployeeRegistration(@Valid @ModelAttribute("employee") Employee employee,
                                              BindingResult bindingResult,@AuthenticationPrincipal HR hr) {
        if (bindingResult.hasErrors()) {//back to registration form when having errors
            log.info("Error in the form");
//            return "EmployeeRegistration";
            return "new_template/RegisterEmployees";
        }
        //if no errors, create employee
        else {

            employee.setIsOnTheJob(Boolean.TRUE);

            employee.setCurrentCompany(hr.getCompany());

            employee.setInDate(new java.sql.Date(new Date().getTime()));
            employeeService.addEmployee(employee);

            log.info("new employee is added");
//            return "test";
            return "new_template/back";
        }

    }

    @GetMapping("/manage")
    public String showEmployeeManagement(Model model){
        model.addAttribute("allEmployees", employeeService.findAll());
        log.info("Get Request to /employee/manage");
//        return "EmployeeManagement";
        return "new_template/ManageEmployees";
    }

    @GetMapping("/manage/mine")
    public String showHRsEmployeeManagement(Model model, @AuthenticationPrincipal HR hr){
        String[] conditions = {"currentCompany", "isOnTheJob"};
        String[] values = {hr.getCompany(), "true"};
        List<Employee> employees = employeeService.findByConditions(conditions, values);
        model.addAttribute("allEmployees", employees);
        model.addAttribute("selectedId", new String());
//        return "MyEmployeeManagement";
        return "new_template/ManageMyEmployees";
    }

    @PostMapping("/manage/mine/delete")
    public String deleteSelectedEmployee(@ModelAttribute("selectedId") String selectedId
                                         , Model model, @AuthenticationPrincipal HR hr){
        log.info("Id is " + selectedId+", to be deleted");
        Employee selectedEmployee = employeeService.findById((long) Integer.parseInt(selectedId));
        employeeService.delEmployee(selectedEmployee, hr.getId(), hr.getName(), hr.getCompany());

        String[] conditions = {"currentCompany", "isOnTheJob"};
        String[] values = {hr.getCompany(), "true"};
        List<Employee> employees = employeeService.findByConditions(conditions, values);
        model.addAttribute("allEmployees", employees);

//        return "MyEmployeeManagement";
        return "new_template/ManageMyEmployees";
    }

    @PostMapping("/manage/mine/updating")
    public String updateSelectedEmployee(@ModelAttribute("selectedId") String selectedId, Model model){
        log.info("update starts");
        Employee selectedEmployee = employeeService.findById((long) Integer.parseInt(selectedId));
        model.addAttribute("employee", selectedEmployee);
        return "UpdateEmployee";
    }

    @PostMapping("/update")
    public String updateEmployee(@Valid @ModelAttribute("employee") Employee employee,
                                 BindingResult bindingResult,
                                 Model model){
        if (bindingResult.hasErrors()) {//back to registration form when having errors
            model.addAttribute("employee", employee);
            log.info("Error in the form");
            return "UpdateEmployee";
        }
        Employee updatedEmployee = employeeService.findById(employee.getId());
        employeeService.updateEmployeeAge(updatedEmployee, employee.getAge());
        employeeService.updateEmployeeName(updatedEmployee, employee.getName());
        employeeService.updateEmployeeTel(updatedEmployee, employee.getTel());
        employeeService.updateEmployeeGender(updatedEmployee, employee.getGender());
        employeeService.updateEmployeeDepartment(updatedEmployee, employee.getDepartment());
        return "test";
    }

    @PostMapping("/experience")
    public String showExperience(@ModelAttribute("selectedId") String selectedId, Model model){
        if(
                staffWorkRecService.findByEmployeeId((long) Integer.parseInt(selectedId))!=null
        ){
            List<StaffWorkRec> recs = staffWorkRecService.findByEmployeeId((long) Integer.parseInt(selectedId));
            model.addAttribute("allWorkRecords", recs);
        }

        Employee selectedEmployee = employeeService.findById((long) Integer.parseInt(selectedId));
        model.addAttribute("employee", selectedEmployee);
        return "WorkRecords";
    }



}
