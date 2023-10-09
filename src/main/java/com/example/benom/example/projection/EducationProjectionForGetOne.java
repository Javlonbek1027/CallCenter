package com.example.benom.example.projection;

import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public interface EducationProjectionForGetOne {
    String getId();
    String getName();
    String getLocation();
    String getPhone();
    String getRegion();
    @Value(value = "#{@courseRepository.findAllByEducationCenter_IdForGetOne(target.id)}")
    List<CourseProjectionForGetOne> getCourses();
}
