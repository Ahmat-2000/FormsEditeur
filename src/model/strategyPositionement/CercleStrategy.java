package model.strategyPositionement;


import model.AbstractForm;
import model.CercleModel;
import model.FormContainer;

public class CercleStrategy extends AbstractStrategy{

    public CercleStrategy(int formNumbe, int w, int h, FormContainer formContainer) {
        super(formNumbe, w, h, formContainer);
    }

    @Override
    public AbstractForm creatForm(int x,int y) {
        return new CercleModel(x, y, formWidth);
    }
    
}
