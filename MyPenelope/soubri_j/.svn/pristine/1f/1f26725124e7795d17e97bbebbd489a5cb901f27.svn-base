package com.etna.mypenelope.core.entities;

import com.etna.mypenelope.core.interfaces.IPersonne;

/**
 *
 * @author soubri_j/martin_m
 */
public class Utilisateur implements IPersonne {
    protected Integer idUtilisateur;
    protected String prenom;
    protected String nom;
    protected String mail;
    protected String motPasse;
    protected Integer admin;
    
        
    public Utilisateur() {
    }
    
    public Utilisateur(int idUtilisateur, String prenom, String nom, String mail, String mdp, int admin){
        this.idUtilisateur = idUtilisateur;
        this.prenom = prenom;
        this.nom = nom;
        this.mail = mail;
        this.motPasse = mdp;
        this.admin = admin;
    }
    
    public int getIdUtilisateur(){
        return idUtilisateur;
    }
    
    @Override
    public String getPrenom() {
        return prenom;
    }

    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public String getMail() {
        return mail;
    }
    
    public String getMdp(){
        return motPasse;
    }
    
    public int getAdmin(){
        return admin;
    }  
    
    public void setIdUtilisateur(int idUtilisateur){
        this.idUtilisateur = idUtilisateur;
    }
    
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
    
    
    public void setMdp(String mdp){
        this.motPasse = mdp;
    }
    
    public void setAdmin(int admin){
        this.admin = admin;
    }
    
    @Override
    public String toString() {
	//String str = "Je suis un objet de la " + this.getClass() +", j'ai l'id n°"+ this.idUtilisateur +", je m'appelle "+ this.prenom +" "+ this.nom +", mon mail: "+ this.mail +", mon mot de passe: "+ this.motPasse +", mon statue d'admin: "+ this.admin;
        String str = this.prenom + " " + this.nom;
	return str;	
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Utilisateur other = (Utilisateur) obj;
        if (idUtilisateur != other.idUtilisateur)
            return false;
        return true;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (idUtilisateur );
        return result;
    }
    
    public Integer getId() {
        return getIdUtilisateur();
    }
}
