/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Command.ICommand;
import Model.IModel;
import Model.Model;
import java.util.List;

/**
 *
 * @author etudiant
 */
public interface IController {

    public IModel getModel();

    public void DoCommand(ICommand command);

    public void UndoCommand();

    public List<String> GetResults();

    public List<String> GetExpressions();

    public void parseInput(String text);
}
