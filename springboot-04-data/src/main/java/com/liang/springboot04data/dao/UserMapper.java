package com.liang.springboot04data.dao;

import com.liang.springboot04data.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    public List<User> getUsers();
    public User getUserById(int id);
    public void deleteUserById(int id);
    public void editUser(User user);
}
