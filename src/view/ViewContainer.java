package view;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;

import javax.swing.JPanel;

import model.CercleModel;
import model.FormesContainer;
import model.IFormes;
import model.RectangleModel;
import model.observerPaterne.ModelListener;
import view.state.IViewState;

public class ViewContainer extends JPanel implements ModelListener{
    private IViewState state;
    private FormesContainer formesContainer;

    public ViewContainer(FormesContainer formesContainer){
        this.formesContainer = formesContainer;
        this.formesContainer.addModelListener(this);
        this.state = null;
        this.setLayout(null);
    }
    public IViewState getState() {
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
    public void setState(IViewState state) {
        this.state = state;
    }

    public FormesContainer getFormesContainer() {
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
        for (IFormes forme : formesContainer.getMainContainerList()) {
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
