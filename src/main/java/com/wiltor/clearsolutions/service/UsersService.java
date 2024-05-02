package com.wiltor.clearsolutions.service;

import com.wiltor.clearsolutions.model.Users;

import java.util.List;

public interface UsersService {
    List<Users> findAllUsers();
    List<Users> findAllYear(Integer firstYear, Integer secondYear);
    Users saveUser(Users users);
    Users updateUser(Users users);
    void deleteUser(String email);

}
