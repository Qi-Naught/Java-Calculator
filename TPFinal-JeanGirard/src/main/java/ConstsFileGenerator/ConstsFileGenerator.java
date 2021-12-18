/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConstsFileGenerator;

import Controllers.Controller;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author etudiant
 */
public class ConstsFileGenerator implements IConstsFileGenerator {

    private final String fileName;

    public ConstsFileGenerator(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void addAll(Map<String, String> consts) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream)) {
                objectOutputStream.writeObject(consts);
            }
            Files.write(Path.of(fileName), byteArrayOutputStream.toByteArray());
        }
        catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
