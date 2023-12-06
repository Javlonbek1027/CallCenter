package com.example.benom.example.repository;

import com.example.benom.example.model.entity.EducationCenter;
import com.example.benom.example.model.enums.Regions;
import com.example.benom.example.projection.CourseProjectionAll;
import com.example.benom.example.projection.EducationProjection;
import com.example.benom.example.projection.EducationProjectionForGetOne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EducationRepository extends JpaRepository<EducationCenter, UUID> {
    List<EducationCenter> findAllByRegion(Regions region);

    @Query(value = "select es.id as id, es.name as name , es.location as location , es.phone_number as phone from education_senter as es where es.region = ?1", nativeQuery = true)
    List<EducationProjection> getAllByRegion(Regions region);

    @Query(value = """
            select es.id as id, es.name as name, es.location as location, es.phone_number as phone
            from education_center es
            where es.region = :region
              and (case
                       when :courseType is not null then
                           (:courseType
                               in (select cs.courses_type from courses cs where cs.education_id = es.id))
                       else true end) 
                        """, nativeQuery = true)
    List<EducationProjection> getAllByRegionAndCourseType(String region, String courseType);

    @Query(value = "select distinct ec.id as id, ec.name as name, ec.location as location, ec.phone_number as phone, ec.region as region from education_center ec left join courses c on ec.id = c.education_id",nativeQuery = true)
    List<CourseProjectionAll>getAll();

    @Query(value = "select distinct ec.id as id, ec.name as name, ec.location as location, ec.phone_number as phone, ec.region as region from education_center ec left join courses c on ec.id = c.education_id where ec.id=?1",nativeQuery = true)
    EducationProjectionForGetOne getOneById(UUID id);

    @Query(value = "select distinct ec.id as id, ec.name as name, ec.location as location, ec.phone_number as phone, ec.region as region from education_center ec left join courses c on ec.id = c.education_id where ec.name like %?1%",nativeQuery = true)
    List<CourseProjectionAll> search(String educationName);
    void deleteById(UUID id);
}
