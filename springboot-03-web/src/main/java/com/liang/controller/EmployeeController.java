package com.liang.controller;

import com.liang.dao.DepartmentDao;
import com.liang.dao.EmployeeDao;
import com.liang.mapper.DepartmentMapper;
import com.liang.mapper.EmployeeMapper;
import com.liang.pojo.Department;
import com.liang.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@Controller
public class EmployeeController {
//    @Autowired
//    EmployeeDao employeeDao;
//    @Autowired
//    DepartmentDao departmentDao;
    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    DepartmentMapper departmentMapper;

    @RequestMapping("/templates/emps")
    public String getEmployees(Model model){
        List<Employee> allEmployees = employeeMapper.getAllEmployees();
        model.addAttribute("emps", allEmployees);
        return "/emps/list";
    }
    @GetMapping("/emp")
    public String toAddPage(Model model){
        List<Department> allDepartments = departmentMapper.getAllDepartments();
        model.addAttribute("departments", allDepartments);
        return "/emps/add";
    }
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        System.out.println("添加一个职工"+employee);
        employeeMapper.addEmployee(employee);
        return "redirect:/templates/emps";
    }
    @GetMapping("/emp/{id}")
    public String toEdit(@PathVariable("id") int id, Model model){
        model.addAttribute("emp",employeeMapper.getEmployeeById(id));
        List<Department> allDepartments = departmentMapper.getAllDepartments();
        model.addAttribute("departments", allDepartments);
        return "/emps/edit";
    }
    @PostMapping("/empEdit")
    public String editEmp(Employee employee){
        System.out.println("===>编辑一个员工");
        System.out.println(employee.toString());
        System.out.println(employee.getDepartment().toString());
        employeeMapper.updateEmployee(employee);

        return "redirect:/templates/emps";
    }
    @GetMapping("/delemp/{id}")
    public String deleteEmp(@PathVariable("id") int id){
        employeeMapper.deleteEmployeeById(id);
        return "redirect:/templates/emps";
    }
//
//    @RequestMapping("/templates/empsmsql")
//    public String mySqlGetEmployees(Model model){
//        Collection<Employee> employees = employeeDao.getAllEmployees();
//        model.addAttribute("emps", employees);
//        return "/emps/list";
//    }

}
