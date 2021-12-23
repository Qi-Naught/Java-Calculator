/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Commands.CommandsManager;
import Commands.ICommand;
import Models.IModel;
import Parsers.ExpressionFormatter;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author etudiant
 */
public class Controller implements IController {

    private final CommandsManager cm;
    private final IModel model;
    private final IStorageManager storageManager;

    public Controller(CommandsManager commandsManager, IModel model) {
        this.cm = commandsManager;
        this.model = model;
        this.storageManager = new StorageManager(this);
        storageManager.initialize();
    }

    @Override
    public void parse(String expr) {
        model.addExpression(expr);
        Double result;
        try {
            result = model.getParser().parse(expr, model.getVariables(), model.getConstants()).evaluate();
            model.addResult(result.toString());
        }
        catch (Exception e) {
            model.addResult(expr + " is an invalid expression");
        }
    }

    @Override
    public void undoParse() {
        model.removeLastExpression();
        model.removeLastResult();
    }

    @Override
    public void assign(String expr) {
        String[] variable = ExpressionFormatter.toVariable(expr);
        String variableValue = "";

        for (int i = 1; i < variable.length; i++) {
            variableValue += variable[i];
        }
        try {
            Double result = model.getParser().parse(variableValue, model.getVariables(), model.getConstants()).evaluate();
            model.addVariable(variable[0], result.toString());
            model.addExpression(expr);
            model.addResult(variable[0] + " = " + result.toString());
        }
        catch (Exception e) {
            model.addResult(expr + " is an invalid assignment");
        }
    }

    @Override
    public void undoAssign() {
        model.removeLastResult();
        model.removeLastExpression();
        model.removeLastVariable();
    }

    @Override
    public void doCommand(ICommand command) {
        cm.ExecuteCommand(command);
        storageManager.save();
    }

    @Override
    public void undoCommand() {
        cm.UndoCommand();
        storageManager.save();
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
    public void setExpressions(List<String> expressions) {
        model.setExpressions(expressions);
    }

    @Override
    public void setConstants(Map<String, String> consts) {
        model.setConstants(consts);
    }

    @Override
    public void setVars(Map<String, String> vars) {
        model.setVars(vars);
    }

    @Override
    public void deleteHistory() {
        model.getConstants().clear();
        model.getVariables().clear();
        model.setExpressions(new ArrayList<>());
        storageManager.loadDefaultsFiles();
    }

    public boolean canUndo() {
        return !cm.commandHistory.isEmpty();
    }

    @Override
    public Map<String, String> getConstants() {
        return model.getConstants();
    }

    @Override
    public Map<String, String> getVariables() {
        return model.getVariables();
    }

    @Override
    public void loadConstants(Path selectedFilePath) {
        storageManager.loadConstantsFromFilePath(selectedFilePath);
    }

    @Override
    public void undoLoadConstants() {
        storageManager.unloadLastAddedConstants();
    }
}
