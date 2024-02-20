package view;

import model.CercleModel;
import model.FormesContainer;
import model.RectangleModel;

public class Main {
    public static void main(String[] args) {
        FormesContainer formesContainer = new FormesContainer();

        formesContainer.addFormToMainContainer(new CercleModel(50, 50, 100));
        formesContainer.addFormToMainContainer(new RectangleModel(200, 100, 80, 120));
        // formesContainer.addFormToMainContainer(new CercleModel(50, 50, 50));
        ViewContainer viewContainer = new ViewContainer(formesContainer);
        Header header = new Header();
        Screen window = new Screen(viewContainer, header);
        window.setVisible(true);
        
    }
    
}
