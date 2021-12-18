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
        loadConstants();
        loadHistory();
    }

    @Override
    public void save() {
        saveHistory();
    }

    @Override
    public void load() {
        loadConstants();
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

    private void loadConstants() {
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
}
