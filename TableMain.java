import java.util.Scanner;

public class TableMain {
    public static void main(String[] args){
        String password ="tables";
        String passWord;
        Scanner mypass= new Scanner(System.in);
        System.out.println("Enter Password");
        passWord=mypass.nextLine();

        if (password.compareTo(passWord)==0){
            System.out.println("Correct password");        
       }
       else {
            System.out.println("incorrect password you connot use the system");
       }
    }
    
}
