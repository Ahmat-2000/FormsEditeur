package model;

public interface IForm {
    public boolean onSurface(int x, int y);
    public void moveForm(int deltaX,int deltaY);
    public void moveFormX(int deltaX);
    public void moveFormY(int deltaY);
    public void resize(int x,int y);
    public String getName();  
    public boolean collusion(AbstractForm f);  
}
