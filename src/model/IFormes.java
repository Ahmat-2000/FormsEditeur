package model;

import java.awt.Color;
import java.awt.Point;

public interface IFormes {
    public boolean onSurface(Point p);
    //public void resizeForm();    
    public void moveForm(int deltaX,int deltaY);
    public void moveFormX(int deltaX);
    public void moveFormY(int deltaY);
    public void setColor(Color color);
    public Color getColor();
    
}
