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
public class NumberExpression implements IExpression {

    double _number;

    public NumberExpression(String _number) {
        this._number = Double.parseDouble(_number);
    }

    public NumberExpression(double _number) {
        this._number = _number;
    }

    @Override
    public double evaluate() {
        return _number;
    }

}
