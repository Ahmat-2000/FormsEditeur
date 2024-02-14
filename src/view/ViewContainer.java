package view;

import java.awt.Graphics;

import javax.swing.JPanel;

import model.FormesContainer;
import model.observerPaterne.ModelListener;

/**
 *
 * @author 21912949
 */
public class ViewContainer extends JPanel implements ModelListener{
    FormesContainer formesContainer;
    public ViewContainer(FormesContainer formesContainer){
        this.formesContainer = formesContainer;
        this.formesContainer.addModelListener(this);
        this.add(new RectangleView());
        this.add(new RectangleView());
        this.add(new RectangleView());
    }

    @Override
    public void somethingHasChanged(Object source) {
        //this.repaint();
        this.revalidate();
    }
    @Override 
    protected void paintComponent(Graphics g) {
        // TODO Auto-generated method stub
        super.paintComponent(g);
    }
    
}
