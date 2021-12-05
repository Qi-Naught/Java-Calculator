/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Command.ICommand;
import Command.CommandsManager;
import Command.ParseCommand;
import Model.IModel;
import java.util.List;

/**
 *
 * @author etudiant
 */
public class Controller implements IController {

    private CommandsManager cm;
    private IModel model;

    public Controller(CommandsManager cm, IModel model) {
        this.cm = cm;
        this.model = model;
    }

    @Override
    public void parseInput(String text) {
        doCommand(new ParseCommand(text, model));
    }

    @Override
    public void doCommand(ICommand command) {
        cm.ExecuteCommand(command);
    }

    @Override
    public void undoCommand() {
        cm.UndoCommand();
    }

    @Override
    public List<String> getResults() {
        return model.getResults();
    }

    @Override
    public List<String> getExpressions() {
        return model.getExpressions();
    }

    @Override
    public IModel getModel() {
        return model;
    }

    @Override
    public void deleteHistory() {
        while (canUndo()) {
            undoCommand();
        }
    }

    public boolean canUndo() {
        return !cm.commandHistory.isEmpty();
    }

}
