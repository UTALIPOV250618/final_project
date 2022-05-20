package com.example.final_project.model;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "appusers")
@Entity
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastname;
    @OneToMany(mappedBy = "appUser",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Course> courses;
}
