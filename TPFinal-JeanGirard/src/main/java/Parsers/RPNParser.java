/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parsers;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

/**
 *
 * @author Jean Girard
 */
public class RPNParser implements IParser {

    @Override
    public IExpression parse(final String expr, final Map<String, String> variables, final Map<String, String> constants) {

        String[] formattedExpr = ExpressionFormatter.toExpressionFormat(expr);
        formattedExpr = ExpressionFormatter.toVarAndConstMappedExpression(formattedExpr, variables, constants);

        Deque<String> rpnExpr = toRPN(formattedExpr);

        Deque<IExpression> expressions = new ArrayDeque<>();
        IExpression rootExpression = null;

        for (String s : rpnExpr) {
            if (Character.isDigit(s.charAt(0))) {
                IExpression childExpression = new NumberExpression(s);
                expressions.push(childExpression);
            }
            else {
                IExpression op2 = expressions.pop();
                IExpression op1 = expressions.pop();
                rootExpression = createExpression(op1, op2, s.charAt(0));
                expressions.push(rootExpression);
            }
        }

        return rootExpression != null ? rootExpression : expressions.pop();
    }

    public Deque toRPN(final String[] expr) {
        //Inspiré du Dijkstra's shunting yard algorithm.

        Deque<Character> operators = new ArrayDeque<>();
        Deque<String> rpnExpression = new ArrayDeque<>();

        for (String s : expr) {

            if (Character.isDigit(s.charAt(0))) {
                rpnExpression.add(s);
            }
            else if (isOperator(s.charAt(0))) {
                while (operators.peek() != null && operators.peek() != '(' && (precedenceOf(operators.peek()) > precedenceOf(s.charAt(0))
                        || ((precedenceOf(operators.peek()) == precedenceOf(s.charAt(0))) && isLeftAssociative(s.charAt(0))))) {
                    rpnExpression.add(operators.pop().toString());
                }
                operators.push(s.charAt(0));
            }
            else if (s.charAt(0) == '(') {
                operators.push(s.charAt(0));
            }
            else if (s.charAt(0) == ')') {
                while (operators.peek() != '(') {
                    rpnExpression.add(operators.pop().toString());
                }
                operators.pop();
            }
        }

        while (!operators.isEmpty()) {
            rpnExpression.add(operators.pop().toString());
        }

        return rpnExpression;
    }

    public boolean isOperator(final char c) {
        return (c == '^' || c == '%' || c == '*' || c == '/' || c == '+' || c == '-' || c == '=');
    }

    public int precedenceOf(final char ch) {
        return switch (ch) {
            case '=' ->
                1;
            case '+', '-' ->
                2;
            case '*', '/', '%' ->
                3;
            case '^' ->
                4;
            default ->
                -1;
        };
    }

    public boolean isLeftAssociative(final char ch) {
        return switch (ch) {
            case '*','/','%','+','-','=' ->
                true;
            default ->
                false;
        };
    }

    public IExpression createExpression(final IExpression op1, final IExpression op2, final char operator) {
        switch (operator) {
            case '+' -> {
                return new AddExpression(op1, op2);
            }
            case '-' -> {
                return new SubstractExpression(op1, op2);
            }
            case '*' -> {
                return new MultiplyExpression(op1, op2);
            }
            case '/' -> {
                return new DivideExpression(op1, op2);
            }
            case '%' -> {
                return new ModExpression(op1, op2);
            }
            case '^' -> {
                return new ExponentExpression(op1, op2);
            }
            case '=' -> {
                return new EqualityExpression(op1, op2);
            }
            default -> {
                return null;
            }
        }

    }
}
