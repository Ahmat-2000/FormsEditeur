package model;

import model.observerPaterne.AbstractListenableModel;

public class CercleModel extends AbstractListenableModel implements IFormes {
    
    private int x , y , rayon;
    private String color;
    public CercleModel(int x, int y, int rayon) {
        this(x, y, rayon, "red");
    }
    public CercleModel(int x, int y, int rayon, String color) {
        super();
        this.x = x;
        this.y = y;
        this.rayon = rayon;
        this.color = color;
    }
    @Override
    public void setColor(String color) {
        this.color = color;
        this.fireChange();
    }

    @Override
    public String getColor() {
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
    public double getSurface() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public void zoomIn(int deltaRayon){
        this.rayon += deltaRayon;
        this.fireChange();
    }
    public void zoomOut(int deltaRayon){
        this.rayon -= deltaRayon;
        this.fireChange();
    }
    // @Override
    // public void resizeForm() {
    //     throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    // }

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
