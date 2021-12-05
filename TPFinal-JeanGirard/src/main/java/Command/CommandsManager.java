/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *
 * @author etudiant
 */
public class CommandsManager {

    private final Deque<ICommand> commandHistory;

    public CommandsManager() {
        commandHistory = new ArrayDeque<>();
    }

    public void ExecuteCommand(ICommand command) {
        command.Execute();
        commandHistory.push(command);
    }

    public void UndoCommand() {
        if (!commandHistory.isEmpty()) {
            commandHistory.pop().Undo();
        }
    }
}
