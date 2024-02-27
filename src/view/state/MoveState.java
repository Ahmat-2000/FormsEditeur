package view.state;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.AbstractForm;
import model.FormContainer;
import model.commandPattern.MoveCommand;

public class MoveState extends MouseAdapter  {
    private FormContainer formContainer;
    private int endX, endY,startX,startY;
    private AbstractForm form;
    public MoveState(FormContainer formContainer) {
        this.formContainer = formContainer;
    }
    @Override
    // Invoked when a mouse button has been pressed on a component.
    public void mousePressed(MouseEvent e) {
        form = null;
        for (AbstractForm f : this.formContainer.getMainContainerList()) {
            if (f.onSurface(e.getX(),e.getY())) {
                form = f;
                startX = form.getX(); 
                startY = form.getY();
                break;
            }
        }
    }
    @Override
    // Invoked when a mouse button is pressed on a component and then dragged.
    public void mouseDragged(MouseEvent e) {
        endX = e.getX(); endY = e.getY();
        if (form != null) {
            form.moveForm(endX,endY);
        }
    }
    @Override
    // Invoked when a mouse button has been released on a component.
    public void mouseReleased(MouseEvent e) {
        boolean colision = false;
        if (form != null) {
            for (AbstractForm fo : this.formContainer.getMainContainerList()) {
                if (fo != form && form.collusion(fo)) {
                    form.moveForm(startX,startY);
                    colision = true;
                    break;
                }  
            }
        }
        if (form != null && colision == false) {
            // on annule le move avant de faire la commande
            form.moveForm(startX,startY);
            MoveCommand command = new MoveCommand(form, e.getX(), e.getY());
            command.executeCommand();
        }
    }
}
