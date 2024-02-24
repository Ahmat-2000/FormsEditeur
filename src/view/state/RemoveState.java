package view.state;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.AbstractForm;
import model.FormContainer;
import model.command.RemoveCommand;

public class RemoveState extends MouseAdapter {
    private FormContainer formContainer;

    public RemoveState(FormContainer formContainer) {
        this.formContainer = formContainer;
    }
    
    @Override
    //Invoked when the mouse button has been clicked (pressed and released) on a component.
    public void mouseClicked(MouseEvent e) {
        AbstractForm tmp = null;
        for (AbstractForm f : this.formContainer.getMainContainerList()) {
            if (f.onSurface(e.getX(),e.getY())) {
                tmp = f;
                break;
            }
        }
        if(tmp != null){
            RemoveCommand command = new RemoveCommand(tmp,this.formContainer);
            command.executeCommand();
        }
    }
    @Override
    // Invoked when the mouse exits a component.
    public void mouseExited(MouseEvent e) {
        //this.formContainer.setState(null);
        //this.formContainer.removeListeners(this);
    }
}
