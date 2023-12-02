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
          System.out.print(
                "A standard table whose area is 9600cm square (80 cm wide and 120cm long) is Kshs 42500 \n ");
            System.out.println(
                    "What dimensions of the table would you like? NOTE , each cm square above the standard size is charged at Kshs 825.");
            System.out.print("Enter table length in cm: ");
            length = myInput.nextDouble();
            System.out.print("Enter table width in cm: ");
            width = myInput.nextDouble();
      

        System.out.println("How many drawers would you like added to your table? NOTE The first drawer goes for Ksh 2500 while additional drawers go for Kshs 2000.");
        System.out.println("Enter number of drawers (0-6): ");
        drawers = myInput.nextInt();
        System.out.println(" What type of  wood would you like (Mahogany, Oak, Pine): Mahogany has an additional charge of Ksh 3000, for Oak the extra cost will be Ksh 2015. \nThere is no extra charge for using Pine.");
        String woodType = myInput.next().toLowerCase();

        Table table;
        switch (woodType.toLowerCase()) {
            case "mahogany":
                table = new Mahogany("",width, length, drawers);
                break;
            case "oak":
                table = new Oak("",width, length, drawers);
                break;
            case "pine":
                table = new Pine("",width, length, drawers);
                break;
            default:
                System.out.println("Invalid wood type. Exiting program.");
                return;
        }

        System.out.print("Enter the number of tables: ");
        int numberOfTables = myInput.nextInt();
        table.displayDetails(numberOfTables);
    }

}
