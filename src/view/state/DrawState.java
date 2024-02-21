package view.state;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import view.ViewContainer;

public class DrawState extends MouseAdapter implements IViewState {
    private ViewContainer viewContainer;

    public DrawState(ViewContainer viewContainer) {
        this.viewContainer = viewContainer;
        this.viewContainer.setState(this);
    }
    
    @Override
    //Invoked when the mouse button has been clicked (pressed and released) on a component.
    public void mouseClicked(MouseEvent e) {
        
    }
    
    @Override
    // Invoked when a mouse button has been pressed on a component.
    public void mousePressed(MouseEvent e) {
        //TODO
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
    // Invoked when the mouse exits a component.
    public void mouseExited(MouseEvent e) {
        //TODO
    }
 
    @Override
    // Invoked when the mouse wheel is rotated.
    public void mouseWheelMoved(MouseWheelEvent e) {
        //TODO
    }
 
    @Override
    // Invoked when a mouse button is pressed on a component and then dragged.
    public void mouseDragged(MouseEvent e) {
        //TODO
    }
 
    @Override
    // Invoked when the mouse cursor has been moved onto a component but no buttons have been pushed.
    public void mouseMoved(MouseEvent e) {
        //TODO
    }

}
