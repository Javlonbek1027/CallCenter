package com.example.benom.example.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EditeEducationProjectionForGetOne {
    private UUID id;
    private String companyName;

    private String phone;

    private String location;

    private String regions;

    private List<CourseDtoEx> courses;
}
