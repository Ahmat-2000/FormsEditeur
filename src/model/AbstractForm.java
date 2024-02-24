package model;

import java.awt.Color;

import model.observerPaterne.AbstractListenableModel;

public abstract class AbstractForm extends AbstractListenableModel implements IForm {
    protected int x , y , width, height;
    protected Color color;
    
    public AbstractForm(int x, int y, int width, int height, Color color) {
        super();
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    @Override
    public void moveFormX(int deltaX) {
        this.x = deltaX;
        this.fireChange();
    }

    @Override
    public void moveFormY(int deltaY) {
       this.y = deltaY;
       this.fireChange();
    }
    @Override
    public boolean onSurface(int x , int y) {
        return x >= this.x && y >= this.y && x <= this.x+this.width && y <= this.y+this.height;
    }
    @Override
    public void moveForm(int deltaX, int deltaY) {
        this.x = deltaX;
        this.y = deltaY;
        this.fireChange();
    }

    public void zoomInWidth(int deltaWidth){
        this.width += deltaWidth;
        this.fireChange();
    }
    /**
     * Rétrécir le rectangle sur l'axe X
     * @param deltaWidth
     */
    @Override
    public void zoomOutWidth(int deltaWidth){
        this.width -= deltaWidth;
        this.fireChange();
    }
    @Override
    public void zoomInHeight(int deltaHeight){
        this.height += deltaHeight;
        this.fireChange();
    }
    @Override
    public void zoomoutHeight(int deltaHeight){
        this.height -= deltaHeight;
        this.fireChange();
    }

    public int computeDistance(int x1,int y1, int x2, int y2){
        return (int) Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
        this.fireChange();
    }
    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
        this.fireChange();
    }
   // public abstract void drawForm(Graphics g);
}
