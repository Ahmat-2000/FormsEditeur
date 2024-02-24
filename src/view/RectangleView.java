package view;

import java.awt.Color;
import java.awt.Graphics;

import model.RectangleModel;

public class RectangleView implements IView {
    private RectangleModel rectangleModel;
    public RectangleView(RectangleModel r){
        this.rectangleModel = r;
    }
    
    @Override
    public void dessiner(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawRect(rectangleModel.getX(),rectangleModel.getY(),rectangleModel.getWidth(),rectangleModel.getHeight());
        // g.fillRect(rectangleModel.getX(),rectangleModel.getY(),rectangleModel.getWith(),rectangleModel.getHeight());
    }
    
}
