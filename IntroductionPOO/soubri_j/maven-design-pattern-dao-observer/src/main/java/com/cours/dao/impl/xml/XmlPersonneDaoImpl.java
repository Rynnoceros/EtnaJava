package com.cours.dao.impl.xml;

import com.cours.dao.IPersonneDao;
import com.cours.entities.Personne;
import com.cours.observer.MySubjectObserver;
import com.cours.utils.Constants;

import java.util.Comparator;
import java.util.List;

public class XmlPersonneDaoImpl extends AbstractXmlDao<Personne> implements IPersonneDao {

    private static final String personnesXmlPathFile = Constants.PERSONNES_XML_PATH_FILE;
    private static MySubjectObserver subject = null;
    private boolean sendNotification = true;

    private XmlPersonneDaoImpl() {
    	super(Personne.class, personnesXmlPathFile);
    }

    private XmlPersonneDaoImpl(MySubjectObserver s) {
        super(Personne.class, s, personnesXmlPathFile);
        subject = s;
    }
    
    private static class XmlPersonneDaoImplHolder {
    	private final static XmlPersonneDaoImpl instance = new XmlPersonneDaoImpl(subject);
    }
    
    public static XmlPersonneDaoImpl getInstance() {
    	return XmlPersonneDaoImplHolder.instance;
    }

    public static XmlPersonneDaoImpl getInstance(MySubjectObserver s) {
    	subject = s;
    	return XmlPersonneDaoImplHolder.instance;
    }
    
    @Override
    public List<Personne> findAll() {
    	return super.findAll();
    }

    @Override
    public Personne findById(int idPersonne) {
        return super.findById(idPersonne);
    }

    @Override
    public Personne create(Personne obj) {
    	Personne toReturn = null;
    	if (obj != null) {
    		obj.setId(generateIdNewPersonne());
    	}
        toReturn = super.create(obj);
        if (toReturn != null) {
        	notifyObservers(obj, Constants.CREATE);
        }
        return toReturn;
    }

    @Override
    public boolean delete(Personne person) {
    	boolean deleted = super.delete(person);
    	if (deleted) {
    		notifyObservers(person, Constants.DELETE);
    	}
        return deleted;
    }

    @Override
    public int generateIdNewPersonne() {
    	allInstances = findAll();
    	return maxId() + 1;
    }
    
    @Override
    public boolean sendNotification() {
        return sendNotification;
    }

    @Override
    public void setSendNotification(boolean sendNotification) {
        this.sendNotification = sendNotification;
    }
    
    private void notifyObservers(Personne person, int state)
    {
    	if (sendNotification && subject != null) {
    		subject.setPerson(person);
    		subject.setState(state);
    	}
    }
}
