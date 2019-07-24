/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.observer;

import com.cours.entities.Personne;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author elhad
 */
public class MySubjectObserver {

    private List<MyObserver> observers = new ArrayList<MyObserver>();
    private static int state;
    private static Personne person;
    
    public int getState() {
        return state;
    }

    public void setState(int s) {
    	state = s;
        notifyAllObservers();
    }

    public Personne getPerson() {
        return person;
    }

    public void setPerson(Personne p) {
        person = p;
    }

    public void addObserveur(MyObserver observer) {
        observers.add(observer);
    }

    public void notifyAllObservers() {
        for (MyObserver observer : observers) {
            observer.updateSource();
        }
    }
}
