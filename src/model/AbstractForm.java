package model;

import model.observerPattern.AbstractListenableModel;

public abstract class AbstractForm extends AbstractListenableModel implements IForm {
    protected int x , y , width, height;
    protected boolean editable = false;

    public AbstractForm(int x, int y, int width, int height) {
        super();
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
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
    @Override
    public boolean collusion(AbstractForm f){
/*          // if rectangle has area 0, no overlap
         if (l1.x == r1.x || l1.y == r1.y || r2.x == l2.x || l2.y == r2.y)
         return false;
  
        // If one rectangle is on left side of other 
        if (l1.x > r2.x || l2.x > r1.x) {
            return false;
        }

        // If one rectangle is above other 
        if (r1.y > l2.y || r2.y > l1.y) {
            return false;
        }

        return true; */
        if (this.x + this.width >= f.getX() &&     
            this.x <= f.getX() + f.getWidth() &&       
            this.y + this.height >= f.getY() &&      
            this.y <= f.getY() + f.getHeight())
        {
            return true;
        }
        return false;
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
    public void setEditable(boolean val){
        this.editable = val;
    }
    public boolean isEditable(){
        return this.editable;
    }
    @Override
    public abstract String getName();
    @Override
    public abstract void resize(int x, int y);

}
