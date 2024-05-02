package com.wiltor.clearsolutions.service;

import com.wiltor.clearsolutions.model.Users;
import com.wiltor.clearsolutions.repo.UsersRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class UsersServiceImp implements UsersService{
    private final UsersRepo repository;


    @Override
    public List<Users> findAllUsers() {
        return repository.findAllUsers();
    }

    @Override
    public List<Users> findAllYear(Integer firstYear, Integer secondYear) {
        return repository.findAllYear(firstYear, secondYear);
    }

    @Override
    public Users saveUser(Users users) {
        return repository.saveUser(users);
    }

    @Override
    public Users updateUser(Users users) {
        return repository.updateUser(users);
    }

    @Override
    public void deleteUser(String email) {
        repository.deleteUser(email);
    }
}
