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
        g.setColor(Color.BLACK);
        g.drawRect(cercleModel.getX(),cercleModel.getY(),cercleModel.getWidth(),cercleModel.getWidth());
        if (cercleModel.getColor() == "black") {
            g.drawOval(cercleModel.getX(),cercleModel.getY(),cercleModel.getWidth(),cercleModel.getWidth());
        } else{
            g.setColor(Color.RED);
            g.fillOval(cercleModel.getX(),cercleModel.getY(),cercleModel.getWidth(),cercleModel.getWidth());  
        }
    }    
}
