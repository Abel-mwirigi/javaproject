public abstract class Table {
    private String typeOfWood;
    private double length;
    private double width;
    private double basePrice=42500;
    private double aboveStandardSize=825;
    private double firstDrawer=2500;
    private double additionalDrawer=2000;
    private double discountRate=0.05;
    private int drawers, drawerCost;

    public abstract double WoodPrice();//abstract function
    public Table(String typeOfWood,double length,double width,int drawers)
    {   this.typeOfWood = typeOfWood;
        this.length = length;
        this.width = width;
        this.drawers = drawers;
    }   
    public double totalCost() {
    double customSize=((width*length-9600)*aboveStandardSize);
    drawerCost=(int) (firstDrawer+(drawers-1)*additionalDrawer);//calculating the drawer cost

    return basePrice+customSize+WoodPrice()+drawerCost;
    }

    public void displayDetails(int numberOfTables)//function to display the ouput .has one parameter received from the user
    {
      double  discount=(numberOfTables>=2)?totalCost()*discountRate:0;//shorthand if else to check if the number of tables is more than one
      double total=totalCost()-discount;

       System.out.println("============================= ");

        System.out.println("Wood Type   : " + typeOfWood);
        System.out.println("Dimensions  : " + length +" cm "+ width+ " cm");
        System.out.println("Drawers     : " + drawers);
        System.out.println("No of Tables: " + numberOfTables);
        System.out.println("Drawer cost : Ksh" + drawerCost);
        System.out.println("Wood price  : Ksh " + WoodPrice());  
        System.out.println("Table Cost  : Ksh " + totalCost());
        System.out.println("Discount    : Ksh" + discount);
        System.out.println("Total Cost  : Ksh " + total);

         System.out.println("============================= ");


    }

}
