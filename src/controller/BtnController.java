package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import view.ViewFormContainer;

/**
 * Controller class that handles the interaction between the user and the view components.
 * It listens for actions performed on buttons and responds by updating the view state.
 */
public class BtnController implements ActionListener {

    private ViewFormContainer viewContainer; // The container that holds the view components.
    private MouseAdapter viewState; // The current state of the view.

    /**
     * Constructs a BtnController with specified view container and mouse adapter state.
     *
     * @param viewContainer The container that holds and manages the view components.
     * @param viewState     The initial state of the view to be set on button action.
     */
    public BtnController(ViewFormContainer viewContainer, MouseAdapter viewState) {
        this.viewContainer = viewContainer;
        this.viewState = viewState;
    }

    /**
     * Invoked when an action occurs on the bound button.
     * This method changes the current state of the view container to the new state
     * and updates the listeners accordingly.
     *
     * @param e The event to be processed.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        this.viewContainer.removeListeners(this.viewContainer.getState()); // Remove the current state listeners.
        this.viewContainer.setState(viewState); // Update the view container with the new state.
        this.viewContainer.addListeners(viewState); // Add the new state listeners.
    }

}
