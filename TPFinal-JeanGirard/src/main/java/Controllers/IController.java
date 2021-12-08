/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Commands.ICommand;
import Models.IModel;
import java.util.List;

/**
 *
 * @author etudiant
 */
public interface IController {

    public IModel getModel();

    public void doCommand(ICommand command);

    public void undoCommand();

    public void deleteHistory();

    public List<String> getResults();

    public List<String> getExpressions();

    public void parseInput(String text);

    public void assignInput(String text);
}