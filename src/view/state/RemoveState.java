package view.state;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import view.ViewContainer;

public class RemoveState extends MouseAdapter implements IViewState {
    private ViewContainer viewContainer;

    public RemoveState(ViewContainer viewContainer) {
        this.viewContainer = viewContainer;
        this.viewContainer.setState(this);
    }
    
    @Override
    //Invoked when the mouse button has been clicked (pressed and released) on a component.
    public void mouseClicked(MouseEvent e) {
        //TODO
    }
    
}
