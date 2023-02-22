package com.example.Student_Library_Management_System.Services;

import com.example.Student_Library_Management_System.DTOs.AuthorEntryDto;
import com.example.Student_Library_Management_System.DTOs.AuthorResponseDto;
import com.example.Student_Library_Management_System.DTOs.BookResponseDto;
import com.example.Student_Library_Management_System.Models.Author;
import com.example.Student_Library_Management_System.Models.Book;
import com.example.Student_Library_Management_System.Repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorSerivce {

    @Autowired
    AuthorRepository authorRepository ;

    public String createAuthor(AuthorEntryDto authorEntryDto){

        //Imp step is : in the params : the object of type Dto but
        // the repository interacts only with entities

        //Solution : Convert autherEntryDro ---> Author

        //Create an object of type Author
        Author author = new Author() ;

        //we are setting its attribute so that we can save
        //correct values in the DB
        author.setName(authorEntryDto.getName());
        author.setAge(authorEntryDto.getAge());
        author.setCountry(authorEntryDto.getCountry());
        author.setRating(authorEntryDto.getRating());

        authorRepository.save(author) ;
        return "Author added successfully" ;
    }

    public AuthorResponseDto getAuthor(int authorId){
        Author author = authorRepository.findById(authorId).get() ;
        AuthorResponseDto authorResponseDto = new AuthorResponseDto() ;

        //set its attribute
        //List<Book> changes to----> List<BookResponseDto>
        List<Book> bookList = author.getBooksWritten() ;

        List<BookResponseDto> booksWrittenDto = new ArrayList<>() ;

        for(Book b : bookList){
            BookResponseDto bookResponseDto = new BookResponseDto() ;
            bookResponseDto.setGenre(b.getGenre()) ;
            bookResponseDto.setPages(b.getPages()) ;
            bookResponseDto.setName(b.getName()) ;

            booksWrittenDto.add(bookResponseDto) ;
        }

        //Set attributes for authorResponseDto
        authorResponseDto.setBooksWritten(booksWrittenDto);
        authorResponseDto.setName(author.getName());
        authorResponseDto.setAge(author.getAge());
        authorResponseDto.setRating(author.getRating());

        return authorResponseDto ;
    }
}
