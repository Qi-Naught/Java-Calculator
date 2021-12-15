/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Commands.ICommand;
import java.util.List;
import java.util.Map;

/**
 *
 * @author etudiant
 */
public interface IController {

    public void doCommand(ICommand command);

    public void undoCommand();

    public void deleteHistory();

    public List<String> getResults();

    public List<String> getExpressions();

    public Map<String, String> getConstants();

    public Map<String, String> getVariables();

    public void parse(String text);

    public void undoParse();

    public void assign(String text);

    public void undoAssign();

}
