package com.example.Student_Library_Management_System.Contollers;

import com.example.Student_Library_Management_System.DTOs.IssueBookRequestDto;
import com.example.Student_Library_Management_System.Services.TransactionSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
public class TransactionContoller {

    @Autowired
    TransactionSerivce transactionSerivce ;

    @PostMapping("/issueBook")
    public String issueBook(@RequestBody IssueBookRequestDto issueBookRequestDto){

        try{
            return transactionSerivce.issueBook(issueBookRequestDto) ;
        }catch (Exception e){
            return e.getMessage() ;
        }
    }

    @GetMapping("/getTxnInfo")
    public String getTransactionEntry (@RequestParam("bookId")int bookId , @RequestParam("cardId")int cardId){
        return transactionSerivce.getTransactions(bookId, cardId) ;
    }
}
