/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import Models.IModel;

/**
 *
 * @author etudiant
 */
public class ParseCommand implements ICommand {

    private final String expr;
    private final IModel model;
    private Double result;

    public ParseCommand(String expr, IModel model) {
        this.expr = expr;
        this.model = model;
    }

    @Override
    public void execute() {
        model.addExpression(expr);
        try {
            result = model.getParser().parse(expr, model.getVariables(), model.getConstants()).evaluate();
        }
        catch (Exception e) {
            model.addResult(expr + " is an invalid expression");
            return;
        }
        model.addResult(result.toString());
    }

    @Override
    public void undo() {
        model.removeExpression(expr);
        if (result != null) {
            model.removeResult(result.toString());
        }
        else {
            model.removeResult(expr + " is an invalid expression");
        }
    }

}
