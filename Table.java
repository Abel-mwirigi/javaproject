public abstract class Table {
    private String typeOfWood;
    private double length;
    private double width;
    private double basePrice=42500;
    private double aboveStandardSize=825;
    private double firstDrawer=2500;
    private double additionalDrawer=2000;
    private double discountRate=0.05;
    private int drawers;

    public abstract double WoodPrice();
    public Table(String typeOfWood,double length,double width,int drawers)
    {   this.typeOfWood = typeOfWood;
        this.length = length;
        this.width = width;
        this.drawers = drawers;
    }   
    public double totalCost() {
    double customSize=((width*length-9600)*aboveStandardSize);
    int drawerCost=(int) (firstDrawer+Math.max(0, drawers-1)*additionalDrawer);

    return basePrice+customSize+WoodPrice()+drawerCost;
    }

    public void displayDetails(int numberOfTables){
      double  discount=(numberOfTables>1)?totalCost()*discountRate:0;
      double total=totalCost()-discount;

        System.out.println("Wood Type: " + typeOfWood);
        System.out.println("Dimensions: " + length +"cm "+ width+ " cm");
        System.out.println("Wood price: Ksh " + WoodPrice());  
        System.out.println("Table Cost: Ksh " + totalCost());
        System.out.println("Discount: Ksh" + discount);
        System.out.println("Drawers: " + drawers);
        System.out.println("Total Cost: Ksh " + total);

    }

}
