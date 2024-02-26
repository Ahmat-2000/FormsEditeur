package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.commandPattern.CommandHistory;
import model.commandPattern.ICommand;


public class UndoBtnController implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        if (!CommandHistory.getUndoList().empty()) {
            ICommand command = CommandHistory.getUndoList().pop();
            command.undo();
        }
    }

}
