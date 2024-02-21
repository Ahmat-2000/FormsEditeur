package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.ViewContainer;
import view.state.DrawCercleState;

public class CercleBtnController implements ActionListener{

    private ViewContainer viewContainer;
    public CercleBtnController(ViewContainer viewContainer) {
        this.viewContainer = viewContainer;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DrawCercleState r = new DrawCercleState(this.viewContainer);
        this.viewContainer.setState(r);
        this.viewContainer.addListeners(r);
    }
    
}
