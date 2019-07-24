/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.ebenus.dao.manual.map.impl;

import com.cours.ebenus.dao.IDao;
import com.cours.ebenus.utils.Constants;
import com.cours.ebenus.utils.GenericObjectUtil;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ElHadji
 * @param <T>
 */
public abstract class AbstractMapDao<T> implements IDao<T> {

    private Map<Integer, T> myMap = null;
    private GenericObjectUtil<T> myUtil = null;

    public AbstractMapDao(Class<T> t, Map<Integer, T> myMap) {
        this.myMap = myMap;
        this.myUtil = new GenericObjectUtil<>(t);
    }

    /**
     * Method used to get all elements.
     * @return A list of elements
     */
    @Override
    public List<T> findAll() {
    	ArrayList<T> toReturn = new ArrayList<T>();
    	
    	if (this.myMap != null) {
    		toReturn = new ArrayList<T>(this.myMap.values());
    	}
    	
        return toReturn;
    }

    /**
     * Method used to find an element by its id
     * @param id The id to find
     * @return The object if ok, null otherwise
     */
    @Override
    public T findById(int id) {
        T instance = null;
        
        if (this.myMap != null) {
        	instance = this.myMap.get(id);
        }
        
        return instance;
    }

    /**
     * Method used to find elements by criteria
     * @param criteria The criteria used to search
     * @param valueCriteria The value to find
     * @return A list of element corresponding to the criteria
     */
    @Override
    public List<T> findByCriteria(String criteria, Object valueCriteria) {
        ArrayList<T> toReturn = new ArrayList<T>();
        
        if (this.myMap != null) {
        	if (this.myUtil != null) {
        		try {
					Field field = this.myUtil.getTheClass().getDeclaredField(criteria);
					if (field != null) {
						field.setAccessible(true);
						for (T instance : this.myMap.values()) {
							if (this.myUtil.equalsField(instance, criteria, valueCriteria)) {
								toReturn.add(instance);
							}
						}
					}
				} catch (NoSuchFieldException | SecurityException e) {
					e.printStackTrace();
				}
        	}
        }      
        return toReturn;
    }

    /**
     * Method used add an element to the list
     * @param t The element to add
     * @return The added element
     */
    @Override
    public T create(T t) {
    	T toCreate = null;
    	int newId = Constants.EXCEPTION_CODE_ELEMENT_ALREADY_EXIST;
    	
        if (t != null) {
        	newId = maxId();
    		newId++;
    		if (this.myUtil != null) {        			
    			try {
					Field tId = this.myUtil.getTheClass().getDeclaredField(Constants.ID + this.myUtil.getClassName());
					if (tId != null) {
						tId.setAccessible(true);
						tId.set(t, (Integer)newId);
						this.myMap.put(newId, t);
						toCreate = t;
					}
				} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
    		}
        }
        return toCreate;
    }

    /**
     * Method used to update an element
     * @param t The element to update
     * @return The updated element if found, null otherwise
     */
    @Override
    public T update(T t) {
    	T toUpdate = null;
    	int idTofind = 0;
    	
        if (this.myMap != null && this.myMap.size() > 0) {
        	if (this.myUtil != null) {
        		try {
					Field field = this.myUtil.getTheClass().getDeclaredField(Constants.ID + this.myUtil.getClassName());
					if (field != null) {
						field.setAccessible(true);
						idTofind = (Integer)field.get(t);
						toUpdate = this.myMap.replace(idTofind, t);
					}
				} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}
        }
        return toUpdate;
    }

    /**
     * Method used to delete an element from the list
     * @param t The element to delete
     * @return true if element was deleted, false otherwise
     */
    @Override
    public boolean delete(T t) {
    	boolean toReturn = false;
    	T instanceDeleted = null;
    	
    	if (t != null) {
	    	if (this.myMap != null && this.myUtil != null) {
	    		try {
					Field field = this.myUtil.getTheClass().getDeclaredField(Constants.ID + this.myUtil.getClassName());
					if (field != null) {
						field.setAccessible(true);
						int id = (Integer)field.get(t);
						instanceDeleted = this.myMap.remove(id);
						if (instanceDeleted != null) {
							toReturn = true;
						}
					}
				} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
	    	}
	    }
        return toReturn;
    }
    
    /**
     * Method used to return the maximum id of a list
     * @return the maximum id if ok, -1 otherwise
     */
    private int maxId() {
    	int iReturn = 0;
    	
    	if (this.myMap != null) {
    		for (int id : this.myMap.keySet()) {
    			if (id > iReturn) {
    				iReturn = id;
    			}
    		}
    	} 	
    	return iReturn;
    }
    
    /**
     * Method used to get the map of elements.
     * @return The map of elements.
     */
    public Map<Integer, T> getAll() {
    	return this.myMap;
    }
}
