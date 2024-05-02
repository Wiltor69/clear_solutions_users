package com.wiltor.clearsolutions.repo;

import com.wiltor.clearsolutions.model.Users;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Repository
public class UsersRepo {
    private final List<Users> USERS = new ArrayList<>();

    public List<Users> findAllUsers(){
        return USERS;
    }

    public List<Users> findAllYear(Integer firstYear, Integer secondYear){
        return USERS.stream()
                .filter(element->element.getAge()>=firstYear && element.getAge()<=secondYear)
                .collect(Collectors.toList());
    }

    public Users saveUser(Users user){
        if (user.getAge()>=18){
            USERS.add(user);
            return user;
        }else {
            return null;
        }
    }

    public Users findByEmail(String email) {
        return USERS.stream()
                .filter(element -> element.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }

    public Users updateUser(Users user) {
        var studentIndex = IntStream.range(0, USERS.size())
                .filter(index -> USERS.get(index).getEmail().equals(user.getEmail()))
                .findFirst()
                .orElse(-1);
        if (studentIndex > -1) {
            USERS.set(studentIndex, user);
            return user;
        }
        return null;
    }

    public void deleteUser(String email){
        var user = findByEmail(email);
        if (user!= null){
            USERS.remove(user);
        }

    }
}
