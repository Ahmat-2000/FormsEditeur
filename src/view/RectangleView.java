package view;

import java.awt.Graphics;

import model.RectangleModel;

public class RectangleView implements IView {
    private RectangleModel rectangleModel;
    public RectangleView(RectangleModel r){
        this.rectangleModel = r;
        //this.rectangleModel.addModelListener(this);
    }
    // @Override
    // public void somethingHasChanged(Object source) {
    //     this.repaint();
    //     this.revalidate();
    // }
    
    @Override
    public void dessiner(Graphics g) {
        g.setColor(rectangleModel.getColor());
        g.fillRect(rectangleModel.getX(),rectangleModel.getY(),rectangleModel.getWith(),rectangleModel.getHeight());

    }
    
}
