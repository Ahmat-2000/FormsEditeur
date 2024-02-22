package model;

import java.awt.Graphics;

public interface IForm {
    public boolean onSurface(int x, int y);
    public void moveForm(int deltaX,int deltaY);
    public void moveFormX(int deltaX);
    public void moveFormY(int deltaY);

    public void zoomInWidth(int deltaWidth);
    public void zoomOutWidth(int deltaWidth);
    public void zoomInHeight(int deltaHeight);
    public void zoomoutHeight(int deltaHeight);
    public void drawForm(Graphics g);

    
}
