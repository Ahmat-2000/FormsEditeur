package view;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;

import javax.swing.JPanel;

import model.AbstractForm;
import model.CercleModel;
import model.FormContainer;
import model.RectangleModel;
import model.observerPattern.ModelListener;


public class ViewFormContainer extends JPanel implements ModelListener{
    private MouseAdapter state = null;
    private FormContainer formesContainer;

    public ViewFormContainer(FormContainer formesContainer){
        this.formesContainer = formesContainer;
        this.formesContainer.addModelListener(this);
        this.setLayout(null);
    }
    public MouseAdapter getState() {
        return state;
    }

    public void addListeners(MouseAdapter m){
        this.addMouseListener(m);
        this.addMouseMotionListener(m);
        this.addMouseWheelListener(m);
    }
    public void removeListeners(MouseAdapter m){
        this.removeMouseListener(m);
        this.removeMouseMotionListener(m);
        this.removeMouseWheelListener(m);
    }
    public void setState(MouseAdapter state) {
        this.state = state;
    }

    @Override
    public void somethingHasChanged(Object source) {
        this.repaint();
        this.revalidate();
    }
    @Override 
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (AbstractForm forme : formesContainer.getMainContainerList()) {
            IView c = null;
            if(forme instanceof CercleModel){
                c = new CercleView((CercleModel)forme);
            }else{
                c = new RectangleView((RectangleModel)forme);
            }
            c.dessiner(g);
        }
    }
    
}
