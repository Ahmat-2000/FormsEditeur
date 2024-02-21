package model;

import java.awt.Color;
import java.awt.Point;

import model.observerPaterne.AbstractListenableModel;

public class RectangleModel extends AbstractListenableModel implements IFormes {
    private int x , y , with, height;
    private Color color;
    
    public RectangleModel(int x, int y, int with, int height, Color color) {
        super();
        this.x = x;
        this.y = y;
        this.with = with;
        this.height = height;
        this.color = color;
    }
    public RectangleModel(int x, int y, int with, int height) {
        this(x, y, with, height, Color.BLACK);
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
    @Override
    public boolean onSurface(Point p){
        if ((p.getX() >= this.x && p.getX() <= this.x+this.with) && (p.getY() >= this.y && p.getY() <= this.y+this.height)){
            return true;
        }
        return false;  
    }

    @Override
    public void moveForm(int deltaX, int deltaY) {
        this.x += deltaX;
        this.y += deltaY;
        this.fireChange();
    }
    
    /**
     * Agrandir le rectangle sur l'axe X
     * @param deltaWidth
     */
    public void zoomInWidth(int deltaWidth){
        this.with += deltaWidth;
        this.fireChange();
    }
    /**
     * Rétrécir le rectangle sur l'axe X
     * @param deltaWidth
     */
    public void zoomOutWidth(int deltaWidth){
        this.with -= deltaWidth;
        this.fireChange();
    }

    public void zoomInHeight(int deltaHeight){
        this.height += deltaHeight;
        this.fireChange();
    }
    public void zoomoutHeight(int deltaHeight){
        this.height -= deltaHeight;
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
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
        this.fireChange();
    }
    public int getWith() {
        return with;
    }
    public void setWith(int with) {
        this.with = with;
        this.fireChange();
    }
}
