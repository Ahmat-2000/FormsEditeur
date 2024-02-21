package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.ViewContainer;

public class ResetBtnController implements ActionListener{
    private ViewContainer viewContainer;
    public ResetBtnController(ViewContainer viewContainer) {
        this.viewContainer = viewContainer;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.viewContainer.getFormesContainer().clearMainContainer();
    }
    
}
