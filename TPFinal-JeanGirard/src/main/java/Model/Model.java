/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Observer.IObserver;
import Observer.ISubject;
import Model.Parsers.IParser;
import Model.Parsers.RPNParser;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author etudiant
 */
public class Model implements ISubject {

    private List<IObserver> observers;
    public List<String> expressions;
    public List<String> results;
    public IParser parser;

    public Model() {
        expressions = new ArrayList<>();
        observers = new ArrayList<>();
        parser = new RPNParser();
        results = new ArrayList<>();
    }

    @Override
    public void Attach(IObserver observateur) {
        observers.add(observateur);
    }

    @Override
    public void Detach(IObserver observateur) {
        observers.remove(observateur);
    }

    @Override
    public void Notify() {
        observers.forEach(observer -> {
            observer.Refresh();
        });
    }
}
