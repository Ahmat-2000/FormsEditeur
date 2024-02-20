package view;

import java.awt.Graphics;

import javax.swing.JComponent;

import model.RectangleModel;
import model.observerPaterne.ModelListener;

public class RectangleView extends JComponent implements IView , ModelListener{
    private RectangleModel rectangleModel;
    public RectangleView(RectangleModel r){
        this.rectangleModel = r;
        this.rectangleModel.addModelListener(this);
        //this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setLayout(null);
    }
    @Override
    public void somethingHasChanged(Object source) {
        this.repaint();
        this.revalidate();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // g.setColor(Color.BLACK);
		g.drawRect( 0,0,rectangleModel.getWith(),rectangleModel.getHeight());
    }
    
}
