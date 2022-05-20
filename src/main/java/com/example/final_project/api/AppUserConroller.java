package com.example.final_project.api;

import com.example.final_project.dto.AppUserRequest;
import com.example.final_project.dto.AppUserResponse;
import com.example.final_project.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/user")
public class AppUserConroller {

    public final AppUserService service;

    @GetMapping()
    public List<AppUserResponse> getAllUsers(){
        return service.getAllUsers();
    }

    @PostMapping("/create")
    public AppUserResponse createUser(@RequestBody AppUserRequest request){
        return service.createUser(request);
    }

    @GetMapping("/{id}")
    public AppUserResponse getUserById(@PathVariable long id){
        return service.getUserById(id);
    }

    @PutMapping("/update/{id}")
    public AppUserResponse getUserById(@PathVariable long id,@RequestBody AppUserRequest request){
        return service.editUser(id,request);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable long id){
        service.deleteUser(id);
    }

}
