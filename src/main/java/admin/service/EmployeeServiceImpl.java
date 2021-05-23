package admin.service;

import admin.dao.domain.Employee;
import admin.dao.repo.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {
    //auto injection
    private EmployeeRepository employeeRepo;
    @Autowired
    private void setEmployeeRepository(EmployeeRepository employeeRepo){
        this.employeeRepo = employeeRepo;
    }

    @Override
    public Employee findById(Long id) {
        return employeeRepo.getById(id);
    }

    @Override
    public Employee findByTel(String tel) {
        return employeeRepo.findByTel(tel);
    }

    @Override
    public List<Employee> findByName(String name) {
        return employeeRepo.findByName(name);
    }


    @Override
    public List<Employee> findByGender(String gender) {
        return employeeRepo.findByGender(gender);
    }

    @Override
    public List<Employee> findByDepartment(String department) {
        return employeeRepo.findByDepartment(department);
    }

    @Override
    public List<Employee> findByIsOnTheJob(Boolean isOnTheJob) {
        return employeeRepo.findByIsOnTheJob(isOnTheJob);
    }

    @Override
    public List<Employee> findByCurrentCompany(String currentCompany) {
        return employeeRepo.findByCurrentCompany(currentCompany);
    }

    @Override
    public List<Employee> findByAge(Integer age) {
        return employeeRepo.findByAge(age);
    }

    @Override
    public List<Employee> findByAgeBetween(Integer lower, Integer upper) {
        return employeeRepo.findByAgeBetween(lower, upper);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepo.findAll();
    }

    @Override
    public List<Employee> findByConditions(String[] conditions, String[] values) {
        List<Employee> result = this.findAll();
        int i = 0;//index for updateValues
        for (String cond : conditions) {
            switch (cond) {
                case "name":
                    result.retainAll(this.findByName(values[i]));i++;break;
                case "gender":
                    result.retainAll(this.findByGender(values[i]));i++;break;
                case "tel":
                    return Arrays.asList(this.findByTel(values[i]));
                case "age":
                    result.retainAll(this.findByAge(Integer.parseInt(values[i])));i++;break;
                case "department":
                    result.retainAll(this.findByDepartment(values[i]));i++;break;
                case "isOnTheJob":
                    result.retainAll(this.findByIsOnTheJob(Boolean.parseBoolean(values[i])));i++;break;
                case "currentCompany":
                    result.retainAll(this.findByCurrentCompany(values[i]));i++;break;
                case "id":
                    return Arrays.asList(this.findById(Long.parseLong(values[i])));
            }
        }
        return result;
    }

    @Override
    public Boolean addEmployee(Employee employee) {
        employeeRepo.save(employee);
        return Boolean.TRUE;
    }


    @Override
    public Boolean delEmployee(Employee employee) {
        employee.setIsOnTheJob(Boolean.FALSE);
        employee.setCurrentCompany(null);
        employeeRepo.save(employee);
        return Boolean.TRUE;
    }

    @Override
    public Boolean updateEmployeeName(Employee employee, String newName) {
        employee.setName(newName);
        employeeRepo.save(employee);
        return Boolean.TRUE;
    }

    @Override
    public Boolean updateEmployeeGender(Employee employee, String newGender) {
        employee.setGender(newGender);
        employeeRepo.save(employee);
        return Boolean.TRUE;
    }

    @Override
    public Boolean updateEmployeeDepartment(Employee employee, String newDepartment) {
        employee.setDepartment(newDepartment);
        employeeRepo.save(employee);
        return Boolean.TRUE;
    }

    @Override
    public Boolean updateEmployeeTel(Employee employee, String newTel) {
        employee.setTel(newTel);
        employeeRepo.save(employee);
        return Boolean.TRUE;
    }

    @Override
    public Boolean updateEmployeeAge(Employee employee, Integer newAge) {
        employee.setAge(newAge);
        employeeRepo.save(employee);
        return Boolean.TRUE;
    }
}
