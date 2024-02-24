package view.state;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.FormContainer;
import model.RectangleModel;
import model.commandPattern.CreateCommand;

public class DrawRectState extends MouseAdapter {
    private FormContainer formContainer;
    private int x1,x2,y1,y2;
    private RectangleModel rectangle;
    public DrawRectState(FormContainer formContainer) {
        this.formContainer = formContainer;
    }
    @Override
    // Invoked when a mouse button has been pressed on a component.
    public void mousePressed(MouseEvent e) {
        x1 = e.getX();
        y1 = e.getY();
        rectangle = new RectangleModel(x1,y1, 0,0);
        this.formContainer.addFormToMainContainer(rectangle);
    }
    @Override
    // Invoked when a mouse button is pressed on a component and then dragged.
    public void mouseDragged(MouseEvent e) {
        x2 = e.getX(); y2 = e.getY();
        int width = Math.abs(x1-x2);
        int height = Math.abs(y1-y2);
        rectangle.setWidth(width);
        rectangle.setHeight(height);
    }
    @Override
    // Invoked when a mouse button has been released on a component.
    public void mouseReleased(MouseEvent e) {
        this.formContainer.removeFormFromMainContainer(rectangle);
        if (rectangle.computeDistance(x1, y1, e.getX(),e.getY()) >= 20) {
            CreateCommand command = new CreateCommand(rectangle, formContainer);
            command.executeCommand();
        }
    }
}
