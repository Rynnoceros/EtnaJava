/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.ebenus.dao.entities;

/**
 *
 * @author elhad
 */
public class Role {

    private static final long serialVersionUID = 1L;
    private Integer idRole;
    private String identifiant;
    private String description;
    private Integer version = 0;

    public Role() {
    }

    public Role(Integer idRole, String identifiant, String description) {
        this.idRole = idRole;
        this.identifiant = identifiant;
        this.description = description;
    }

    public Role(String identifiant, String description) {
        this(null, identifiant, description);
    }

    public Role(Integer idRole) {
        this(idRole, null, null);
    }

    public Integer getIdRole() {
        return idRole;
    }

    public void setIdRole(Integer idRole) {
        this.idRole = idRole;
    }

    public String getIdentifiant() {
        return (this.identifiant);
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getDescription() {
        return (this.description);
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
    
    /**
     * Method used return a string description of the role
     */
    public String toString() {
    	StringBuilder sb = new StringBuilder();
    	sb.append("Id Role : " + this.idRole);
    	sb.append("Identifiant role : " + this.identifiant);
    	sb.append("Description : " + this.description);
    	return sb.toString();
    }
    
    /**
     * Method used to check equality between 2 roles. Equality is based on their id.
     * @param role The role to compare to
     * @return true if role is equal, false otherwise
     */
    public boolean equals(Role role) {
    	boolean isEqual = false;
    	
    	if (role != null) {
    		isEqual = (this.idRole == role.getIdRole());
    	}
    	
    	return isEqual;
    }
    
    /**
     * Method used to get an hascode of the tole
     * @return an integer representing the role
     */
    public int hashCode() {
    	return this.idRole * 7;
    }
}
