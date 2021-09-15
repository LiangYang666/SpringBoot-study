package com.liang.dao;


import com.liang.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class DepartmentDao {
    private static Map<Integer, Department> departments = null;

    static {
        departments = new HashMap<>();
        departments.put(1, new Department(1, "技术部"));
        departments.put(2, new Department(2, "市场部"));
        departments.put(3, new Department(3, "调研部"));
        departments.put(4, new Department(4, "后勤部"));
        departments.put(5, new Department(5, "运营部"));
    }

    public Collection<Department> getAllDepartments(){
        return departments.values();
    }
    public Department getDepartmentById(int id){
        return departments.get(id);
    }


}
