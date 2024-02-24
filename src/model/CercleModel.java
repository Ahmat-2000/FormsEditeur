package model;

import java.awt.Color;

public class CercleModel extends AbstractForm {
    public CercleModel(int x, int y, int diameter) {
        this(x, y, diameter, Color.BLACK);
    }
    public CercleModel(int x, int y, int diameter, Color color) {
        super(x,y,diameter,diameter,color);
    }
    public CercleModel(int x1,int y1, int x2, int y2) {
        this(x2, y1, 0);
        this.width = this.computeDistance(x1,y1,x2,y2);
    }
    @Override
    public void zoomInWidth(int deltaWidth){
        this.width += deltaWidth;
        this.height += deltaWidth;
        this.fireChange();
    }

    @Override
    public void zoomOutWidth(int deltaWidth){
        this.width -= deltaWidth;
        this.height -= deltaWidth;
        this.fireChange();
    }
    @Override
    public void setWidth(int width) {
        this.width = width;
        this.height = width;
        this.fireChange();
    }
    public String toString(){
        return "Cercle : x = " + x + ", y = " + y + ", diametre = "+ width;
    }
    // @Override
    // public void drawForm(Graphics g) {
    //     g.setColor(Color.red);
    //     g.drawRect(this.getX(),this.getY(),this.getWidth(),this.getWidth());
    //     g.setColor(this.getColor());
    //     g.drawOval(this.getX(),this.getY(),this.getWidth(),this.getWidth());
    //     // g.fillOval(this.getX(),this.getY(),this.getWidth(),this.getWidth());
    // }
}
