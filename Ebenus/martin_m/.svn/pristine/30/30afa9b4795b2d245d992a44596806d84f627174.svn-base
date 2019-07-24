/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.ebenus.dao.entities;

import com.cours.ebenus.dao.annotations.CreationDate;
import com.cours.ebenus.dao.annotations.FetchChild;
import com.cours.ebenus.dao.annotations.FieldName;
import com.cours.ebenus.dao.annotations.PrimaryKey;
import com.cours.ebenus.dao.annotations.TableName;
import com.cours.ebenus.dao.annotations.UpdateDate;
import java.util.Date;

/**
 * Utilisateur entity.
 * @author soubri_j/martin_m
 */
@TableName(name = "Utilisateur")
public class Utilisateur {
    @PrimaryKey
    private Integer idUtilisateur;
    @FieldName (name = "civiliteUtilisateur")
    private String civilite;
    @FieldName (name = "prenomUtilisateur")
    private String prenom;
    @FieldName (name = "nomUtilisateur")
    private String nom;
    @FieldName (name = "identifiantUtilisateur")
    private String identifiant;
    @FieldName (name = "motPasseUtilisateur")
    private String motPasse;
    @FieldName (name = "dateNaissanceUtilisateur")
    private Date dateNaissance;
    @CreationDate
    @FieldName (name = "dateCreationUtilisateur")
    private Date dateCreation;
    @UpdateDate
    @FieldName (name = "dateModificationUtilisateur")
    private Date dateModification;
    @FieldName (name = "actifUtilisateur")
    private Boolean actif = true;
    @FieldName (name = "marquerEffacerUtilisateur")
    private Boolean marquerEffacer = false;
    @FieldName (name = "versionUtilisateur")
    private Integer version = 0;
    @FetchChild(entity = Role.class, foreignKey = "idRole")
    private Role role;

    public Utilisateur() {
    }

    public Utilisateur(Integer idUtilisateur, String civilite, String prenom, String nom, String identifiant, String motPasse, Date dateNaissance, Date dateCreation, Date dateModification, Boolean actif, Boolean marquerEffacer, Integer version, Role role) {
        this.idUtilisateur = idUtilisateur;
        this.civilite = civilite;
        this.prenom = prenom;
        this.nom = nom;
        this.identifiant = identifiant;
        this.motPasse = motPasse;
        this.dateNaissance = dateNaissance;
        this.dateCreation = dateCreation;
        this.dateModification = dateModification;
        this.actif = actif;
        this.marquerEffacer = marquerEffacer;
        this.version = version;
        this.role = role;
    }
    
    public Utilisateur(Integer idUtilisateur, String civilite, String prenom, String nom, String identifiant, String motPasse, Date dateNaissance, Boolean actif, Boolean marquerEffacer, Integer version, Role role) {
        this(idUtilisateur, civilite, prenom, nom, identifiant, motPasse, dateNaissance, null, null, true, false, 0, role);
    }

    public Utilisateur(Integer idUtilisateur, String civilite, String prenom, String nom, String identifiant, String motPasse, Date dateNaissance, Role role) {
        this(idUtilisateur, civilite, prenom, nom, identifiant, motPasse, dateNaissance, null, null, true, false, 0, role);
    }

    public Utilisateur(String civilite, String prenom, String nom, String identifiant, String motPasse, Date dateNaissance, Role role) {
        this(null, civilite, prenom, nom, identifiant, motPasse, dateNaissance, null, null, true, false, 0, role);
    }

    public Utilisateur(String civilite, String prenom, String nom, String identifiant, String motPasse, Date dateNaissance) {
        this(null, civilite, prenom, nom, identifiant, motPasse, dateNaissance, null, null, true, false, 0, null);
    }

    public Utilisateur(Integer idUtilisateur) {
        this(idUtilisateur, null, null, null, null, null, null, null, null, true, false, 0, null);
    }
    
    /**
     * idUtilisateur getter.
     * @return idUtilisateur
     */
    public Integer getIdUtilisateur() {
        return idUtilisateur;
    }

