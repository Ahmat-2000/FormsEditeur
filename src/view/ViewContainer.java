package view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import model.CercleModel;
import model.FormesContainer;
import model.IFormes;
import model.RectangleModel;
import model.observerPaterne.ModelListener;

public class ViewContainer extends JPanel implements ModelListener{
    FormesContainer formesContainer;
    public ViewContainer(FormesContainer formesContainer){
        this.formesContainer = formesContainer;
        this.formesContainer.addModelListener(this);
        addForms();
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));

    }

    private void addForms(){
        for (IFormes f : this.formesContainer.getMainContainerList()) {
            if (f instanceof CercleModel) {
                CercleModel c = (CercleModel) f;
                this.add(new CercleView(c));
            }else{
                RectangleModel c = (RectangleModel) f;
                this.add(new RectangleView(c));
            }
        }
    }
    @Override
    public void somethingHasChanged(Object source) {
        this.repaint();
        this.revalidate();
    }
    @Override 
    protected void paintComponent(Graphics g) {
        // TODO Auto-generated method stub
        super.paintComponent(g);
    }
    
}
