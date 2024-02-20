package view;

import model.CercleModel;
import model.FormesContainer;

public class Main {
    public static void main(String[] args) {
        FormesContainer formesContainer = new FormesContainer();
        formesContainer.addFormToMainContainer(new CercleModel(50, 50, 50));
        ViewContainer viewContainer = new ViewContainer(formesContainer);
        SideContainer sideContainer = new SideContainer();
        Header header = new Header();
        Screen window = new Screen(viewContainer, sideContainer, header);
        window.setVisible(true);
        
    }
    
}
