/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etna.mypenelope.core.dao;

import java.util.List;

/**
 * Dao interface
 * @author soubri_j/martin_m
 */
public interface IDao<T> {
    public List<T> findAll();

    public T findById(int id);

    public List<T> findByCriteria(String criteria, Object valueCriteria);

    public T create(T t);

    public T update(T t);

    public boolean delete(T t);
}
