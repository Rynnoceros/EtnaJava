/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.ebenus.factory;

import com.cours.ebenus.dao.IRoleDao;
import com.cours.ebenus.dao.IUtilisateurDao;
import com.cours.ebenus.dao.impl.RoleDao;
import com.cours.ebenus.dao.impl.UtilisateurDao;

/**
 *
 * @author ElHadji
 */
public class DaoFactory extends AbstractDaoFactory {

	private DaoFactory() {
		
	}

	private static class DaoFactoryHolder {
		private static final DaoFactory instance = new DaoFactory();
	}
	
	public static DaoFactory getInstance() {
		return DaoFactoryHolder.instance;
	}
	
    @Override
    public IUtilisateurDao getUtilisateurDao() {
        return UtilisateurDao.getInstance();
    }

    @Override
    public IRoleDao getRoleDao() {
        return RoleDao.getInstance();
    }
}
