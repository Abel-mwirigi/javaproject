public class Table {
    private String typeOfWood;
    private double length;
    private double width;
    private double price, discount;
    private int drawers;

    public Table(String typeOfWood,double length,double width,double price,double discount,int drawers)
    {   this.typeOfWood = typeOfWood;
        this.length = length;
        this.width = width;
        this.price = price;
        this.discount= discount;
        this.drawers = drawers;
    }   
    public String getWood() {
        return typeOfWood;
    }
    public double getLength() {
        return length;
    }
    public double getWidth() {
        return width;
    }
    public double getPrice() {
        return price;
    }
     public double getdiscount() {
        return discount;
    }
    public int getDrawers() {
        return drawers;
    }

    public void displayDetails(){
        System.out.println("Wood Type: " + typeOfWood);
        System.out.println("Length: " + length);
        System.out.println("Width: " + width);  
        System.out.println("Price: " + price);
        System.out.println("Discount: " + discount);
        System.out.println("Drawers: " + drawers);

    }

}
