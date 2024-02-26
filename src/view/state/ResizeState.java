package view.state;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.AbstractForm;
import model.FormContainer;
import model.commandPattern.ResizeCommand;

public class ResizeState extends MouseAdapter  {
    private FormContainer formContainer;
    private int width,height;
    private AbstractForm form;
    public ResizeState(FormContainer formContainer) {
        this.formContainer = formContainer;
    }
    @Override
    // Invoked when a mouse button has been pressed on a component.
    public void mousePressed(MouseEvent e) {
        form = null;
        for (AbstractForm f : this.formContainer.getMainContainerList()) {
            if (f.onSurface(e.getX(),e.getY())) {
                form = f;
                this.width = f.getWidth(); 
                this.height = f.getHeight();
                break;
            }
        }
    }
    @Override
    // Invoked when a mouse button is pressed on a component and then dragged.
    public void mouseDragged(MouseEvent e) {
        if (form != null) {
            form.resize(e.getX(), e.getY());
        }
    }
    @Override
    // Invoked when a mouse button has been released on a component.
    public void mouseReleased(MouseEvent e) {
        boolean colision = false;
        if (form != null) {
            for (AbstractForm fo : this.formContainer.getMainContainerList()) {
                if (fo != form && form.collusion(fo)) {
                    form.setWidth(width);
                    form.setHeight(height);
                    colision = true;
                    break;
                }  
            }
        }
        if (form != null && colision == false) {
            // on annule le move avant de faire la commande
            form.setWidth(width);
            form.setHeight(height);
            ResizeCommand command = new ResizeCommand(form, e.getX(), e.getY());
            command.executeCommand();
        }
    }
}
