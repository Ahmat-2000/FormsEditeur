package view.state;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.CercleModel;
import model.FormContainer;
import model.command.CreateCommand;

public class DrawCercleState extends MouseAdapter{
    private FormContainer formContainer;
    private int x1,x2,y1,y2;
    private CercleModel cercle;
    public DrawCercleState(FormContainer formContainer) {
        this.formContainer = formContainer;
    }
   
    @Override
    // Invoked when a mouse button has been pressed on a component.
    public void mousePressed(MouseEvent e) {
        x1 = e.getX();
        y1 = e.getY();
        cercle = new CercleModel(x1,y1, 0);
        this.formContainer.addFormToMainContainer(cercle);
    }

    @Override
    // Invoked when a mouse button is pressed on a component and then dragged.
    public void mouseDragged(MouseEvent e) {
        x2 = e.getX(); y2 = e.getY();
        int diameter = cercle.computeDistance(x1, y1, x2, y2);
        cercle.setWidth(diameter);
    }

    @Override
    // Invoked when a mouse button has been released on a component.
    public void mouseReleased(MouseEvent e) {
        this.formContainer.removeFormFromMainContainer(cercle);
        if (cercle.computeDistance(x1, y1, e.getX(),e.getY()) >= 20) {
            CreateCommand command = new CreateCommand(cercle, formContainer);
            command.executeCommand();
        }
    }
}