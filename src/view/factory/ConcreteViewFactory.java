package view.factory;

import model.CercleModel;
import model.IForm;
import model.RectangleModel;
import view.CercleView;
import view.IView;
import view.RectangleView;

public class ConcreteViewFactory extends abstractFactory{

    protected IView newInstance(IForm form){
        String name = form.getName();
        switch (name) {
            case "cercle":
                return new CercleView((CercleModel)form);
            case "rectangle":
                return new RectangleView((RectangleModel)form);
            default:
                return null;
        }
    }
    
}
