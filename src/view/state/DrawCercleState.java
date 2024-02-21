package view.state;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import model.CercleModel;
import view.ViewContainer;

public class DrawCercleState extends MouseAdapter implements IViewState {
    private ViewContainer viewContainer;
    private int numberOfClick;
    private Point p1, p2;
    private int startX, startY, endX, endY;
    private CercleModel cercle;
    public DrawCercleState(ViewContainer viewContainer) {
        this.viewContainer = viewContainer;
        this.viewContainer.setState(this);
        numberOfClick = 0;
    }
    
    @Override
    //Invoked when the mouse button has been clicked (pressed and released) on a component.
    public void mouseClicked(MouseEvent e) {
        numberOfClick ++;
        if (numberOfClick < 2) {
            p1 = e.getPoint();
            //System.out.println("first click");
        }else{
            p2 = e.getPoint();
            this.viewContainer.getFormesContainer().addFormToMainContainer(new CercleModel(p1,p2));
            numberOfClick = 0;
            //System.out.println("second click");
            p1 = null; p2 = null;
        }
        
    }
    @Override
    // Invoked when a mouse button is pressed on a component and then dragged.
    public void mouseDragged(MouseEvent e) {
        endX = e.getX();
        endY = e.getY();
        int diameter = Math.max(Math.abs(endX - startX), Math.abs(endY - startY));
        int radius = diameter / 2;
        int centerX = Math.min(startX, endX);
        int centerY = Math.min(startY, endY);
        cercle.setRayon(radius); cercle.setX(centerX); cercle.setY(centerY);
    }
    @Override
    // Invoked when a mouse button has been pressed on a component.
    public void mousePressed(MouseEvent e) {
        startX = e.getX();
        startY = e.getY();
        cercle = new CercleModel(startX,startY, 0);
        this.viewContainer.getFormesContainer().addFormToMainContainer(cercle);

    }
    @Override
    // Invoked when the mouse exits a component.
    public void mouseExited(MouseEvent e) {
        this.viewContainer.removeListeners(this);
    }
 
    @Override
    // Invoked when a mouse button has been released on a component.
    public void mouseReleased(MouseEvent e) {
        //TODO
    }
 
    @Override
    //Invoked when the mouse enters a component.
    public void mouseEntered(MouseEvent e) {
        //TODO
    }
 
    @Override
    // Invoked when the mouse wheel is rotated.
    public void mouseWheelMoved(MouseWheelEvent e) {
        //TODO
    }
 
    @Override
    // Invoked when the mouse cursor has been moved onto a component but no buttons have been pushed.
    public void mouseMoved(MouseEvent e) {
        //TODO
    }

}
