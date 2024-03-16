package view;

import model.FormContainer;
import model.strategyPositionement.AbstractStrategy;
import model.strategyPositionement.MixStrategy;

public class Main {
    public static void main(String[] args) {
        FormContainer formesContainer = new FormContainer();
        ViewFormContainer viewContainer = new ViewFormContainer(formesContainer);
        Header header = new Header(viewContainer,formesContainer);
        Screen window = new Screen(viewContainer, header);
        window.setVisible(true);
        // AbstractStrategy strategy = new RectStrategy(4, viewContainer.getWidth(), viewContainer.getHeight(), formesContainer);
        // strategy.posForm();

        AbstractStrategy mix = new MixStrategy(4, viewContainer.getWidth(), viewContainer.getHeight(), formesContainer);
        mix.posForm();

        // AbstractStrategy s2 = new CercleStrategy(4, viewContainer.getWidth(), viewContainer.getHeight(), formesContainer);
        // s2.posForm();
    }
    
}
