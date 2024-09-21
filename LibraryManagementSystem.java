import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManagementSystem {
    private static ArrayList<Book> books = new ArrayList<>();  
    private static ArrayList<LibraryUser> users = new ArrayList<>();  
  
   public static void main(String[] args) {  
    Scanner scanner = new Scanner(System.in);  
  
     // Add some books to the library  
      books.add(new Book(1, "Book1", "Author1"));  
      books.add(new Book(2, "Book2", "Author2"));  
      books.add(new Book(3, "Book3", "Author3"));  
  
      // Add some users to the library  
      users.add(new LibraryUser(1, "User1"));  
      users.add(new LibraryUser(2, "User2"));  
      users.add(new LibraryUser(3, "User3"));  
  
      while (true) {  
        System.out.println("Library Management System");  
        System.out.println("1. Add Book");  
        System.out.println("2. Remove Book");  
        System.out.println("3. Search Book");  
        System.out.println("4. Borrow Book");  
        System.out.println("5. Return Book");  
        System.out.println("6. Exit");  
  
        System.out.print("Enter your choice: ");  
        int choice = scanner.nextInt();  
        scanner.nextLine(); // Consume newline left-over  
  
        switch (choice) {  
           case 1:  
              addBook(scanner);  
              break;  
           case 2:  
              removeBook(scanner);  
              break;  
           case 3:  
              searchBook(scanner);  
              break;  
           case 4:  
              borrowBook(scanner);  
              break;  
           case 5:  
              returnBook(scanner);  
              break;  
           case 6:  
              System.out.println("Exiting...");  
              return;  
           default:  
              System.out.println("Invalid choice. Please try again.");  
        }  
      }  
   }  
  
   private static void addBook(Scanner scanner) {  
      System.out.print("Enter book ID: ");  
      int id = scanner.nextInt();  
      scanner.nextLine(); // Consume newline left-over  
  
      System.out.print("Enter book title: ");  
      String title = scanner.nextLine();  
  
      System.out.print("Enter book author: ");  
      String author = scanner.nextLine();  
  
      books.add(new Book(id, title, author));  
      System.out.println("Book added successfully!");  
  }  
  
   private static void removeBook(Scanner scanner) {  
      System.out.print("Enter book ID to remove: ");  
      int id = scanner.nextInt();  
      scanner.nextLine(); // Consume newline left-over  
  
      for (Book book : books) {  
        if (book.getId() == id) {  
           books.remove(book);  
             System.out.println("Book removed successfully!");  
             return;  
        }  
      }  
       System.out.println("Book not found!");  
   }  
  
   private static void searchBook(Scanner scanner) {  
      System.out.println("Search by:");  
      System.out.println("1. Title");  
      System.out.println("2. Author");  
      System.out.println("3. ID");  
  
      System.out.print("Enter your choice: ");  
      int choice = scanner.nextInt();  
      scanner.nextLine(); // Consume newline left-over  
  
      switch (choice) {  
      case 1:  
       System.out.print("Enter book title: ");  
           String title = scanner.nextLine();  
             for (Book book : books) {  
               if (book.getTitle().equalsIgnoreCase(title)) {  
                  System.out.println("Book found: " + book.getTitle() + " by " + book.getAuthor());  
               return;  
              }  
           }  
          System.out.println("Book not found!");  
           break;  
          case 2:  
            System.out.print("Enter book author: ");  
            String author = scanner.nextLine();  
             for (Book book : books) {  
             if (book.getAuthor().equalsIgnoreCase(author)) {  
                System.out.println("Book found: " + book.getTitle() + " by " + book.getAuthor());  
              return;  
              }  
           }  
           System.out.println("Book not found!");  
           break;  
          case 3:  
           System.out.print("Enter book ID: ");  
           int id = scanner.nextInt();  
           scanner.nextLine(); // Consume newline left-over  
           for (Book book : books) {  
              if (book.getId() == id) {  
                System.out.println("Book found: " + book.getTitle() + " by " + book.getAuthor());  
                return;  
            }  
           }  
           System.out.println("Book not found!");  
           break;  
          default:  
             System.out.println("Invalid choice. Please try again.");  
      }  
   }  
  
   private static void borrowBook(Scanner scanner) {  
     System.out.print("Enter book ID to borrow: ");  
     int id = scanner.nextInt();  
     scanner.nextLine(); // Consume newline left-over  
  
      for (Book book : books) {  
      if (book.getId() == id) {  
         if (book.isBorrowed()) {  
             try {  
                throw new BookAlreadyBorrowedException("Book is already borrowed!");  
            } catch (BookAlreadyBorrowedException e) {  
                System.out.println(e.getMessage());  
            }  
            } else {  
                      book.setBorrowed(true);  
            System.out.println("Book borrowed successfully!");  
               return;  
           }  
          }  
        }  
       try {  
          throw new BookNotFoundException("Book not found!");  
        } catch (BookNotFoundException e) {  
        System.out.println(e.getMessage());  
        }  
   }  
   
     private static void returnBook(Scanner scanner) {  
       System.out.print("Enter book ID to return: ");  
       int id = scanner.nextInt();  
       scanner.nextLine(); // Consume newline left-over  
   
       for (Book book : books) {  
        if (book.getId() == id) {  
           if (!book.isBorrowed()) {  
              System.out.println("Book is not borrowed!");  
           } else {  
              book.setBorrowed(false);  
              System.out.println("Book returned successfully!");  
                return;  
           }  
        }  
       }  
       try {  
          throw new BookNotFoundException("Book not found!");  
        } catch (BookNotFoundException e) {  
          System.out.println(e.getMessage());  
        }  
     }  
    
}
