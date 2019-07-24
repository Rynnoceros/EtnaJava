/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etna.mypenelope.core.dao.impl;

import com.etna.mypenelope.core.entities.Groupe;

/**
 * GroupeSQLDao class.
 * @author soubri_j/martin_m
 */
public class GroupeSQLDao extends AbstractSQLDao<Groupe> {
    
    public GroupeSQLDao(Class<Groupe> t, String tableName) {
        super(t, tableName);
    }
    
}
