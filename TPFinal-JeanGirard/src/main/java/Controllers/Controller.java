/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Commands.AssignCommand;
import Commands.ICommand;
import Commands.CommandsManager;
import Commands.ParseCommand;
import Models.IModel;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        loadConstants();
    }

    @Override
    public void parseInput(String input) {
        doCommand(new ParseCommand(input, model));
    }

    @Override
    public void assignInput(String input) {
        doCommand(new AssignCommand(input, model));
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
        model.setExpressions(new ArrayList<>());
        saveHistory();
    }

    public boolean canUndo() {
        return !cm.commandHistory.isEmpty();
    }

    @Override
    public HashMap<String, String> getConstants() {
        return model.getConstants();
    }

    @Override
    public HashMap<String, String> getVariables() {
        return model.getVariables();
    }

    private void loadHistory() {
        try {
            byte[] data = Base64.getDecoder().decode(Files.readAllBytes(Path.of("history.ht")));
            try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data))) {
                model.setExpressions((List<String>) ois.readObject());
            }
        }
        catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void saveHistory() {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(getExpressions());
            oos.close();
            String serializedHitory = Base64.getEncoder().encodeToString(baos.toByteArray());
            Files.writeString(Path.of("history.ht"), serializedHitory);
        }
        catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void loadConstants() {

    }
}
