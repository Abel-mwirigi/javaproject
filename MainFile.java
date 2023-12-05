import java.util.Scanner;

public class MainFile {
    public static void main(String[] args) {


        double basePrice = 42500;
        double additionalArea = 825;
        double drawerCharge;
        double Area;
        double totalCost;
        double discount;
        double totalCostTables;

        try (Scanner myInputs = new Scanner(System.in)) {
            String woodType;
            double width;
            double length;
            int numberOfTables;
            int numberOfDrawers;


            System.out.print("Enter the type of wood you want used: ");
            woodType = myInputs.nextLine();

            Furniture furniture = new Furniture(woodType);

            System.out.print("Enter table width (in cm): ");
            width = myInputs.nextDouble();

            System.out.print("Enter table length (in cm): ");
            length = myInputs.nextDouble();

            System.out.print("Enter the number of tables you need: ");
            numberOfTables = myInputs.nextInt();
            
            System.out.print("Enter the number of drawers: ");
            numberOfDrawers = myInputs.nextInt();

            Area = width * length;
            
            drawerCharge = (numberOfDrawers > 0) ? 2500 + (numberOfDrawers - 1) * 2000 : 0;

            totalCost = basePrice + (Area - 9600) * additionalArea + drawerCharge + furniture.getWoodTypePrice();

            if (numberOfTables > 1) {
                discount = totalCost * 0.05;
                totalCost -= discount;
            }

            totalCostTables  = totalCost * numberOfTables;
        }

        System.out.println(totalCostTables);
    }
}
