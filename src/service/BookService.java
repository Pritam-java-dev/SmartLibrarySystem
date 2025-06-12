package service;

import java.util.ArrayList;
import java.util.List;

import model.Book;
import model.Loan;
import model.member;

public class BookService {
    private List<Book> bookList = new ArrayList<>();
    private List<Loan> loanRecord = new ArrayList<>();

    public void addBook(Book book){
        bookList.add(book);
        System.out.println(" Book added successfully. ");
    }

    public void listBooks(){
        for (Book book : bookList) {
            System.out.println(book);
        
        }
    }
    public Book findBookByISBN(String isbn){
        for (Book book : bookList) {
            if(book.getIsbn().equals(isbn)){
                return book;
            }
        }
        return null;
    }
    public void borrowBook(Book book , member member){
        if(book != null && book.isAvailable()){
            book.borrowBook();
            Loan loan = new Loan(book, member);
            member.addLoan(loan);
            loanRecord.add(loan);
            System.out.println("Book borrowed by " + member.getName());
        }else{
             System.out.println("Book not available.");
        }
    }
    public void returnBook(Book book , member member){
        for(Loan loan : member.getLoans()){
            if(loan.getBook().equals(book) && !loan.isReturned()){
                loan.returnBook();
                System.out.println("Book returned by " + member.getName());
                return ;
            }
        }
        System.out.println("No record of this book being borrowed by member.");
    }

}
