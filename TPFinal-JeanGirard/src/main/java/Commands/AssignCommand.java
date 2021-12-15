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
public class AssignCommand implements ICommand {

    private final String expr;
    private final IController controller;
    private String variableName;

    public AssignCommand(IController controller, String expr) {
        this.expr = expr;
        this.controller = controller;
    }

    @Override
    public void execute() {
        controller.assign(expr);
    }

    @Override
    public void undo() {
        controller.undoAssign();
    }

}
