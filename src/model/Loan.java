package model;
import java.time.LocalDate;

public class Loan {
    private Book book;
    private member member;
    private LocalDate borrowDate;
    private LocalDate returDate;

    public Loan(Book book , member member ){
        this.book = book;
        this.member = member;
        this.borrowDate = LocalDate.now();
        this.returDate = null;
    }
    public void returnBook(){
        this.returDate = LocalDate.now();
        book.returnBook();
    }
    public boolean isReturned(){
        return returDate != null;
    }
    public Book getBook(){
        return book;
    }
       public String toString() {
        return "Loan{" +
                "Book=" + book.getTitle() +
                ", Member=" + member.getName() +
                ", Borrowed=" + borrowDate +
                ", Returned=" + (returDate != null ? returDate : "Not Returned") +
                '}';
    }

}
