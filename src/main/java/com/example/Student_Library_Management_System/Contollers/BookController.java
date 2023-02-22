package com.example.Student_Library_Management_System.Contollers;

import com.example.Student_Library_Management_System.DTOs.BookRequestDto;
import com.example.Student_Library_Management_System.DTOs.BookResponseDto;
import com.example.Student_Library_Management_System.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {


    @Autowired
    BookService bookService ;

    @PostMapping("add_book")
    public String addBook(@RequestBody()BookRequestDto bookRequestDto){
        return bookService.addBook(bookRequestDto) ;
    }

    @GetMapping("get_book")
    public BookRequestDto getBookById(@RequestParam("bookId")int bookId){
        return bookService.getBookById(bookId) ;
    }
}
