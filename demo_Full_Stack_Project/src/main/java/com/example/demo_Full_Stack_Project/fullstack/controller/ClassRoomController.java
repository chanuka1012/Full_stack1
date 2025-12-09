package com.example.demo_Full_Stack_Project.fullstack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_Full_Stack_Project.fullstack.model.ClassRoom;
import com.example.demo_Full_Stack_Project.fullstack.service.ClassRoomService;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("api/classrooms")

public class ClassRoomController {

    @Autowired
    private ClassRoomService classRoomService;

    @PostMapping("/create")
    public ResponseEntity<ClassRoom> createClassRoom(@RequestBody ClassRoom classRoom) {
        ClassRoom createdClassRoom = classRoomService.createClassRoom(classRoom);
        return ResponseEntity.ok(createdClassRoom);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ClassRoom>> getAllClassRooms() {
        List<ClassRoom> classRooms = classRoomService.getAllClassRooms();
        return ResponseEntity.ok(classRooms);
    }

    @GetMapping("/{classId}")
    public ResponseEntity<ClassRoom> getClassRoomById(@PathVariable String classId) {
        ClassRoom classRoom = classRoomService.getClassRoomById(classId);
        if (classRoom != null) {
            return ResponseEntity.ok(classRoom);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/name/{className}")
    public ResponseEntity<List<ClassRoom>> getClassRoomsByClassName(@PathVariable String className) {
        List<ClassRoom> classRooms = classRoomService.getClassRoomsByClassName(className);
        return ResponseEntity.ok(classRooms);
    }

    @GetMapping("/teacher/{teacherId}")
    public ResponseEntity<List<ClassRoom>> getClassRoomsByTeacherId(@PathVariable String teacherId) {
        List<ClassRoom> classRooms = classRoomService.getClassRoomsByTeacherId(teacherId);
        return ResponseEntity.ok(classRooms);
    }

    @GetMapping("/year/{academicYear}")
    public ResponseEntity<List<ClassRoom>> getClassRoomsByAcademicYear(@PathVariable String academicYear) {
        List<ClassRoom> classRooms = classRoomService.getClassRoomsByAcademicYear(academicYear);
        return ResponseEntity.ok(classRooms);
    }

    @PutMapping("/update")
    public ResponseEntity<ClassRoom> updateClassRoom(@RequestBody ClassRoom classRoom) {
        ClassRoom updatedClassRoom = classRoomService.updateClassRoom(classRoom);
        return ResponseEntity.ok(updatedClassRoom);
    }

    @DeleteMapping("/delete/{classId}")
    public ResponseEntity<Boolean> deleteClassRoom(@PathVariable String classId) {
        boolean isDeleted = classRoomService.deleteClassRoom(classId);
        if (isDeleted) {
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
