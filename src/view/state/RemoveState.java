package view.state;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.IForm;
import view.ViewFormContainer;

public class RemoveState extends MouseAdapter {
    private ViewFormContainer viewContainer;

    public RemoveState(ViewFormContainer viewContainer) {
        this.viewContainer = viewContainer;
    }
    
    @Override
    //Invoked when the mouse button has been clicked (pressed and released) on a component.
    public void mouseClicked(MouseEvent e) {
        IForm tmp = null;
        for (IForm f : this.viewContainer.getFormesContainer().getMainContainerList()) {
            if (f.onSurface(e.getX(),e.getY())) {
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
        //this.viewContainer.setState(null);
        //this.viewContainer.removeListeners(this);
    }
}
