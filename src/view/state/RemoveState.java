package view.state;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.IFormes;
import view.ViewContainer;

public class RemoveState extends MouseAdapter implements IViewState {
    private ViewContainer viewContainer;

    public RemoveState(ViewContainer viewContainer) {
        this.viewContainer = viewContainer;
    }
    
    @Override
    //Invoked when the mouse button has been clicked (pressed and released) on a component.
    public void mouseClicked(MouseEvent e) {
        Point p = e.getPoint();
        IFormes tmp = null;
        for (IFormes f : this.viewContainer.getFormesContainer().getMainContainerList()) {
            if (f.onSurface(p)) {
                tmp = f;
                break;
            }
        }
        this.viewContainer.getFormesContainer().removeFormFromMainContainer(tmp);
        //this.viewContainer.removeListeners(this);
    }
    @Override
    // Invoked when the mouse exits a component.
    public void mouseExited(MouseEvent e) {
        System.out.println("exit");
        this.viewContainer.removeListeners(this);
        this.viewContainer.setState(null);
    }
}
