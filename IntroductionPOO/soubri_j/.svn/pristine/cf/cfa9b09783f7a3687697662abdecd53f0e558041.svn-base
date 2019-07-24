package com.cours.dao.factory;

import com.cours.dao.IPersonneDao;
import com.cours.dao.impl.csv.CsvPersonneDaoImpl;
import com.cours.observer.MySubjectObserver;
import com.cours.utils.Constants;

public class CsvDaoFactory extends AbstractDaoFactory {

    private IPersonneDao personneDao = null;
    private static MySubjectObserver subject = null;
    
    private CsvDaoFactory(MySubjectObserver s) {
    	subject = s;
    	this.personneDao = CsvPersonneDaoImpl.getInstance(subject);
    }
    
    private static class CsvDaoFactoryHolder {
    	private final static CsvDaoFactory instance = new CsvDaoFactory(subject);
    }
    
    public static CsvDaoFactory getInstance() {
    	return CsvDaoFactoryHolder.instance;
    }
    
    public static CsvDaoFactory getInstance(MySubjectObserver s) {
    	subject = s;
    	return CsvDaoFactoryHolder.instance;
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
