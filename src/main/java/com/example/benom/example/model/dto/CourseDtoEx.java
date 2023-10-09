package com.example.benom.example.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class CourseDtoEx {
    private String coursesType;

    private List<String> subCourse= new ArrayList<>();

}
