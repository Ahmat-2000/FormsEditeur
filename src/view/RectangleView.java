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
        if (rectangleModel.isEditable()) {
            g.setColor(new Color(0, 0, 26));
            g.drawRect(rectangleModel.getX(),rectangleModel.getY(),rectangleModel.getWidth(),rectangleModel.getHeight());  
        } else{
            g.setColor(new Color(140, 192, 132));
            g.fillRect(rectangleModel.getX(),rectangleModel.getY(),rectangleModel.getWidth(),rectangleModel.getHeight());
        }
    }
    
}
