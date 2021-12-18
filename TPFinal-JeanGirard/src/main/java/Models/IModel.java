/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Parsers.IParser;
import java.util.List;
import java.util.Map;

/**
 *
 * @author etudiant
 */
public interface IModel {

    List<String> getExpressions();

    List<String> getResults();

    Map<String, String> getVariables();

    Map<String, String> getConstants();

    IParser getParser();

    void addExpression(String expression);

    void setExpressions(List<String> expressions);

    void addResult(String result);

    void addVariable(String variableName, String value);

    void removeLastExpression();

    void removeLastResult();

    void removeLastVariable();

    public void setConstants(Map<String, String> consts);

    public void setVars(Map<String, String> vars);

}
