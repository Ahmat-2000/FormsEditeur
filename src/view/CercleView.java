package view;

import model.CercleModel;
import model.observerPaterne.ModelListener;

/**
 *
 * @author 21912949
 */
public class CercleView implements IView , ModelListener{
    public CercleModel cercleModel;
    public CercleView(CercleModel c){
        this.cercleModel = c;
    }
    @Override
    public void somethingHasChanged(Object source) {
        // this.repaint();
        // this.revalidate();
    }
    
}
