class Books{
       
          String title;
          String author;
          int price;
          int pages;
          String publication;
          String edition;
          void showInfo()
          {
              System.out.println(title +" "+ edition + " edition");
              System.out.println("By "+author);
              System.out.println(pages + " pages");
              System.out.println("Price: "+price + " tk");
              System.out.println(publication);
          
          }
          String GetAddress()
          {
        	  return this.toString().split("@")[1];
          }
          
       }

public class Task_02 {
    public static void main(String[] args)
    {
    	
        Books book1  = new Books();
        book1.title = "Java for Beginners ";
        book1.edition = "3rd";
        book1.author = "Prof.David";
        book1.pages = 537;
        book1.price = 299;
        book1.publication = "Easy Coding Publication";       
        book1.showInfo();
        
        System.out.print("\n");
        
        Books book2  = new Books();
        book2.title = "Omega Point ";
        book2.edition = "12th";
        book2.author = "Humayun Ahmed";
        book2.pages = 122;
        book2.price = 128;
        book2.publication = "Shomoy Prokashoni";        
        book2.showInfo();
        
        System.out.print("\n");
        
        Books book3  = new Books();
        book3.title = "Digital Fortress ";
        book3.edition = "5th";
        book3.author = "Dan Brown";
        book3.pages = 356;
        book3.price = 520;
        book3.publication = "St. Marthin Press";        
        book3.showInfo();
        
        String memory1 = book1.GetAddress(); // In 19 line we create GetAdd() method to convert book1 and book2 in a string
        String memory2 = book2.GetAddress(); // In this 50 & 51 Line we are passing the book1 and book2 memory alogation value in a String type variable;  
        String memory3 = book3.GetAddress();
     
        
        System.out.println("Memory Address of Book1:- " +memory1);
        System.out.println("Memory Address of Book2:- " +memory2);
        System.out.println("Memory Address of Book3:- " +memory3);
        
       System.out.println();
       
       System.out.println("After Changing...");
        book1 = book3;
        book1.edition = "1st";
        book3.showInfo();
        String cmemory1 = book1.GetAddress();
        String cmemory3 = book3.GetAddress();
        System.out.println();
        
        System.out.println("Memory Address of Book1:- "+ cmemory1);
        System.out.println("Memory Address of Book2:- " +memory2);
        System.out.println("Memory Address of Book3:- " +cmemory3);
        
    }
}
// So we can see After Changing "book1 = book2" the memory address of book1 & book3 are same.
// Thats why if we make any changes in book1 it's automaticlly change the book3's information.
// Java have no pointer but Java have reference.

