package com.example.final_project.service;


import com.example.final_project.dto.AppUserRequest;
import com.example.final_project.dto.AppUserResponse;
import com.example.final_project.model.AppUser;
import com.example.final_project.repo.AppUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AppUserService {

    private final AppUserRepository repository;

    public AppUserResponse createUser(AppUserRequest request){
        AppUser appUser = mapToEntity(request);
        repository.save(appUser);
        return viewUserMapEntity(appUser);
    }

    public AppUserResponse getUserById(long id){
        AppUser appUser = repository.findById(id).get();
        return viewUserMapEntity(appUser);
    }

    public void deleteUser(long id){
        AppUser appUser = repository.findById(id).get();
        repository.delete(appUser);
    }

    public AppUserResponse editUser(long id,AppUserRequest request){

        AppUser appUser = repository.findById(id).get();
        editEntity(appUser,request);
        repository.save(appUser);
        return viewUserMapEntity(appUser);
    }


    /** Eger sadece entity return yapsaydik, ozaman kodumuz asagidaki gibi olacakti
     *
     * public List<AppUser> getAllUsers(){
     *     return repository.findAll();
     * }
     *
     * **/

    public List<AppUserResponse> getAllUsers(){
        return viewAllUser(repository.findAll());
    }


    public AppUser mapToEntity(AppUserRequest request){
        AppUser appUser = new AppUser();
        appUser.setName(request.getName());
        appUser.setLastname(request.getLastname());
        return appUser;
    }
    public AppUser editEntity(AppUser appUser,AppUserRequest request){
        appUser.setName(request.getName());
        appUser.setLastname(request.getLastname());
        return appUser;
    }
    public AppUserResponse viewUserMapEntity(AppUser appUser){
        AppUserResponse response = new AppUserResponse();
        response.setId(appUser.getId());
        response.setName(appUser.getName());
        response.setLastname(appUser.getLastname());
        return response;
    }

    public List<AppUserResponse> viewAllUser (List<AppUser> listOfAllUsers){

        List<AppUserResponse> userResponseList = new ArrayList<>();

        for (AppUser getEachMemberFromListOfAllUsers: listOfAllUsers
        ) {
            userResponseList.add(viewUserMapEntity(getEachMemberFromListOfAllUsers));
        }
        return userResponseList;
    }
}
