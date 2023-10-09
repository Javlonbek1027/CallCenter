package com.example.benom.example.controller;

import com.example.benom.example.model.enums.CoursesType;
import com.example.benom.example.model.enums.Regions;
import com.example.benom.example.model.dto.EducationDtoForAdd;
import com.example.benom.example.model.dto.EducationDtoForEdite;
import com.example.benom.example.model.dto.Header;
import com.example.benom.example.service.EducationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor()
public class EducationController {
    private final EducationService educationService;

    @GetMapping("/get/filter")
    public Header<?> getByRegion(@RequestParam Regions region, @RequestParam(required = false) CoursesType courseType ){
        return Header.ok(educationService.filterByRegion(region,courseType));
    }

    @GetMapping("/get/all")
    public Header<?> getAll(){
        return Header.ok(educationService.getAll());
    }

    @PostMapping("/add")
    public Header<?> addEducation(@RequestBody @Valid Header<EducationDtoForAdd> educationDtoForAdd){
        return Header.ok(educationService.add(educationDtoForAdd.getData()));
    }
    @GetMapping("/get/one/{id}")
    public Header<?> getOneById(@PathVariable UUID id) {
        return Header.ok(educationService.getOneById(id));
    }

    @PutMapping("/edite/info")
    public Header<?> editeInfo(@RequestBody @Valid Header<EducationDtoForEdite> educationDtoForEdite ){
        return Header.ok(educationService.editeInfo(educationDtoForEdite.getData()));
    }
    @DeleteMapping("/delete/{id}")
    public Header<?> delete(@PathVariable UUID id){
        return Header.ok(educationService.delete(id));
    }

    @GetMapping("/search")
    public Header<?> search(@RequestParam String educationCenter){
        return Header.ok(educationService.search(educationCenter));
    }
 }