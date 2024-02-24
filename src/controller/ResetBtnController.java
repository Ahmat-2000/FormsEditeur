package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.FormContainer;
import model.command.ResetCommand;
import view.ViewFormContainer;

public class ResetBtnController implements ActionListener{
    private ViewFormContainer viewContainer;
    private FormContainer formContainer;
    public ResetBtnController(ViewFormContainer viewContainer,FormContainer formContainer) {
        this.viewContainer = viewContainer;
        this.formContainer = formContainer;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!this.formContainer.getMainContainerList().isEmpty()) {
            ResetCommand command = new ResetCommand(this.formContainer);
            command.executeCommand();
            this.viewContainer.removeListeners(this.viewContainer.getState());
            this.viewContainer.setState(null);
        }
    }
    
}
