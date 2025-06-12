import model.*;
import service.BookService;
import service.LoginService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookService bookService = new BookService();
        LoginService loginService = new LoginService();

        System.out.println("=== Welcome to Smart Library System ===");
        System.out.print("Enter your User ID: ");
        String userId = scanner.nextLine();

        System.out.print("Enter your Password: ");
        String password = scanner.nextLine();

        User user = loginService.login(userId, password);

        if (user == null) {
            System.out.println("Login failed. Invalid credentials.");
            return;
        }

        System.out.println("Login successful. Welcome, " + user.getName() + "!");

        while (true) {
            user.showMenu();

            if (user instanceof Admin) {
                System.out.print("Choose option (1=Add Book, 2=List Books, 0=Exit): ");
                int option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                    case 1:
                        System.out.print("Title: ");
                        String title = scanner.nextLine();
                        System.out.print("Author: ");
                        String author = scanner.nextLine();
                        System.out.print("ISBN: ");
                        String isbn = scanner.nextLine();
                        bookService.addBook(new Book(title, author, isbn));
                        break;
                    case 2:
                        bookService.listBooks();
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("Invalid option.");
                }

            } else if (user instanceof member) {
                member member = (member) user;
                System.out.print("Choose option (1=Borrow, 2=Return, 3=My Loans, 0=Exit): ");
                int option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                    case 1:
                        bookService.listBooks();
                        System.out.print("Enter ISBN to borrow: ");
                        String isbn = scanner.nextLine();
                        Book book = bookService.findBookByISBN(isbn);
                        bookService.borrowBook(book, member);
                        break;
                    case 2:
                        System.out.print("Enter ISBN to return: ");
                        String returnIsbn = scanner.nextLine();
                        Book returnBook = bookService.findBookByISBN(returnIsbn);
                        bookService.returnBook(returnBook, member);
                        break;
                    case 3:
                        for (Loan loan : member.getLoans()) {
                            System.out.println(loan);
                        }
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("Invalid option.");
                }
            }
        }
    }
}
