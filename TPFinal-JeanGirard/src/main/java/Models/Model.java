/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Observer.IObserver;
import Observer.ISubject;
import Parsers.IParser;
import Parsers.RPNParser;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author etudiant
 */
public class Model implements IModel, ISubject {

    private List<IObserver> observers;
    private HashMap<String, String> variables;
    private HashMap<String, String> constants;
    private List<String> expressions;
    private List<String> results;
    private final IParser parser;

    public Model() {
        expressions = new ArrayList<>();
        observers = new ArrayList<>();
        parser = new RPNParser();
        results = new ArrayList<>();
        variables = new HashMap<>();
        constants = new HashMap<>();
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
    public void setExpressions(List<String> expressions) {
        this.expressions = expressions;
        notifyObservers();
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

    @Override
    public HashMap<String, String> getVariables() {
        return variables;
    }

    @Override
    public void removeVariable(String variableName) {
        variables.remove(variableName);
        notifyObservers();
    }

    @Override
    public void addVariable(String variableName, String value) {
        if (!variables.containsKey(variableName)) {
            variables.put(variableName, value);
        }
        else {
            variables.replace(variableName, value);
        }
        notifyObservers();

    }

    @Override
    public HashMap<String, String> getConstants() {
        return constants;
    }

}
