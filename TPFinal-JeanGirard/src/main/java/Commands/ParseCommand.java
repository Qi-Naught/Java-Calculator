/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import Controllers.IController;

/**
 *
 * @author etudiant
 */
public class ParseCommand implements ICommand {

    private final String expr;
    private final IController controller;

    public ParseCommand(IController controller, String expr) {
        this.expr = expr;
        this.controller = controller;
    }

    @Override
    public void execute() {
        controller.parse(expr);
    }

    @Override
    public void undo() {
        controller.undoParse();
    }

}
