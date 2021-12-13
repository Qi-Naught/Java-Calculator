/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Parsers.IParser;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author etudiant
 */
public interface IModel {

    List<String> getExpressions();

    List<String> getResults();

    HashMap<String, String> getVariables();

    HashMap<String, String> getConstants();

    IParser getParser();

    void addExpression(String expression);

    void setExpressions(List<String> expressions);

    void addResult(String result);

    void addVariable(String variableName, String value);

    void removeExpression(String expression);

    void removeResult(String result);

    void removeVariable(String variable);

}
