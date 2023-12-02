public class Pine extends Table {

    public Pine(String typeOfWood, double length, double width, int drawers) {
        super("Pine",length,width,drawers);
    }

    @ Override
    public double WoodPrice(){
        return 0;
    }
    
    
}
