package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.command.CommandHistory;
import model.command.ICommand;


public class UndoBtnController implements ActionListener{
    public UndoBtnController() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!CommandHistory.getCommandsList().empty()) {
            ICommand command = CommandHistory.getCommandsList().pop();
            command.undo();
        }
    }

}
