package com.example.benom.example.repository;

import com.example.benom.example.model.entity.Courses;
import com.example.benom.example.projection.CourseProjection;
import com.example.benom.example.projection.CourseProjectionForGetOne;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CourseRepository extends JpaRepository<Courses, UUID> {
    @Query(value = "select c.sub_course as subCourse from courses as c where c.education_id=?1",nativeQuery = true)
    List<CourseProjection> findAllByEducationCenter_IdQuery(UUID educationId);
    @Query(value = "select c.courses_type as courseType, c.sub_course as subCourse from courses as c where c.education_id=?1",nativeQuery = true)
    List<CourseProjectionForGetOne> findAllByEducationCenter_IdForGetOne(UUID educationId);

    List<Courses> findAllByEducationCenter_Id(UUID uuid);

    @Transactional
    @Modifying
    void deleteAllByEducationCenter_Id(UUID id);
}

