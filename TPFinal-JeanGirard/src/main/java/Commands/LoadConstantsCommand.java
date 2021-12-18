package Commands;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Controllers.IController;
import java.nio.file.Path;

/**
 *
 * @author etudiant
 */
public class LoadConstantsCommand implements ICommand {

    private final IController controller;
    private final Path selectedFilePath;

    public LoadConstantsCommand(IController controller, Path selectedFilePath) {
        this.controller = controller;
        this.selectedFilePath = selectedFilePath;
    }

    @Override
    public void execute() {
        controller.loadConstants(selectedFilePath);
    }

    @Override
    public void undo() {
        controller.undoLoadConstants(selectedFilePath);
    }

}
