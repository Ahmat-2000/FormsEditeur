package view.state;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.AbstractForm;
import view.ViewFormContainer;

public class MoveState extends MouseAdapter  {
    private ViewFormContainer viewContainer;
    private int x1,x2,y1,y2;
    private AbstractForm form;
    public MoveState(ViewFormContainer viewContainer) {
        this.viewContainer = viewContainer;
    }
    @Override
    // Invoked when a mouse button has been pressed on a component.
    public void mousePressed(MouseEvent e) {
        form = null;
        for (AbstractForm f : this.viewContainer.getFormesContainer().getMainContainerList()) {
            if (f.onSurface(e.getX(),e.getY())) {
                form = f;
                break;
            }
        }
    }
    @Override
    // Invoked when a mouse button is pressed on a component and then dragged.
    public void mouseDragged(MouseEvent e) {
        x2 = e.getX(); y2 = e.getY();
        if (form != null) {
            form.moveForm(x2,y2);
        }
    }
    @Override
    // Invoked when a mouse button has been released on a component.
    public void mouseReleased(MouseEvent e) {
       if (form != null && form.computeDistance(x1, y1, e.getX(),e.getY()) <= 20) {
          //TODO 
       }
    }
    @Override
    // Invoked when the mouse exits a component.
    public void mouseExited(MouseEvent e) {        
        //this.viewContainer.setState(null);
        //this.viewContainer.removeListeners(this);
    }
}
