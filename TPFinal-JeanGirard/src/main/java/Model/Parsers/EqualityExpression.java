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
public class EqualityExpression implements IExpression {

    IExpression _op1;
    IExpression _op2;

    public EqualityExpression(IExpression op1, IExpression op2) {
        this._op1 = op1;
        this._op2 = op2;
    }

    @Override
    public double evaluate() {

        if (_op1.evaluate() == _op2.evaluate()) {
            return 1;
        }
        return 0;
    }

}
