package com.example.benom.example.projection;

import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public interface EducationProjection {
    String getId();
    String getName();
    String getLocation();
    String getPhone();
    @Value(value = "#{@courseRepository.findAllByEducationCenter_IdQuery(target.id)}")
    List<CourseProjection> getCourses();
}
