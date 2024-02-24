package view;

import java.awt.Color;
import java.awt.Graphics;

import model.CercleModel;

public class CercleView  implements IView{
    private CercleModel cercleModel;
    public CercleView(CercleModel c){
        this.cercleModel = c;
    }
    public CercleModel getCercleModel() {
        return cercleModel;
    }
    public void setCercleModel(CercleModel cercleModel) {
        this.cercleModel = cercleModel;
    }
    @Override
    public void dessiner(Graphics g) {
        g.setColor(Color.RED);
        g.drawRect(cercleModel.getX(),cercleModel.getY(),cercleModel.getWidth(),cercleModel.getWidth());
        g.setColor(Color.BLACK);
        g.drawOval(cercleModel.getX(),cercleModel.getY(),cercleModel.getWidth(),cercleModel.getWidth());
        // g.fillOval(cercleModel.getX(),cercleModel.getY(),cercleModel.getRayon(),cercleModel.getRayon());  
    }    
}
