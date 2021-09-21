package com.liang.controller;

import com.liang.dao.DepartmentDao;
import com.liang.dao.EmployeeDao;
import com.liang.pojo.Department;
import com.liang.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    @RequestMapping("/templates/emps")
    public String getEmployees(Model model){
        Collection<Employee> employees = employeeDao.getAllEmployees();
        model.addAttribute("emps", employees);
        return "/emps/list";
    }

    @GetMapping("/emp")
    public String toAddPage(Model model){
        Collection<Department> allDepartments = departmentDao.getAllDepartments();
        model.addAttribute("departments", allDepartments);
        return "/emps/add";
    }
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        System.out.println("添加一个职工"+employee);
        employeeDao.addEmployee(employee);
        return "redirect:/templates/emps";
    }

}
