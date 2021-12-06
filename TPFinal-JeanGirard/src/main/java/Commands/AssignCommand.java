/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import Models.IModel;
import Parsers.IExpression;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author etudiant
 */
public class AssignCommand implements ICommand {

    private final String expr;
    private final IModel model;
    private String variableName;

    public AssignCommand(String expr, IModel model) {
        this.expr = expr;
        this.model = model;
    }

    @Override
    public void execute() {
        String[] variable = toVariableFormat(expr);
        variableName = variable[0];
        String variableValue = "";

        for (int i = 1; i < variable.length; i++) {
            variableValue += variable[i];
        }
        Double result = model.getParser().parse(variableValue, model.getVariables(), model.getConstants()).evaluate();
        model.addVariable(variable[0], result.toString());
    }

    @Override
    public void undo() {
        model.removeVariable(variableName);
    }

    private static String[] toVariableFormat(String expr) {
        final String regex = "(\\w+)|(\\d+|\\w+|[+-/^%*()]+)";

        final Pattern pattern = Pattern.compile(regex);

        final Matcher matcher = pattern.matcher(expr);

        return matcher.results().map(MatchResult::group).toArray(String[]::new);

    }
}
