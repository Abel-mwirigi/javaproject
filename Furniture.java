public class Furniture extends Tables{
    private String woodType;
    private double woodTypePrice;

    public Furniture(String woodType){
        super(0, 0, 0, 0, 0);
        this.woodType = woodType;
        this.woodTypePrice = woodTypePrices();

    }
    @Override
    double woodPrice(){
       return woodTypePrice;
    }

    public double getWoodTypePrice(){
        return woodTypePrice;
    }
    
    private double woodTypePrices(){
        switch (woodType.toLowerCase()) {
            case "oak":
                return 2015;
            case "mahogany":
                return 3000;
            default:
                return 1.0; // Default multiplier
        }
    }
}
