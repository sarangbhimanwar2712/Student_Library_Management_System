package com.example.Student_Library_Management_System.Contollers;

import com.example.Student_Library_Management_System.DTOs.AuthorEntryDto;
import com.example.Student_Library_Management_System.DTOs.AuthorResponseDto;
import com.example.Student_Library_Management_System.Models.Author;
import com.example.Student_Library_Management_System.Services.AuthorSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorSerivce authorSerivce ;

    //  '/' is optional
    @PostMapping("/add")
    public String addAuthor(@RequestBody() AuthorEntryDto authorEntryDto){
        return authorSerivce.createAuthor(authorEntryDto) ;
    }

    @GetMapping("/getAuthor")
    public AuthorResponseDto getAuthor (@RequestParam("authorId") int authorId){
        return authorSerivce.getAuthor(authorId) ;
    }
}
