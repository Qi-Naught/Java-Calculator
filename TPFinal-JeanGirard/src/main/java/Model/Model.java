/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Observer.IObserver;
import Observer.ISubject;
import Parsers.IParser;
import Parsers.RPNParser;
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
    public void attach(IObserver observateur) {
        observers.add(observateur);
    }

    @Override
    public void detach(IObserver observateur) {
        observers.remove(observateur);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(observer -> {
            observer.refresh();
        });
    }

    @Override
    public List<String> getExpressions() {
        return expressions;
    }

    @Override
    public List<String> getResults() {
        return results;
    }

    @Override
    public void addExpression(String expression) {
        expressions.add(expression);
        notifyObservers();
    }

    @Override
    public void addResult(String result) {
        results.add(result);
        notifyObservers();
    }

    @Override
    public IParser getParser() {
        return parser;
    }

    @Override
    public void removeExpression(String expression) {
        expressions.remove(expression);
        notifyObservers();
    }

    @Override
    public void removeResult(String result) {
        results.remove(result);
        notifyObservers();
    }
}
