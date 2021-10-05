package com.liang.mapper;

import com.liang.pojo.Department;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
public interface DepartmentMapper {
    List<Department> getAllDepartments();
}
