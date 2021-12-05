/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Observer;

/**
 *
 * @author etudiant
 */
public interface ISubject {

    public void Attach(IObserver observateur);

    public void Detach(IObserver observateur);

    public void Notify();
}
