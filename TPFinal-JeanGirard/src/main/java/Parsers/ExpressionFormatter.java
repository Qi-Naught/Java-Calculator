/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parsers;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author etudiant
 */
public final class ExpressionFormatter {

    public static String[] toExpressionFormat(String expr) {
        final String regex = "(\\d+\\.*\\d*)|([+-^%*()=])|(\\w+)";

        final Pattern pattern = Pattern.compile(regex);

        final Matcher matcher = pattern.matcher(expr);

        return matcher.results().map(MatchResult::group).toArray(String[]::new);

    }

    public static String[] toVarAndConstMappedExpression(String[] formattedExpr, Map<String, String> variables, Map<String, String> constants) {
        Deque<String> mappedFormattedExpr = new ArrayDeque();

        for (String s : formattedExpr) {
            if (variables.containsKey(s)) {
                mappedFormattedExpr.add(variables.get(s));
            }
            else if (constants.containsKey(s)) {
                mappedFormattedExpr.add(constants.get(s));
            }
            else {
                mappedFormattedExpr.add(s);
            }
        }
        return mappedFormattedExpr.toArray(new String[0]);
    }
}
