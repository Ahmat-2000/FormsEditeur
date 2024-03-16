package model;

public class RectangleModel extends AbstractForm  {
    
    public RectangleModel(int x, int y, int width, int height) {
        super(x, y, width, height);
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