    /**
     * civilite getter.
     * @return String containing civilite
     */
    public String getCivilite() {
        return civilite;
    }

    /**
     * prenom getter.
     * @return String containing prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * nom getter.
     * @return String containing nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * identifiant getter.
     * @return String containing identifiant
     */
    public String getIdentifiant() {
        return identifiant;
    }

    /**
     * motPasse getter.
     * @return String containing motPasse
     */
    public String getMotPasse() {
        return motPasse;
    }

    /**
     * dateNaissance getter.
     * @return dateNaissance
     */
    public Date getDateNaissance() {
        return dateNaissance;
    }

    /**
     * dateCreation getter.
     * @return dateCreation
     */
    public Date getDateCreation() {
        return dateCreation;
    }

    /**
     * dateModification getter.
     * @return dateModification
     */
    public Date getDateModification() {
        return dateModification;
    }

    /**
     * actif getter.
     * @return Boolean containing actif value 
     */
    public Boolean getActif() {
        return actif;
    }

    /**
     * marquerEffacer getter.
     * @return Boolean containing marquerEffacer value
     */
    public Boolean getMarquerEffacer() {
        return marquerEffacer;
    }

    /**
     * version getter.
     * @return version
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * role getter.
     * @return null if no role is associated to utilisateur, the role otherwise
     */
    public Role getRole() {
        return role;
    }

    /**
     * civilite setter
     * @param civilite New civilite value 
     */
    public void setCivilite(String civilite) {
        this.civilite = civilite;
    }

    /**
     * prenom setter.
     * @param prenom New prenom value
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * nom setter.
     * @param nom New nom value
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * identifiant setter.
     * @param identifiant New identifiant value
     */
    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    /**
     * motPasse setter.
     * @param motPasse New motPasse value
     */
    public void setMotPasse(String motPasse) {
        this.motPasse = motPasse;
    }

    /**
     * dateNaissance setter.
     * @param dateNaissance New dateNaissance value
     */
    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    /**
     * dateCreation setter.
     * @param dateCreation New dateCreation value
     */
    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    /**
     * dateModification setter.
     * @param dateModification New dateModification value
     */
    public void setDateModification(Date dateModification) {
        this.dateModification = dateModification;
    }

    /**
     * actif setter.
     * @param actif New actif value
     */
    public void setActif(Boolean actif) {
        this.actif = actif;
    }

    /**
     * marquerEffacer setter.
     * @param marquerEffacer New marquerEffacer value
     */
    public void setMarquerEffacer(Boolean marquerEffacer) {
        this.marquerEffacer = marquerEffacer;
    }

    /**
     * version setter.
     * @param version New version value
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * role setter.
     * @param role New role value
     */
    public void setRole(Role role) {
        this.role = role;
    }

    public void setIdUtilisateur(Integer idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }
    
    
    
    /**
     * toString override.
     * @return String containing description of the object
     */
    @Override
    public String toString() {
        return this.prenom + " " + this.nom;
    } 
    
    /**
     * hashCode override.
     * @return hashCode of the object
     */
    @Override
    public int hashCode() {
        return this.idUtilisateur.hashCode() + this.actif.hashCode() +
               this.civilite.hashCode() + this.dateCreation.hashCode() +
               this.dateModification.hashCode() + this.dateNaissance.hashCode() +
               this.identifiant.hashCode() + this.marquerEffacer.hashCode() +
               this.motPasse.hashCode() + this.nom.hashCode() +
               this.prenom.hashCode() + this.role.hashCode() +
               this.version.hashCode();
    }
    
    /**
     * equals override. Test equality between 2 objects. Equality is based on id
     * @param obj The object to compare
     * @return true if objects are equals, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Utilisateur)) {
            return false;
        }
        Utilisateur utilisateur = (Utilisateur)obj;
        if ((this.idUtilisateur == null && utilisateur.getIdUtilisateur() != null) ||
            (this.idUtilisateur != null && !this.idUtilisateur.equals(utilisateur.getIdUtilisateur()))) {
            return false;
        }
        return true;
    }
}
