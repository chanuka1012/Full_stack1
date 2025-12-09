package com.example.demo_Full_Stack_Project.fullstack.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo_Full_Stack_Project.fullstack.model.ClassRoom;

public interface ClassRoomRepo extends MongoRepository<ClassRoom, String>{

    Optional<ClassRoom> findByClassId(String classId);
    List<ClassRoom> findByClassName(String className);
    List<ClassRoom> findByClassTeacherId(String classTeacherId);
    List<ClassRoom> findByAcademicYear(String academicYear);

}
