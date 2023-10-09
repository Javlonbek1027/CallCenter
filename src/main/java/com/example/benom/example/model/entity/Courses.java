package com.example.benom.example.model.entity;

import com.example.benom.example.model.enums.CoursesType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Courses {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column
    @Enumerated(value = EnumType.STRING)
    private CoursesType coursesType;

    @Column
    private String subCourse;

    @Column(name = "education_id")
    private UUID educationId;

    @ManyToOne
    @JoinColumn(name = "education_id", updatable = false, insertable = false)
    private EducationCenter educationCenter;


}
