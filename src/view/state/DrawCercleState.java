package view.state;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.CercleModel;
import view.ViewFormContainer;

public class DrawCercleState extends MouseAdapter{
    private ViewFormContainer viewContainer;
    //private int numberOfClick;
    private int x1,x2,y1,y2;
    private CercleModel cercle;
    public DrawCercleState(ViewFormContainer viewContainer) {
        this.viewContainer = viewContainer;
       // numberOfClick = 0;
    }
    @Override
    // Invoked when a mouse button is pressed on a component and then dragged.
    public void mouseDragged(MouseEvent e) {
        x2 = e.getX(); y2 = e.getY();
        int diameter = cercle.computeDistance(x1, y1, x2, y2);
        cercle.setWidth(diameter);
    }
    @Override
    // Invoked when a mouse button has been pressed on a component.
    public void mousePressed(MouseEvent e) {
        x1 = e.getX();
        y1 = e.getY();
        cercle = new CercleModel(x1,y1, 0);
        this.viewContainer.getFormesContainer().addFormToMainContainer(cercle);
    }
    @Override
    // Invoked when the mouse exits a component.
    public void mouseExited(MouseEvent e) {
        //this.viewContainer.setState(null);
        //this.viewContainer.removeListeners(this);
    }
 
    @Override
    // Invoked when a mouse button has been released on a component.
    public void mouseReleased(MouseEvent e) {
       if (cercle.computeDistance(x1, y1, e.getX(),e.getY()) <= 20) {
            this.viewContainer.getFormesContainer().removeFormFromMainContainer(cercle);
       }
    }
    // @Override
    // //Invoked when the mouse button has been clicked (pressed and released) on a component.
    // public void mouseClicked(MouseEvent e) {
    //     numberOfClick ++;
    //     if (numberOfClick < 2) {
    //        x1 = e.getX(); y1 = e.getY();
    //     }else{
    //         x2 = e.getX(); y2 = e.getY();
    //         this.viewContainer.getFormesContainer().addFormToMainContainer(new CercleModel(x1,y1,x2,y2));
    //         numberOfClick = 0;
    //     }
        
    // }
}
