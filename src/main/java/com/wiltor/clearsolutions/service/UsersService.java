package com.wiltor.clearsolutions.service;

import com.wiltor.clearsolutions.exceptions.UserNotFoundException;
import com.wiltor.clearsolutions.exceptions.UserUpdateException;
import com.wiltor.clearsolutions.model.Users;

import java.util.List;

public interface UsersService {
    List<Users> findAllUsers();
    List<Users> findAllYear(Integer firstYear, Integer secondYear) throws UserNotFoundException;
    Users saveUser(Users users);
    Users updateUser(Users users) throws UserUpdateException;
    void deleteUser(String email) throws UserNotFoundException;

}
