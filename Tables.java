public abstract class Tables {
    abstract double woodPrice();
    private double Area;
    private double width;
    private double length;
    private int numberOfTables;
    private int numberOfDrawers;

    public Tables(double Area, double width, double length, int numberOfTables, int numberOfDrawers){
        this.Area = Area;
        this.width = width;
        this.length = length;
        this.numberOfTables = numberOfTables;
        this.numberOfDrawers = numberOfDrawers;
    }

    void getDetails() {
        System.out.println("Area: " + Area);
        System.out.println("Width: " + width);
        System.out.println("Length: " + length);
        System.out.println("Number of tables: " + numberOfTables);
        System.out.println("Number of drawers: " + numberOfDrawers);
    }
}
