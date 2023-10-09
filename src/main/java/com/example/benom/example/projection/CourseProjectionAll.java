package com.example.benom.example.projection;

import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public interface CourseProjectionAll {
    String getId();
    String getName();
    String getLocation();
    String getPhone();
    String getRegion();
    @Value(value = "#{@courseRepository.findAllByEducationCenter_IdQuery(target.id)}")
    List<CourseProjection> getCourses();
}
