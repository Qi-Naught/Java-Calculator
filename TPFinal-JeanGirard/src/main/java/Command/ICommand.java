/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

/**
 *
 * @author etudiant
 */
public interface ICommand {

    public void Execute();

    public void Undo();
}