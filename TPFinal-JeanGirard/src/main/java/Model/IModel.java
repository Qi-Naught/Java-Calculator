/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Parsers.IParser;
import java.util.List;

/**
 *
 * @author etudiant
 */
public interface IModel {

    List<String> getExpressions();

    List<String> getResults();

    IParser getParser();

    void addExpression(String expression);

    void addResult(String result);

    void removeExpression(String expression);

    void removeResult(String result);

}
