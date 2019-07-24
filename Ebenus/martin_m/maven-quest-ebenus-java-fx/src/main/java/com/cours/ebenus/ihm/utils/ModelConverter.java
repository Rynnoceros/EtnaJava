package com.cours.ebenus.ihm.utils;

import java.text.ParseException;
import java.util.List;

import com.cours.ebenus.dao.entities.Role;
import com.cours.ebenus.dao.entities.Utilisateur;
import com.cours.ebenus.models.UserModel;
import com.cours.ebenus.service.IServiceFacade;
import com.cours.ebenus.service.ServiceFacade;

public class ModelConverter {
	
	private static IServiceFacade serviceFacade = null;
	
	private ModelConverter() {
		serviceFacade = new ServiceFacade();
	}
	
	private static final class ModelConverterHolder {
		private final static ModelConverter instance = new ModelConverter();
	}
	
	public static ModelConverter getInstance() {
		return ModelConverterHolder.instance;
	}
	
	public Utilisateur convertUserModel(UserModel user) {
		Utilisateur converted = null;
		
		if (user != null) {
			converted = new Utilisateur();
			converted.setIdUtilisateur(user.getIdUtilisateur());
			converted.setCivilite(user.getCivilite());
			try {
				if (user.getDateCreation() != null) {
					converted.setDateCreation(user.getDateFormat().parse(user.getDateCreation()));	
				}
				if (user.getDateModification() != null) {
					converted.setDateModification(user.getDateFormat().parse(user.getDateModification()));	
				}
				if (user.getDateNaissance() != null) {
					converted.setDateNaissance(user.getDateFormat().parse(user.getDateNaissance()));					
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			converted.setIdentifiant(user.getIdentifiant());
			converted.setMotPasse(user.getMotPasse());
			converted.setNom(user.getNom());
			converted.setPrenom(user.getPrenom());
			List<Role> roles = serviceFacade.getRoleDao().findRoleByIdentifiant(user.getRole());
			if (roles != null && roles.size() > 0) {
				converted.setRole(roles.get(0));	
			}
		}
		
		return converted;
	}
	
	public UserModel convertUtilisateur(Utilisateur user) {
		UserModel converted = null;
		
		if (user != null) {
			converted = new UserModel();
			converted.setIdUtilisateur(user.getIdUtilisateur());
			converted.setCivilite(user.getCivilite());
			if (user.getDateCreation() != null) {
				converted.setDateCreation(converted.getDateFormat().format(user.getDateCreation()));	
			}
			if (user.getDateModification() != null) {
				converted.setDateModification(converted.getDateFormat().format(user.getDateModification()));	
			}
			if (user.getDateNaissance() != null) {
				converted.setDateNaissance(converted.getDateFormat().format(user.getDateNaissance()));					
			}
			converted.setIdentifiant(user.getIdentifiant());
			converted.setMotPasse(user.getMotPasse());
			converted.setNom(user.getNom());
			converted.setPrenom(user.getPrenom());
			converted.setRole(user.getRole().getIdentifiant());	
		}
		
		return converted;
	}
}
