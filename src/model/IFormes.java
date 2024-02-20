package model;

public interface IFormes {
    public double getSurface();
    //public void resizeForm();    
    public void moveForm(int deltaX,int deltaY);
    public void moveFormX(int deltaX);
    public void moveFormY(int deltaY);
    public void setColor(String color);
    public String getColor();
    
}
