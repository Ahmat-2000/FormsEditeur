package view;

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
        g.setColor(cercleModel.getColor());
        g.fillOval(cercleModel.getX(),cercleModel.getY(),cercleModel.getRayon(),cercleModel.getRayon());
        
    }    
}
