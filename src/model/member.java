package model;

import java.util.ArrayList;
import java.util.List;

public class member extends User {

    private List<Loan> loans = new ArrayList<>();

    public member (String name , String userId , String password){
        super(name, userId, password);
    }
    public void addLoan(Loan loan){
        loans.add(loan);
    }
    public List<Loan> getLoans(){
        return loans;
    }
      @Override
    public void showMenu() {
        System.out.println("\n--- Member Menu ---");
        System.out.println("1. Borrow Book");
        System.out.println("2. Return Book");
        System.out.println("3. View My Loans");
        System.out.println("0. Exit");
    }
   
}
