package com.example.final_project.dto;


import com.example.final_project.model.AppUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseResponse {

    private Long id;
    private String courseName;
    private LocalDate startDate;
    private String appUserName;
}
