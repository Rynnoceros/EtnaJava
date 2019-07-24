/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.ebenus.dao;

import com.cours.ebenus.dao.entities.Commande;
import java.util.List;

/**
 * Commande interface for DAO
 * @author soubri_j/martin_m
 */
public interface ICommandeDao {
    public List<Commande> findAllCommandes();

    public Commande findCommandeById(int idCommande);

    public List<Commande> findCommandeByIdProduit(Integer idProduit);
    
    public List<Commande> findCommandeByIdUtilisateur(Integer idUtilisateur);

    public Commande createCommande(Commande commande);

    public Commande updateCommande(Commande commande);

    public boolean deleteCommande(Commande commande);
}
