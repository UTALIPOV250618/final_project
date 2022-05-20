package com.example.final_project.dto;


import com.example.final_project.model.Course;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppUserResponse {

    private Long id;
    private String name;
    private String lastname;

}
