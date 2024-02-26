package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.commandPattern.CommandHistory;
import model.commandPattern.ICommand;


public class RedoBtnController implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        if (!CommandHistory.getRedoList().empty()) {
            ICommand command = CommandHistory.getRedoList().pop();
            command.redo();
        }
    }

}
