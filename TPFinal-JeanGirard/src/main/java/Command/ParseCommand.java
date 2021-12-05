/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import Model.IModel;

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
        result = model.getParser().parse(expr).evaluate();
        model.addResult(result.toString());
    }

    @Override
    public void undo() {
        model.removeExpression(expr);
        model.removeResult(result.toString());
    }

}
