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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author etudiant
 */
public class Model implements IModel, ISubject {

    private final List<IObserver> observers;
    private Map<String, String> variables;
    private Map<String, String> constants;
    private List<String> expressionHistory;
    private final List<String> results;
    private final IParser parser;

    public Model() {
        expressionHistory = new ArrayList<>();
        observers = new ArrayList<>();
        parser = new RPNParser();
        results = new ArrayList<>();
        variables = new LinkedHashMap<>();
        constants = new LinkedHashMap<>();
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
        return expressionHistory;
    }

    @Override
    public void setExpressions(List<String> expressions) {
        this.expressionHistory = expressions;
        notifyObservers();
    }

    @Override
    public List<String> getResults() {
        return results;
    }

    @Override
    public void addExpression(String expression) {
        expressionHistory.add(expression);
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
    public void removeLastExpression() {
        if (!expressionHistory.isEmpty()) {
            expressionHistory.remove(expressionHistory.size() - 1);
            notifyObservers();
        }
    }

    @Override
    public void removeLastResult() {
        if (!results.isEmpty()) {
            results.remove(results.size() - 1);
            notifyObservers();
        }
    }

    @Override
    public Map<String, String> getVariables() {
        return variables;
    }

    @Override
    public void removeLastVariable() {
        if (!variables.isEmpty()) {
            Iterator<String> iter = variables.keySet().iterator();
            String lastKey = "";
            while (iter.hasNext()) {
                lastKey = iter.next();
            }
            variables.remove(lastKey);
            notifyObservers();
        }
    }

    @Override
    public void addVariable(String variableName, String value
    ) {
        if (!variables.containsKey(variableName)) {
            variables.put(variableName, value);
        }
        else {
            variables.replace(variableName, value);
        }
        notifyObservers();

    }

    @Override
    public Map<String, String> getConstants() {
        return constants;
    }

    @Override
    public void setConstants(Map<String, String> consts
    ) {
        this.constants = consts;
        notifyObservers();
    }

    @Override
    public void setVars(Map<String, String> vars
    ) {
        this.variables = vars;
        notifyObservers();
    }

}
