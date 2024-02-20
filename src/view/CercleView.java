package view;

import java.awt.Graphics;

import javax.swing.JComponent;

import model.CercleModel;
import model.observerPaterne.ModelListener;

public class CercleView extends JComponent implements IView , ModelListener{
    private CercleModel cercleModel;
    public CercleView(CercleModel c){
        this.cercleModel = c;
        this.cercleModel.addModelListener(this);
        //this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setLayout(null);
    }

    public CercleModel getCercleModel() {
        return cercleModel;
    }
    public void setCercleModel(CercleModel cercleModel) {
        this.cercleModel = cercleModel;
    }

    @Override
    public void somethingHasChanged(Object source) {
        this.repaint();
        this.revalidate();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //g.setColor();
        g.drawOval(cercleModel.getX(),cercleModel.getY(),cercleModel.getRayon(),cercleModel.getRayon());
    }
    
}
