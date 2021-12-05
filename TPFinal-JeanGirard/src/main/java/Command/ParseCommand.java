/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import Model.Model;
import Model.Parsers.IExpression;
import Model.Parsers.IParser;

/**
 *
 * @author etudiant
 */
public class ParseCommand implements ICommand {

    private String expr;
    private Model model;
    private Double result;

    public ParseCommand(String expr, Model model) {
        this.expr = expr;
        this.model = model;
    }

    @Override
    public void Execute() {
        model.expressions.add(expr);
        result = model.parser.parse(expr).evaluate();
        model.results.add(result.toString());
        model.Notify();
    }

    @Override
    public void Undo() {
        model.expressions.remove(expr);
        model.results.remove(result);
    }

}
