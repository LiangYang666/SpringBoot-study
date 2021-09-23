package com.liang.dao;

import com.liang.pojo.Department;
import com.liang.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {
    static private Map<Integer, Employee> employees;

    @Autowired
    private DepartmentDao departmentDao;
    static {
        employees = new HashMap<>();
        employees.put(1, new Employee(1, "AA", "A@qq.com", 1, new Department(1, "技术部")));
        employees.put(2, new Employee(2, "BB", "B@qq.com", 0, new Department(2, "市场部")));
        employees.put(3, new Employee(3, "CC", "C@qq.com", 1, new Department(3, "调研部")));
        employees.put(4, new Employee(4, "DD", "D@qq.com", 0, new Department(4, "后勤部")));
        employees.put(5, new Employee(5, "EE", "E@qq.com", 1, new Department(5, "运营部")));
    }
    private static Integer initId = 6;
    public void addEmployee(Employee employee){
        if (employee.getId()==null){
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employees.put(employee.getId(), employee);
    }
    public Collection<Employee> getAllEmployees(){
        return employees.values();
    }
    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }
    public void deleteEmployeeById(int id){
        employees.remove(id);
    }

}
