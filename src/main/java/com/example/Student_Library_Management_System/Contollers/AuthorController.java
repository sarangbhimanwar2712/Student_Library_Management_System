package com.example.Student_Library_Management_System.Contollers;

import com.example.Student_Library_Management_System.Models.Author;
import com.example.Student_Library_Management_System.Services.AuthorSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorSerivce authorSerivce ;

    //  '/' is optional
    @PostMapping("/add_Author")
    public String addAuthor(@RequestBody()Author author){
        return authorSerivce.createAuthor(author) ;
    }
}
