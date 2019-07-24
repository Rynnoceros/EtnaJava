/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etna.mypenelope.core.entities;

import com.etna.mypenelope.core.interfaces.IPersonne;

/**
 *
 * @author soubri_j/martin_m
 */
public class AbstractGroupeMember {
    protected IPersonne member;
    
    public IPersonne getMember() {
        return this.member;
    }

    public void setMember(IPersonne member) {
        this.member = member;
    }
}
