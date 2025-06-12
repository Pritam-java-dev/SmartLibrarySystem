package model;

public class Admin extends User {
    public Admin (String name , String userId , String password){
        super(name , userId , password);

    }
    @Override
    public void showMenu(){
        System.out.println("\n--- Admin Menu ---");
        System.out.println("1. Add Book");
        System.out.println("2. List Books");
        System.out.println("0. Exit");
    }
}
