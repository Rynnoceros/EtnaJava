package com.cours.dao.impl.json;

import com.cours.dao.IPersonneDao;
import com.cours.entities.Personne;
import com.cours.observer.MySubjectObserver;
import com.cours.utils.Constants;
import java.util.List;

public class JsonPersonneDaoImpl extends AbstractJsonDao<Personne> implements IPersonneDao {

    private static final String personnesJsonPathFile = Constants.PERSONNES_JSON_PATH_FILE;
    private static MySubjectObserver subject = null;
    private boolean sendNotification = true;
    
    private JsonPersonneDaoImpl() {
    	super(Personne.class, personnesJsonPathFile);
    }

    private JsonPersonneDaoImpl(MySubjectObserver s) {
        super(Personne.class, s, personnesJsonPathFile);
        subject = s;
    }
    
    private static class JsonPersonneDaoImplHolder {
    	private final static JsonPersonneDaoImpl instance = new JsonPersonneDaoImpl(subject);
    }
    
    public static JsonPersonneDaoImpl getInstance() {
    	return JsonPersonneDaoImplHolder.instance;
    }
    
    public static JsonPersonneDaoImpl getInstance(MySubjectObserver s) {
    	subject = s;
    	return JsonPersonneDaoImplHolder.instance;
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
    public List<Personne> findAll() {
    	return super.findAll();
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
