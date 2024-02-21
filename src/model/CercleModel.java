package model;

import java.awt.Color;
import java.awt.Point;

import model.observerPaterne.AbstractListenableModel;

public class CercleModel extends AbstractListenableModel implements IFormes {
    
    private int x , y , rayon;
    private Color color;
    public CercleModel(int x, int y, int rayon) {
        this(x, y, rayon, Color.BLACK);
    }
    public CercleModel(int x, int y, int rayon, Color color) {
        super();
        this.x = x;
        this.y = y;
        this.rayon = rayon;
        this.color = color;
    }

    // need work
    public CercleModel(Point p1, Point p2) {
        this.rayon = (int) Math.sqrt(this.computeDistance(p1, p2));
        this.x = (int)(p1.getX() + this.rayon/2);
        this.y = (int)(p1.getY() + this.rayon/2);
        this.color = Color.BLACK;
    }
    @Override
    public void setColor(Color color) {
        this.color = color;
        this.fireChange();
    }

    @Override
    public Color getColor() {
        return this.color;
    }

    @Override
    public void moveFormX(int deltaX) {
        this.x += deltaX;
        this.fireChange();
    }

    @Override
    public void moveFormY(int deltaY) {
       this.y += y;
       this.fireChange();
    }
    private double computeDistance(Point p1,Point p2){
        return Math.pow((p1.getX() - p2.getX()), 2) + Math.pow((p1.getY() - p1.getY()), 2);
    }
    @Override
    public boolean onSurface(Point p) {
        return this.computeDistance(new Point(this.x,this.y), p) <= Math.pow(this.rayon, 2);
    }
    public void zoomIn(int deltaRayon){
        this.rayon += deltaRayon;
        this.fireChange();
    }
    public void zoomOut(int deltaRayon){
        this.rayon -= deltaRayon;
        this.fireChange();
    }

    @Override
    public void moveForm(int deltaX, int deltaY) {
        this.x += deltaX;
        this.y += deltaY;
        this.fireChange();
    }
     
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
        this.fireChange();
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
        this.fireChange();
    }

    public int getRayon() {
        return rayon;
    }

    public void setRayon(int rayon) {
        this.rayon = rayon;
        this.fireChange();
    }   

}
