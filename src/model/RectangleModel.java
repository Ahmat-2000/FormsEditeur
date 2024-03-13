package model;

public class RectangleModel extends AbstractForm  {
    
    public RectangleModel(int x, int y, int width, int height, String color) {
        super(x, y, width, height, color);
    }
    public RectangleModel(int x, int y, int width, int height) {
        this(x, y, width, height, "black");
    }
    
    @Override
    public String getName(){
        return "rectangle";
    }
    @Override
    public void resize(int x,int y){
        this.width  = Math.abs(this.x - x);
        this.height = Math.abs(this.y - y);
        this.fireChange();
    }
}
