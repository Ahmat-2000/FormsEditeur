package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.ViewContainer;
import view.state.RemoveState;

public class RemoveBtnController implements ActionListener{
    private ViewContainer viewContainer;
    
    public RemoveBtnController(ViewContainer viewContainer) {
        this.viewContainer = viewContainer;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        RemoveState r = new RemoveState(this.viewContainer);
        this.viewContainer.setState(r);
        this.viewContainer.addMouseListener(r);
        this.viewContainer.addMouseMotionListener(r);
        this.viewContainer.addMouseWheelListener(r);
    }
    
}
