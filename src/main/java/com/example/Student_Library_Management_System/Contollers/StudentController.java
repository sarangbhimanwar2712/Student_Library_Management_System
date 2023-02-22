package com.example.Student_Library_Management_System.Contollers;

import com.example.Student_Library_Management_System.DTOs.StudentUpdateMobRequestDto;
import com.example.Student_Library_Management_System.Models.Student;
import com.example.Student_Library_Management_System.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {


    @Autowired
    StudentService studentService ;
    @PostMapping("/add")
    public String createStudent (@RequestBody  Student student){
        return studentService.createStudent(student);
    }

    @GetMapping("/get_user")
    public String getNameByEmail(@RequestParam("email")String email){
        return studentService.findNameByEmail(email) ;
    }

    @PutMapping("/update_mob")
    public String updateMob(@RequestBody StudentUpdateMobRequestDto studentUpdateMobRequestDto){
        return studentService.updateMobNo(studentUpdateMobRequestDto) ;
    }

    @GetMapping("/get_user_byId")
    public Student getStudentById (@RequestParam("id")int id){
        return studentService.getStudentById(id) ;
    }
}
