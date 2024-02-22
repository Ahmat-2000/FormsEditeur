package view;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;

import javax.swing.JPanel;

import model.FormContainer;
import model.IForm;
import model.observerPaterne.ModelListener;


public class ViewFormContainer extends JPanel implements ModelListener{
    private MouseAdapter state;
    private FormContainer formesContainer;

    public ViewFormContainer(FormContainer formesContainer){
        this.formesContainer = formesContainer;
        this.formesContainer.addModelListener(this);
        this.state = null;
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

    public FormContainer getFormesContainer() {
        return this.formesContainer;
    }

    @Override
    public void somethingHasChanged(Object source) {
        this.repaint();
        this.revalidate();
    }
    @Override 
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (IForm forme : formesContainer.getMainContainerList()) {
            forme.drawForm(g);
        }
    }
    
}
