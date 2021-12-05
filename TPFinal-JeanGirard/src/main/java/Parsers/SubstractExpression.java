/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parsers;

/**
 *
 * @author etudiant
 */
public class SubstractExpression implements IExpression {

    IExpression _op1;
    IExpression _op2;

    public SubstractExpression(IExpression _op1, IExpression _op2) {
        this._op1 = _op1;
        this._op2 = _op2;
    }

    @Override
    public double evaluate() {
        return _op1.evaluate() - _op2.evaluate();
    }
}
