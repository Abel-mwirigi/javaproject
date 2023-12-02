public class Oak extends Table {

    public Oak(String typeOfWood, double length, double width, int drawers) {
        super("Oak",length,width,drawers);
    }

    @ Override
    public double WoodPrice(){
        return 2015;
    }
    
}
