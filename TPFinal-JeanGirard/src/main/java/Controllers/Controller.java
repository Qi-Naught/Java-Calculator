/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Commands.CommandsManager;
import Commands.ICommand;
import Models.IModel;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author etudiant
 */
public class Controller implements IController {

    private final CommandsManager cm;
    private final IModel model;

    public Controller(CommandsManager cm, IModel model) {
        this.cm = cm;
        this.model = model;
        loadHistory();
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
        String[] variable = toVariableFormat(expr);
        String variableValue = "";

        for (int i = 1; i < variable.length; i++) {
            variableValue += variable[i];
        }
        try {
            Double result = model.getParser().parse(variableValue, model.getVariables(), model.getConstants()).evaluate();
            model.addVariable(variable[0], result.toString());
            model.addExpression(expr);
            model.addResult(expr);
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
        saveHistory();

    }

    @Override
    public void undoCommand() {
        cm.UndoCommand();
        saveHistory();

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
    public void deleteHistory() {
        model.getConstants().clear();
        model.getVariables().clear();
        model.setExpressions(new ArrayList<>());
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

    private void loadHistory() {
        try {
            byte[] data = Files.readAllBytes(Path.of("history.bin"));
            try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data))) {
                model.setExpressions((List<String>) ois.readObject());
            }
        }
        catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void saveHistory() {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream)) {
                objectOutputStream.writeObject(getExpressions());
            }
            Files.write(Path.of("history.bin"), byteArrayOutputStream.toByteArray());
        }
        catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private String[] toVariableFormat(String expr) {
        final String regex = "(\\w+)|(\\d+|\\w+|[+-/^%*()]+)";

        final Pattern pattern = Pattern.compile(regex);

        final Matcher matcher = pattern.matcher(expr);

        return matcher.results().map(MatchResult::group).toArray(String[]::new);

    }
}
