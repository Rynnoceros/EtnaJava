/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.ebenus.dao;

import com.cours.ebenus.dao.entities.Produit;
import java.util.List;

/**
 * Produit interface for DAO
 * @author soubri_j/martin_m
 */
public interface IProduitDao {
    public List<Produit> findAllProduits();

    public Produit findProduitById(int idProduit);

    public List<Produit> findProduitByReference(String reference);

    public Produit createProduit(Produit produit);

    public Produit updateProduit(Produit produit);

    public boolean deleteProduit(Produit produit);
}
