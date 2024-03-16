
package model.strategyPositionement;


import model.AbstractForm;
import model.CercleModel;
import model.FormContainer;
import model.RectangleModel;

public class MixStrategy extends AbstractStrategy{

    public MixStrategy(int formNumbe, int w, int h, FormContainer formContainer) {
        super(formNumbe, w, h, formContainer);
    }
    @Override
    public AbstractForm creatForm(int x,int y) {
        int rand =  this.random.nextInt(3);
        if (rand == 0) {
            return new RectangleModel(x, y, formWidth,formHeight);            
        }else{
            return new CercleModel(x, y, formWidth);            
        }
    }
    
}

