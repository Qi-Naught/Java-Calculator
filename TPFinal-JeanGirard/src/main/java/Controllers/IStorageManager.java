/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.nio.file.Path;

/**
 *
 * @author etudiant
 */
public interface IStorageManager {

    public void initialize();

    public void loadDefaultsFiles();

    public void loadConstantsFromFilePath(Path selectedFilePath);

    public void save();

    public void unloadLastAddedConstants();
}
