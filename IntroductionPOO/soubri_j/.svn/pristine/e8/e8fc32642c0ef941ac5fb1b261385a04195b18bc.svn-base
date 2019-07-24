package com.cours.dao.factory;

import com.cours.dao.IPersonneDao;
import com.cours.dao.impl.json.JsonPersonneDaoImpl;
import com.cours.observer.MySubjectObserver;
import com.cours.utils.Constants;

public class JsonDaoFactory extends AbstractDaoFactory {

    private IPersonneDao personneDao = null;
    private static MySubjectObserver subject = null;

    
    private JsonDaoFactory(MySubjectObserver s) {
    	subject = s;
        this.personneDao = JsonPersonneDaoImpl.getInstance(subject);
    }
    
    private static class JsonDaoFactoryHolder {
    	private final static JsonDaoFactory instance = new JsonDaoFactory(subject);
    }
    
    public static JsonDaoFactory getInstance() {
    	return JsonDaoFactoryHolder.instance;
    }
    
    public static JsonDaoFactory getInstance(MySubjectObserver s) {
    	subject = s;
    	return JsonDaoFactoryHolder.instance;
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
