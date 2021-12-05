/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Parsers;

/**
 *
 * @author etudiant
 */
public class DivideExpression implements IExpression {

    IExpression _op1;
    IExpression _op2;

    public DivideExpression(IExpression op1, IExpression op2) {
        this._op1 = op1;
        this._op2 = op2;
    }

    @Override
    public double evaluate() {

        if (_op2.evaluate() == 0) {
            throw new ArithmeticException("Invalid expression, division by zero.");
        }
        return _op1.evaluate() / _op2.evaluate();
    }

}
