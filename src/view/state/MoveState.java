package view.state;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import view.ViewContainer;

public class MoveState extends MouseAdapter implements IViewState {
    private ViewContainer viewContainer;

    public MoveState(ViewContainer viewContainer) {
        this.viewContainer = viewContainer;
        this.viewContainer.setState(this);
    }
    
    @Override
    // Invoked when a mouse button is pressed on a component and then dragged.
    public void mouseDragged(MouseEvent e) {
        //TODO
    }
    
}
