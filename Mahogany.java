public class Mahogany extends Table {

    public Mahogany(String typeOfWood, double length, double width, int drawers){
        super("Mahogany",length,width,drawers);
    }
    
    @Override
    public double WoodPrice(){
        return 3000;
    }
}
