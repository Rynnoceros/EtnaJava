package com.cours.dao.factory;

import com.cours.dao.IPersonneDao;
import com.cours.dao.impl.xml.XmlPersonneDaoImpl;
import com.cours.observer.MySubjectObserver;
import com.cours.utils.Constants;

public class XmlDaoFactory extends AbstractDaoFactory {

    private IPersonneDao personneDao = null;
    private static MySubjectObserver subject = null;

    private XmlDaoFactory(MySubjectObserver s) {
    	subject = s;
        this.personneDao = XmlPersonneDaoImpl.getInstance(subject);
    }
    
    private static class XmlDaoFactoryHolder {
    	private final static XmlDaoFactory instance = new XmlDaoFactory(subject);
    }
    
    public static XmlDaoFactory getInstance() {
    	return XmlDaoFactoryHolder.instance;
    }
    
    public static XmlDaoFactory getInstance(MySubjectObserver s) {
    	subject = s;
    	return XmlDaoFactoryHolder.instance;
    }

    @Override
    public IPersonneDao getPersonneDao() {
        return personneDao;
    }

    @Override
    public void updateSource() {
		personneDao.setSendNotification(false);
    	switch (subject.getState()) {
    		case Constants.DELETE : // DELETE
    			personneDao.delete(subject.getPerson());
    			break;
    		case Constants.CREATE : // CREATE
    			personneDao.create(subject.getPerson());
    			break;
    		default:
    			System.out.println("I don't know what to do");
    			break;
    	}
		personneDao.setSendNotification(true);
    }
}
