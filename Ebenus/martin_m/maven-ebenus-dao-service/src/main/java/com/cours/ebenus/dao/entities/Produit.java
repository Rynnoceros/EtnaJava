/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.ebenus.dao.entities;

import com.cours.ebenus.dao.annotations.FieldName;
import com.cours.ebenus.dao.annotations.PrimaryKey;
import com.cours.ebenus.dao.annotations.TableName;

/**
 * Produit entity
 * @author soubri_j/martin_m
 */
@TableName(name = "Produit")
public class Produit {
    @PrimaryKey
    private Integer idProduit;
    @FieldName (name = "referenceProduit")
    private String reference;
    @FieldName (name = "prixProduit")
    private Double prix;
    @FieldName (name = "nomProduit")
    private String nom;
    @FieldName (name = "descriptionProduit")
    private String description;
    @FieldName (name = "stockProduit")
    private Integer stock;
    @FieldName (name = "activeProduit")
    private Boolean active;
    @FieldName (name = "marquerEffacerProduit")
    private Boolean marquerEffacer = false;
    @FieldName (name = "versionProduit")
    private Integer version = 1;

    public Produit() {
        
    }
    
    public Produit(Integer idProduit, String reference, Double prix, String nom, String description,
                   Integer stock, Boolean active, Boolean marquerEffacer, Integer version) {
        this.idProduit = idProduit;
        this.reference = reference;
        this.prix = prix;
        this.nom = nom;
        this.description = description;
        this.stock = stock;
        this.active = active;
        this.marquerEffacer = marquerEffacer;
        this.version = version;
    }
    
    public Produit(String reference, Double prix, String nom, String description) {
        this(null, reference, prix, nom, description, 0, false, false, 1);
    }
    
    /**
     * idProduit getter.
     * @return idProduit
     */
    public Integer getIdProduit() {
        return idProduit;
    }

    /**
     * reference getter.
     * @return String containing reference of the product
     */
    public String getReference() {
        return reference;
    }

    /**
     * prix getter.
     * @return Double containing the price of the product
     */
    public Double getPrix() {
        return prix;
    }

    /**
     * nom getter.
     * @return String containing name of the product
     */
    public String getNom() {
        return nom;
    }

    /**
     * description getter.
     * @return String containing the description of the product
     */
    public String getDescription() {
        return description;
    }

    /**
     * stock getter.
     * @return Integer containing current stock quantity of the product
     */
    public Integer getStock() {
        return stock;
    }

    /**
     * active getter.
     * @return active
     */
    public Boolean getActive() {
        return active;
    }

    /**
     * marquerEffacer getter.
     * @return marquerEffacer value
     */
    public Boolean getMarquerEffacer() {
        return marquerEffacer;
    }

    /**
     * version getter.
     * @return version of the product
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * Id produit setter
     * @param idProduit The id to set to the product
     */
    public void setIdProduit(Integer idProduit) {
        this.idProduit = idProduit;
    }

    /**
     * reference setter.
     * @param reference New reference value
     */
    public void setReference(String reference) {
        this.reference = reference;
    }

    /**
     * prix setter.
     * @param prix New prix value
     */
    public void setPrix(Double prix) {
        this.prix = prix;
    }

    /**
     * nom setter.
     * @param nom New nom value
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * description setter.
     * @param description New description value
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * stock setter.
     * @param stock New stock value
     */
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    /**
     * active setter.
     * @param active New active value
     */
    public void setActive(Boolean active) {
        this.active = active;
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
     * toString override.
     * @return String containing the product description
     */
    @Override 
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Product:\n");
        sb.append("--------\n");
        sb.append("Id: ").append(this.idProduit).append("\n");
        sb.append("Nom: ").append(this.nom).append("\n");
        sb.append("Reference: ").append(this.reference).append("\n");
        sb.append("Quantity: ").append(this.stock).append("\n");
        sb.append("Is active: ").append(this.active).append("\n");
        return sb.toString();
    }
    
    /**
     * hashCode override.
     * @return hashCode of the product
     */
    @Override 
    public int hashCode() {
        return this.idProduit.hashCode() + this.prix.hashCode() +
               this.stock.hashCode() + this.version.hashCode() +
               this.active.hashCode() + this.description.hashCode() +
               this.marquerEffacer.hashCode() + this.nom.hashCode() +
               this.reference.hashCode();
    }
    
    /**
     * equals override. Test equality between 2 products. Equality is based on id
     * @return true if the products are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Produit)) {
            return false;
        }
        Produit product = (Produit) obj;
        if ((this.idProduit == null && product.getIdProduit() != null) ||
            (this.idProduit != null && !this.idProduit.equals(product.getIdProduit()))) {
            return false;
        }
        return true;
    }
}
