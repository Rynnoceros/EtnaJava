/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etna.mypenelope.core.dao.impl;

import com.etna.mypenelope.core.Constants;
import com.etna.mypenelope.core.entities.Groupe;
import com.etna.mypenelope.core.entities.Project;
import com.etna.mypenelope.core.entities.ProjectGroupe;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 * @author soubri_j/martin_m
 */
public class ProjectGroupeSQLDao extends AbstractSQLDao<ProjectGroupe>{
    private final GroupeSQLDao groupeDao = new GroupeSQLDao(Groupe.class, Constants.TABLE_GROUPES);
    
    
    public ProjectGroupeSQLDao(Class<ProjectGroupe> t, String tableName) {
        super(t, tableName);
    }
    
    public List<ProjectGroupe> findAllGroupes() {
        List<ProjectGroupe> all = super.findAll();
        
        for(ProjectGroupe tmp : all) {
            Groupe toFind = groupeDao.findById(tmp.getIdGroupe());
            if (toFind != null) {
                tmp.setGroupe(toFind);                
            }
        }
        return all;
    }
    
    public boolean deleteWhereProject(Project project) {
        boolean deleted = true;
        List<ProjectGroupe> all = super.findAll();
        
        all = all.stream().filter(filterByProject(project))
                .collect(Collectors.toList());
        for (ProjectGroupe tmp : all) {
            deleted &= delete(tmp);
        }
        
        return deleted;
    }
    
    private Predicate<ProjectGroupe> filterByProject(Project project) {
        return p -> p.getIdProject() == project.getIdProject();
    }
}
