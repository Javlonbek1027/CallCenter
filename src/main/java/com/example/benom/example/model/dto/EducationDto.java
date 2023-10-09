package com.example.benom.example.model.dto;

import com.example.benom.example.model.enums.Regions;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EducationDto {
    private UUID id;

    private String name;

    private String location;

//    @Pattern(regexp = "^998([378]{2}|(9[013-57-9]))\\d{7}$")
    private String phoneNumber;

    private Regions region;

    private List<CoursesDto> courses;
}
