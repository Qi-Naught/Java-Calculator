/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parsers;

import java.util.HashMap;

/**
 *
 * @author etudiant
 */
public interface IParser {

    public IExpression parse(final String expr, final HashMap<String, String> variables, final HashMap<String, String> constants);

}
