/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.ebenus.dao.entities;

import com.cours.ebenus.dao.annotations.FetchChild;
import com.cours.ebenus.dao.annotations.FieldName;
import com.cours.ebenus.dao.annotations.PrimaryKey;
import com.cours.ebenus.dao.annotations.TableName;
import com.cours.ebenus.dao.annotations.UpdateDate;
import java.util.Date;

/**
 * Commande entity.
 * @author soubri_j/martin_m
 */
@TableName(name = "Commande")
public class Commande {
    @PrimaryKey
    private Integer idCommande;
    @FieldName (name = "totalCommande")
    private Double totalCommande;
    @FieldName (name = "statutCommande")
    private String statut;
    @FieldName (name = "dateCommande")
    private Date dateCommande;
    @UpdateDate
    @FieldName (name = "dateModificationCommande")
    private Date dateModification;
    @FieldName (name = "versionCommande")
    private Integer version;
    @FetchChild (entity = Utilisateur.class, foreignKey = "idUtilisateur")
    private Utilisateur utilisateur;
    @FetchChild (entity = Adresse.class, foreignKey = "idAdresse")
    private Adresse adresse;

    public Commande() {
        
    }
    
    public Commande(Integer idCommande, Double totalCommande, String statut, Date dateCommande, Date dateModification,
                    Integer version, Utilisateur utilisateur, Adresse adresse) {
        this.idCommande = idCommande;
        this.totalCommande = totalCommande;
        this.statut = statut;
        this.dateCommande = dateCommande;
        this.dateModification = dateModification;
        this.version = version;
        this.utilisateur = utilisateur;
        this.adresse = adresse;
    }
    
    public Commande(Double totalCommande, String statut) {
        this(null, totalCommande, statut, null, null, 1, null, null);
    }
    
    /**
     * idCommande getter.
     * @return idCommande
     */
    public Integer getIdCommande() {
        return idCommande;
    }

    /**
     * totalCommande getter.
     * @return Double containing total command value
     */
    public Double getTotalCommande() {
        return totalCommande;
    }

    /**
     * statut getter.
     * @return String containing command status
     */
    public String getStatut() {
        return statut;
    }

    /**
     * dateCommande getter.
     * @return dateCommande
     */
    public Date getDateCommande() {
        return dateCommande;
    }

    /**
     * dateModification getter.
     * @return dateModification
     */
    public Date getDateModification() {
        return dateModification;
    }

    /**
     * verion getter.
     * @return version
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * utilisateur getter.
     * @return Utilisateur that passed the command
     */
    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    /**
     * adresse getter.
     * @return Delivery address
     */
    public Adresse getAdresse() {
        return adresse;
    }

    /**
     * IdCommande setter
     * @param idCommande The id to set
     */
    public void setIdCommande(Integer idCommande) {
        this.idCommande = idCommande;
    }
    
    /**
     * totalCommande setter.
     * @param totalCommande New totalCommande value
     */
    public void setTotalCommande(Double totalCommande) {
        this.totalCommande = totalCommande;
    }

    /**
     * statut setter.
     * @param statut New status value
     */
    public void setStatut(String statut) {
        this.statut = statut;
    }

    /**
     * dateCommande setter.
     * @param dateCommande New dateCommande value
     */
    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    /**
     * dateModification setter.
     * @param dateModification New dateModification value
     */
    public void setDateModification(Date dateModification) {
        this.dateModification = dateModification;
    }

    /**
     * version setter.
     * @param version New version value
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * utilisateur setter.
     * @param utilisateur New utilisateur value
     */
    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    /**
     * adresse setter.
     * @param adresse New adresse value
     */
    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }
    
    /**
     * toString override.
     * @return String containing command description
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Commande:\n");
        sb.append("Id: ").append(this.idCommande).append("\n");
        sb.append("Statut: ").append(this.statut).append("\n");
        sb.append("Total: ").append(this.totalCommande).append("\n");
        sb.append("Date commande: ").append(this.dateCommande).append("\n");
        sb.append("Date modification: ").append(this.dateModification).append("\n");
        return sb.toString();
    }
    
    /**
     * hashCode override.
     * @return hashCode of the command
     */
    @Override
    public int hashCode() {
        return this.idCommande.hashCode() + this.totalCommande.hashCode() +
               this.version.hashCode() + this.adresse.hashCode() +
               this.dateCommande.hashCode() + this.dateModification.hashCode() +
               this.statut.hashCode() + this.utilisateur.hashCode();
    }
    
    /**
     * equals override. Test between 2 commands. Equality is based on id.
     * @param obj The command to compare
     * @return true if commands are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Commande)) {
            return false;
        }
        Commande commande = (Commande)obj;
        if ((this.idCommande == null && commande.getIdCommande() != null) ||
            (this.idCommande != null && !this.idCommande.equals(commande.getIdCommande()))) {
            return false;
        }    
        return true;
    }
    
    /**
     * Commande statut enumeration
     */
    public enum CommandeStatut {
        Temporaire("T"),
        Valide("V");
        
        private final String value;
        CommandeStatut(final String s) {
            value = s;
        }
        
        public String toString() {
            return value;
        }
    }
}
