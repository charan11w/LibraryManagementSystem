public class LibraryUser {
    private int id;  
    private String name;  
  
  public LibraryUser(int id, String name) {  
    this.id = id;  
    this.name = name;  
   }  
  
   public int getId() {  
    return id;  
   }  
  
   public String getName() {  
    return name;  
   }  
}  
  
class BookNotFoundException extends Exception {  
   public BookNotFoundException(String message) {  
    super(message);  
  }      
}
