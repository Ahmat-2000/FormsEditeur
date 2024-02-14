package view;

import model.FormesContainer;

/**
 *
 * @author 21912949
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FormesContainer formesContainer = new FormesContainer();
        ViewContainer viewContainer = new ViewContainer(formesContainer);
        SideContainer sideContainer = new SideContainer();
        Header header = new Header();
        Screen window = new Screen(viewContainer, sideContainer, header);
        window.setVisible(true);
        
    }
    
}
