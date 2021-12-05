/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.Parsers.IParser;
import java.util.List;

/**
 *
 * @author etudiant
 */
public interface IModel {

    List<String> GetExpressions();

    List<String> GetResults();

    IParser GetParser();

    void AddExpression(String expression);

    void AddResult(String result);
}
