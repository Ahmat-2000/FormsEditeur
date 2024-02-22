package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import view.ViewFormContainer;

public class BtnController implements ActionListener{

    private ViewFormContainer viewContainer;
    private MouseAdapter viewState;
    public BtnController(ViewFormContainer viewContainer, MouseAdapter viewState) {
        this.viewContainer = viewContainer;
        this.viewState = viewState;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.viewContainer.removeListeners(this.viewContainer.getState());
        this.viewContainer.setState(viewState);
        this.viewContainer.addListeners(viewState);
    }
    
}
