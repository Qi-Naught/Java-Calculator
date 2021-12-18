/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Commands.AssignCommand;
import Commands.ParseCommand;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author etudiant
 */
public class StorageManager implements IStorageManager {

    private final IController controller;

    public StorageManager(IController controller) {
        this.controller = controller;
    }

    @Override
    public void initialize() {
        loadDefaultConstants();
        loadHistory();
    }

    @Override
    public void save() {
        saveHistory();
    }

    @Override
    public void loadDefaultsFiles() {
        loadDefaultConstants();
    }

    @Override
    public void loadConstantsFromFilePath(Path selectedFilePath) {
        try {
            byte[] data = Files.readAllBytes(selectedFilePath);
            try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data))) {
                Map<String, String> constantsToAdd = (Map<String, String>) ois.readObject();
                Map<String, String> actualConstants = controller.getConstants();
                actualConstants.forEach(constantsToAdd::putIfAbsent);
                controller.setConstants(constantsToAdd);
            }
        }
        catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadHistory() {
        try {
            byte[] data = Files.readAllBytes(Path.of("history.bin"));
            try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data))) {
                List<String> expressions = ((List<String>) ois.readObject());

                expressions.forEach(expr -> {
                    if (expr.contains("=")) {
                        controller.doCommand(new AssignCommand(controller, expr));
                    }
                    else {
                        controller.doCommand(new ParseCommand(controller, expr));
                    }
                });
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
                objectOutputStream.writeObject(controller.getExpressions());
            }
            Files.write(Path.of("history.bin"), byteArrayOutputStream.toByteArray());
        }
        catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void loadDefaultConstants() {
        try {
            byte[] data = Files.readAllBytes(Path.of("defaultConsts.cst"));
            try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data))) {
                controller.setConstants((Map<String, String>) ois.readObject());
            }
        }
        catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void unloadConstantsFromFilePath(Path selectedFilePath) {
        try {
            byte[] data = Files.readAllBytes(selectedFilePath);
            try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data))) {
                Map<String, String> constantsToRemove = (Map<String, String>) ois.readObject();
                Map<String, String> actualConstants = controller.getConstants();
                constantsToRemove.forEach(actualConstants::remove);
                controller.setConstants(actualConstants);
            }
        }
        catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
