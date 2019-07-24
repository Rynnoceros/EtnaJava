/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etna.mypenelope.core.dao.impl;

import com.etna.mypenelope.core.entities.Project;

/**
 * Project SQL Dao class.
 * @author soubri_j/martin_m
 */
public class ProjectSQLDao extends AbstractSQLDao<Project> {
    
    public ProjectSQLDao(Class<Project> t, String tableName) {
        super(t, tableName);
    }
    
}
