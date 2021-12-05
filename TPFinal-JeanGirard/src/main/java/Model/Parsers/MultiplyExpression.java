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
public class MultiplyExpression implements IExpression {

    IExpression _op1;
    IExpression _op2;

    public MultiplyExpression(IExpression op1, IExpression op2) {
        this._op1 = op1;
        this._op2 = op2;
    }

    @Override
    public double evaluate() {
        return _op1.evaluate() * _op2.evaluate();
    }

}
