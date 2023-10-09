package com.example.benom.example.model.dto;

import com.example.benom.example.model.enums.CoursesType;
import com.example.benom.example.model.exaptions.ErrorMessages;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CoursesDto {

    @NotNull(message = "courseType " + ErrorMessages.SHOULDNT_BE_NULL)
    private CoursesType coursesType;

    private List<String> subCourse;
}
