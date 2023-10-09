package com.example.benom.example.service;

import com.example.benom.example.model.dto.req.PaginationRequest;
import com.example.benom.example.model.entity.Courses;
import com.example.benom.example.model.entity.EducationCenter;
import com.example.benom.example.model.enums.CoursesType;
import com.example.benom.example.model.enums.Regions;
import com.example.benom.example.model.dto.*;
import com.example.benom.example.model.exaptions.ErrorCodes;
import com.example.benom.example.model.exaptions.GeneralApiException;
import com.example.benom.example.projection.*;
import com.example.benom.example.repository.CourseRepository;
import com.example.benom.example.repository.EducationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.*;

import static org.springframework.data.support.PageableExecutionUtils.getPage;

@Service
@RequiredArgsConstructor
public class EducationService {
    private final EducationRepository educationRepository;
    private final CourseRepository courseRepository;

    public List<EducationProjection> filterByRegion(Regions region, CoursesType coursesType) {
        String courseTypeStr = null;
        if (Objects.nonNull(coursesType))
            courseTypeStr = coursesType.name();

        return educationRepository.getAllByRegionAndCourseType(region.name(), courseTypeStr);
    }

    public List<CourseProjectionAll> getAll() {
        return educationRepository.getAll();
    }

    public EducationDtoForAdd add(EducationDtoForAdd add) {
        EducationCenter educationCenter = new EducationCenter();
        educationCenter.setName(add.getCompanyName());
        educationCenter.setLocation(add.getLocation());
        educationCenter.setRegion(add.getRegions());
        educationCenter.setPhoneNumber(add.getPhone());
        var education = educationRepository.save(educationCenter);
        List<Courses> courses = new ArrayList<>();
        for (CoursesDto cours : add.getCourses()) {
            for (String s : cours.getSubCourse()) {
                Courses courses1 = new Courses();
                courses1.setEducationId(education.getId());
                courses1.setCoursesType(cours.getCoursesType());
                courses1.setSubCourse(s);
                courses.add(courses1);
            }
        }
        courseRepository.saveAll(courses);
        return add;
    }

    public EditeEducationProjectionForGetOne getOneById(UUID id) {
        EducationProjectionForGetOne oneById = educationRepository.getOneById(id);
        EditeEducationProjectionForGetOne response = new EditeEducationProjectionForGetOne();
        response.setId(id);
        List<CourseDtoEx> courseDtoExes = new ArrayList<>();
        response.setLocation(oneById.getLocation());
        response.setPhone(oneById.getPhone());
        response.setRegions(oneById.getRegion());
        response.setCompanyName(oneById.getName());
        Map<String, String> map = new HashMap<>();
        if (oneById.getCourses() != null) {
            for (CourseProjectionForGetOne cours : oneById.getCourses()) {
                CourseDtoEx dtoEx = new CourseDtoEx();
                if (!map.containsKey(cours.getCourseType())) {
                    dtoEx.setCoursesType(cours.getCourseType());
                    dtoEx.getSubCourse().add(cours.getSubCourse());
                    map.put(cours.getCourseType(), cours.getSubCourse());
                    courseDtoExes.add(dtoEx);
                } else {
                    for (CourseDtoEx courseDtoEx : courseDtoExes) {
                        if (courseDtoEx.getCoursesType().equals(cours.getCourseType())) {
                            courseDtoEx.getSubCourse().add(cours.getSubCourse());
                        }
                    }
                }

            }

        }
        response.setCourses(courseDtoExes);
        return response;
    }

    public EducationDtoForEdite editeInfo(EducationDtoForEdite educationDtoForEdite) {
        var educationCenter = educationRepository.findById(educationDtoForEdite.getId()).orElseThrow(GeneralApiException.throwEx("education_not_found", ErrorCodes.ERR_NOT_FOUND));
        UUID id = educationCenter.getId();
        educationCenter.setName(educationDtoForEdite.getCompanyName());
        educationCenter.setLocation(educationDtoForEdite.getLocation());
        educationCenter.setRegion(educationDtoForEdite.getRegions());
        educationCenter.setPhoneNumber(educationDtoForEdite.getPhone());
        var education = educationRepository.save(educationCenter);
        List<Courses> courses = new ArrayList<>();
        List<Courses> allByEducationCenterId = courseRepository.findAllByEducationCenter_Id(id);
        if (!allByEducationCenterId.isEmpty()){
            courseRepository.deleteAllByEducationCenter_Id(id);
        }
        for (CoursesDto cours : educationDtoForEdite.getCourses()) {
            for (String s : cours.getSubCourse()) {
                Courses courses1 = new Courses();
                courses1.setEducationId(education.getId());
                courses1.setCoursesType(cours.getCoursesType());
                courses1.setSubCourse(s);
                courses.add(courses1);
            }
        }
        courseRepository.saveAll(courses);
        return educationDtoForEdite;
    }

    public List<CourseProjectionAll> search(String educationName){
        return educationRepository.search(educationName);
    }
    public String delete(UUID id){
        List<Courses> allByEducationCenterId = courseRepository.findAllByEducationCenter_Id(id);
        if (!allByEducationCenterId.isEmpty()){
            courseRepository.deleteAllByEducationCenter_Id(id);
        }
        educationRepository.deleteById(id);
        return "SUCCESSFULLY DELETED";
    }
}