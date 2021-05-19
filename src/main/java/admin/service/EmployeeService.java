package admin.service;

import admin.dao.domain.Employee;
import admin.dao.repo.EmployeeRepository;
import lombok.Data;

import java.util.List;

public interface EmployeeService {

    Employee findById(Long id);
    Employee findByTel(String tel);
    List<Employee> findByName(String name);
    List<Employee> findByGender(String gender);
    List<Employee> findByDepartment(String department);
    List<Employee> findByIsOnTheJob(Boolean isOnTheJob);
    List<Employee> findByCurrentCompany(String currentCompany);
    List<Employee> findByAge(Integer age);

    /**
     * find employees with age between lower and upper
     * @param lower
     * @param upper
     * @return a list of employees that satisfy the requirements
     */
    List<Employee> findByAgeBetween(Integer lower, Integer upper);
    List<Employee> findAll();
    Boolean addEmployee(Employee employee);

    /**
     * This should just change the isOnTheJob state and
     * nullify the currentCompany field
     * @param employee
     * @return true/false
     */
    Boolean delEmployee(Employee employee);
    Boolean updateEmployeeName(Employee employee, String newName);
    Boolean updateEmployeeGender(Employee employee,String newGender);
    Boolean updateEmployeeDepartment(Employee employee, String newDepartment);
    Boolean updateEmployeeTel(Employee employee, String newTel);
    Boolean updateEmployeeAge(Employee employee, Integer newAge);

}
