package com.example.demo_Full_Stack_Project.fullstack.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo_Full_Stack_Project.fullstack.model.ClassRoom;
import com.example.demo_Full_Stack_Project.fullstack.repo.ClassRoomRepo;

@Service
@Transactional

public class ClassRoomService {

    @Autowired
    private ClassRoomRepo classRoomRepo;

    public ClassRoom createClassRoom(ClassRoom classRoom) {
        return classRoomRepo.save(classRoom);
    }

    public List<ClassRoom> getAllClassRooms() {
        return classRoomRepo.findAll();
    }

    public ClassRoom getClassRoomById(String classId) {
        Optional<ClassRoom> classRoom = classRoomRepo.findByClassId(classId);
        return classRoom.orElse(null);
    }

    public List<ClassRoom> getClassRoomsByClassName(String className) {
        return classRoomRepo.findByClassName(className);
    }

    public List<ClassRoom> getClassRoomsByTeacherId(String teacherId) {
        return classRoomRepo.findByClassTeacherId(teacherId);
    }

    public List<ClassRoom> getClassRoomsByAcademicYear(String academicYear) {
        return classRoomRepo.findByAcademicYear(academicYear);
    }

    public ClassRoom updateClassRoom(ClassRoom classRoom) {
        return classRoomRepo.save(classRoom);
    }

    public boolean deleteClassRoom(String classId) {
        Optional<ClassRoom> classRoom = classRoomRepo.findByClassId(classId);
        if (classRoom.isPresent()) {
            classRoomRepo.delete(classRoom.get());
            return true;
        }
        return false;
    }

}
