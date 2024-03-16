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
        g.setColor(new Color(0, 0, 26));
        g.drawRect(cercleModel.getX(),cercleModel.getY(),cercleModel.getWidth(),cercleModel.getWidth());
        if (cercleModel.isEditable()) {
            g.drawOval(cercleModel.getX(),cercleModel.getY(),cercleModel.getWidth(),cercleModel.getWidth());
        } else{
            g.setColor(new Color(140, 192, 132));
            g.fillOval(cercleModel.getX(),cercleModel.getY(),cercleModel.getWidth(),cercleModel.getWidth());  
        }
    }    
}
