package admin.service;

import admin.dao.domain.Employee;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class EmployeeServiceImplTest {
    @Autowired
    EmployeeServiceImpl esi;
    String[] conditions;
    String[] values;
    List<Employee> list;

    void init(){
        conditions = new String[]{"age", "gender"};
        values = new String[]{"32", "Female"};
    }


    @Test
    void findByConditions1() {
        init();
        List<Employee> list = esi.findByConditions(conditions, values);
        for (Employee employee:
                list) {
            assertEquals(32, employee.getAge());
            assertEquals("Female", employee.getGender());
        }
    }
    @Test
    void findByConditions2(){
        conditions = new String[]{"gender", "id"};
        values = new String[]{"Female", "20210002"};
        list = esi.findByConditions(conditions, values);
        for (Employee employee:
                list) {
            assertEquals("12312341235", employee.getTel());
        }
    }

    @Test
    void findByConditions3() {

        conditions = new String[]{"department"};
        values = new String[]{"Soul"};
        list = esi.findByConditions(conditions, values);
        for (Employee employee:
                list) {
            assertEquals("Soul", employee.getDepartment());
        }
    }


}