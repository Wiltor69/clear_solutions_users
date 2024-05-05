package com.wiltor.clearsolutions.controller;



import com.wiltor.clearsolutions.exceptions.UserNotFoundException;
import com.wiltor.clearsolutions.exceptions.UserUpdateException;
import com.wiltor.clearsolutions.model.Users;
import com.wiltor.clearsolutions.service.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class UsersController {
    private final UsersService service;

    @GetMapping("/users")
    public List<Users>findAllUsers(){
        return service.findAllUsers();
    }
    @GetMapping("/users/{x}/{y}")
    public List<Users>findAllYear(@PathVariable Integer x, @PathVariable Integer y) throws UserNotFoundException {
        return service.findAllYear(x,y);
    }
    @PostMapping("/sign")
    public String saveUser(@RequestBody Users user){
        service.saveUser(user);
        if(user.getAge()>=18) {
            return "Student successfully saved";
        } else {
            return "You are too young";
        }
    }
    @PutMapping("/users/update")
    public Users updateUser(@RequestBody Users user) throws UserUpdateException {
        return service.updateUser(user);
    }
    @DeleteMapping("/users/delete/{email}")
    public void deleteUser(@PathVariable String email) throws UserNotFoundException{
        service.deleteUser(email);
    }



}
