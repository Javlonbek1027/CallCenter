package com.example.benom.example.model.dto;

import com.example.benom.example.model.enums.Regions;
import com.example.benom.example.model.exaptions.ErrorMessages;
import jakarta.validation.constraints.NotNull;
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
public class EducationDtoForEdite {
    @NotNull(message = "id " + ErrorMessages.SHOULDNT_BE_NULL)
    private UUID id;

    @NotNull(message = "companyName " + ErrorMessages.SHOULDNT_BE_NULL)
    private String companyName;

    @NotNull(message = "phone " + ErrorMessages.SHOULDNT_BE_NULL)
    private String phone;

    @NotNull(message = "location " + ErrorMessages.SHOULDNT_BE_NULL)
    private String location;

    @NotNull(message = "Regions " + ErrorMessages.SHOULDNT_BE_NULL)
    private Regions regions;

    @NotNull(message = "courses " + ErrorMessages.SHOULDNT_BE_NULL)
    private List<CoursesDto> courses;
}
