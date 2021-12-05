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
public class Model implements IModel, ISubject {

    private List<IObserver> observers;
    private List<String> expressions;
    private List<String> results;
    private IParser parser;

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

    @Override
    public List<String> GetExpressions() {
        return expressions;
    }

    @Override
    public List<String> GetResults() {
        return results;
    }

    @Override
    public void AddExpression(String expression) {
        expressions.add(expression);
        Notify();
    }

    @Override
    public void AddResult(String result) {
        results.add(result);
        Notify();

    }

    @Override
    public IParser GetParser() {
        return parser;
    }
}
