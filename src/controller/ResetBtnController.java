package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.ViewFormContainer;

public class ResetBtnController implements ActionListener{
    private ViewFormContainer viewContainer;
    public ResetBtnController(ViewFormContainer viewContainer) {
        this.viewContainer = viewContainer;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.viewContainer.getFormesContainer().clearMainContainer();
        this.viewContainer.removeListeners(this.viewContainer.getState());
        this.viewContainer.setState(null);
    }
    
}
