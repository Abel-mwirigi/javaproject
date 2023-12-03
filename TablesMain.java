import java.util.Scanner;

public class TablesMain {
    public static void main(String[] args) {
        double length, width;
        int drawers;
        String password = "tables";
        String passWord;
        Scanner myInput = new Scanner(System.in);
        System.out.println("Enter Password");
        passWord = myInput.nextLine();

        if (password.compareTo(passWord) == 0) {
            System.out.println("Correct password");
        } else {
            System.out.println("incorrect password!!. Exiting Program");
            System.exit(0);
        }

        System.out.print("Welcome To Antique Furniture Kenya Limited Westlands: \n");
        System.out.print(" We specialize in making custom wooden tables as per your specifications\n");
        System.out.println("A standard table whose area is 9600cm square (80 cm wide and 120cm long) is Kshs 42500 \n Would you like the standard size or custom size? (STANDARD/CUSTOM)");
        String choice = myInput.nextLine();

        switch (choice.toLowerCase()) {
            case "standard":
                length=120;
                width=80;
                break;
            case "custom":
        System.out.println("What dimensions of the table would you like? NOTE , each cm square above the standard size is charged at Kshs 825.");
        System.out.print("Enter table length in cm (should be more than 120cm): ");
            length = myInput.nextDouble();
        System.out.print("Enter table width in cm(should be more than 80cm): ");
            width = myInput.nextDouble();
                break;
            default:
                System.out.println("CHOOSE STANDARD OR CUSTOM SIZE");
                return;
        }
                  
        do 
        { 
        System.out.println("How many drawers would you like added to your table? NOTE The first drawer goes for Ksh 2500 while additional drawers go for Kshs 2000.");
        System.out.println("Enter number of drawers (0-6): ");
        drawers = myInput.nextInt();
            
         if (drawers >6) {
            System.out.println("Invalid input. Please enter 0-6");
         }

        } while (drawers>6);

        System.out.println(" What type of  wood would you like (Mahogany, Oak, Pine): Mahogany has an additional charge of Ksh 3000, for Oak the extra cost will be Ksh 2015. \nThere is no extra charge for using Pine.");
        String woodType = myInput.next().toLowerCase();

        Table newtable;
        switch (woodType.toLowerCase()) {
            case "mahogany":
                newtable = new Mahogany("Mahogany",width, length, drawers);
                break;
            case "oak":
                newtable = new Oak("Oak",width, length, drawers);
                break;
            case "pine":
               newtable = new Pine("Pine",width, length, drawers);
                break;
            default:
                System.out.println("Invalid wood type.");
                return;
        }

        System.out.println("How many tables of the same specification would you like? ");
        int numberOfTables = myInput.nextInt();

        newtable.displayDetails(numberOfTables);
    }

}
