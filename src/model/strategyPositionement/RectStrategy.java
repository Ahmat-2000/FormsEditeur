package model.strategyPositionement;

import model.AbstractForm;
import model.FormContainer;
import model.RectangleModel;

public class RectStrategy extends AbstractStrategy{

    public RectStrategy(int formNumbe, int w, int h, FormContainer formContainer) {
        super(formNumbe, w, h, formContainer);
    }
    @Override
    public AbstractForm creatForm(int x,int y) {
        return new RectangleModel(x, y, formWidth,formHeight);
    }
}
