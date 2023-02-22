package com.example.Student_Library_Management_System.Services;

import com.example.Student_Library_Management_System.DTOs.BookRequestDto;
import com.example.Student_Library_Management_System.DTOs.BookResponseDto;
import com.example.Student_Library_Management_System.Models.Author;
import com.example.Student_Library_Management_System.Models.Book;
import com.example.Student_Library_Management_System.Repositories.AuthorRepository;
import com.example.Student_Library_Management_System.Repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    AuthorRepository authorRepository ;

    @Autowired
    BookRepository bookRepository ;
    public String addBook(BookRequestDto bookRequestDto){

        //I want to get the autherEntry
        int autherId = bookRequestDto.getAuthorId() ;

        //Now i will be fetching the autherEntity
        Author author = authorRepository.findById(autherId).get() ;

        //Converter
        //We have created this entity so that we can save it into the DB
        Book book = new Book() ;

        //Basic attributes are being from DTO to the Entity Layer
        book.setGenre(bookRequestDto.getGenre());
        book.setIssued(false);
        book.setName(bookRequestDto.getName());
        book.setPages(bookRequestDto.getPages());

        //Setting the foreign key attributes in the child class
        book.setAuthor(author);


        //we need to update the listOfBooks written in the parent class
        List<Book> currentBooksWritten  = author.getBooksWritten() ;
        currentBooksWritten.add(book) ;

        //Now the book is to be saved ,but also author is alsoooo to be saved
        //bcz the author Entity has been updated ... we need to resave / update it
        authorRepository.save(author);

        //.save function works both as save function and as update function

        //bookRepo.save is not required : bcz it will be autocalled by cascading effect

        return "Book Added successfully" ;
    }

    public BookRequestDto getBookById(int bookId){

        BookRequestDto bookRequestDto = new BookRequestDto() ;

        Book book = bookRepository.findById(bookId).get() ;

        bookRequestDto.setAuthorId(book.getAuthor().getId());
        bookRequestDto.setName(book.getName());
        bookRequestDto.setGenre((book.getGenre()));
        bookRequestDto.setPages(book.getPages());

        return bookRequestDto ;
    }
}
