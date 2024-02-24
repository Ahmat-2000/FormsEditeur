package model;

import java.awt.Color;

public class RectangleModel extends AbstractForm  {
    
    public RectangleModel(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);
    }
    public RectangleModel(int x, int y, int width, int height) {
        this(x, y, width, height, Color.BLACK);
    }
    
    public String toString(){
        return "Rectangle : x = " + x + ", y = " + y + ", endPointX = "+ (x+width)+ ", endPointX = "+ (y+height);
    }
    // @Override
    // public void drawForm(Graphics g) {
    //     g.setColor(this.getColor());
    //     g.drawRect(this.getX(),this.getY(),this.getWidth(),this.getHeight());
    //     // g.fillRect(this.getX(),this.getY(),this.getWith(),this.getHeight());
    // }
}
