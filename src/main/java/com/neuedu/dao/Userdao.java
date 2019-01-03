package com.neuedu.dao;

import com.neuedu.pojo.User;

import java.util.List;

public interface Userdao {
    public List<User> getUsers();
    int intertone(User user);
    int deleteone(Integer id);
    int deleteandtwo(Integer id,String username);
    User getone(int id);
    int updateone(int id);
}
