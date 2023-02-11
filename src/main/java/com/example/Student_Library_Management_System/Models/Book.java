package com.example.Student_Library_Management_System.Models;


import com.example.Student_Library_Management_System.Enums.Genre;
import jakarta.persistence.*;

@Entity
@Table(name="book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    private String name ;

    private int pages ;

    @Enumerated(value = EnumType.STRING)
    private Genre genre ;

    //Book is child with restpect to author
    //Setting here the foreign key :Standard 3 steps
    @ManyToOne
    @JoinColumn //add an extra attribute of authorId (parent table primary key) for the foreign key of child table
    private Author author ;//this is the parent entity we are connecting with


    //Book is also child wrt card
    //here one card can have many books transcations
    @ManyToOne
    @JoinColumn
    private Card card ;


    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
