/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.ebenus.dao.manual.list.impl;

import com.cours.ebenus.dao.IDao;
import com.cours.ebenus.utils.Constants;
import com.cours.ebenus.utils.GenericObjectUtil;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ElHadji
 * @param <T>
 */
public abstract class AbstractListDao<T> implements IDao<T> {

    private List<T> myList = null;
    private GenericObjectUtil<T> myUtil = null;

    public AbstractListDao(Class<T> t, List<T> myList) {
        this.myList = myList;
        this.myUtil = new GenericObjectUtil<T>(t);
    }

    /**
     * Return the list of all T
     */
    @Override
    public List<T> findAll() {
        return this.myList;
    }

    /**
     * Returns the instance of T with the id.
     */
    @Override
    public T findById(int id) {
    	T instance = null;
    	
    	if (this.myList != null && this.myUtil != null) {
    		for (T t : this.myList) {
				if (this.myUtil.equalsField(t, Constants.ID + this.myUtil.getClassName(), id)) {
					instance = t;
					break;
				}
			}
    	}
    	return instance;
    }

    /**
     * Method used to find an object on a criteria
     * @param criteria : Criteria's name
     * @param valueCriteria : The value to find
     * @return List of T if found , null otherwise;
     */
    @Override
    public List<T> findByCriteria(String criteria, Object valueCriteria) {
    	List<T> listToReturn = new ArrayList<T>();
    	
    	if (this.myList != null && this.myUtil != null) {
			for (T instance : this.myList) {
				if (this.myUtil.equalsField(instance, criteria, valueCriteria)) {
					listToReturn.add(instance);
				}
			}
		}
    	return listToReturn;
    }

    /**
     * Add a T element in the list. 
     * @return The element if ok, null otherwise;
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
						this.myList.add(t);
						toCreate = t;
					}
				} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		}
        }
        return toCreate;
    }

    /**
     * Update an element of the list
     * @param t : The element to update
     * @return The updated element if ok, null otherwise
     */
    @Override
    public T update(T t) {
    	T toUpdate = null;
    	int idToFind = 0;
    	
    	if (t != null) {
    		if (this.myList != null && this.myUtil != null) {
    			try {
					Field fToFind = this.myUtil.getTheClass().getDeclaredField(Constants.ID + this.myUtil.getClassName());
					if (fToFind != null) {
						fToFind.setAccessible(true);
						idToFind = (Integer)fToFind.get(t);
						toUpdate = findById(idToFind);
						toUpdate = t;
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
     * Delete an element from the list
     * @param t : The element to delete
     * @return true if the element was found and deleted, false otherwise
     */
    @Override
    public boolean delete(T t) {
    	boolean deleted = false;
    	int idToDelete = 0;
    	
    	if (t != null) {
    		if (this.myList != null && this.myUtil != null) {
    			try {
					Field fToFind = this.myUtil.getTheClass().getDeclaredField(Constants.ID + this.myUtil.getClassName());
					if (fToFind != null) {
						fToFind.setAccessible(true);
						idToDelete = (Integer)fToFind.get(t);
						deleted = this.myList.removeIf(this.myUtil.filterId(idToDelete));
					}
				} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		}
    	}
        return deleted;
    }
    
    /**
     * Method used to return the maximum id of a list
     * @return the maximum id if ok, -1 otherwise
     */
    private int maxId() {
    	int iReturn = 0;
    	
    	if (this.myList != null && this.myUtil != null) {
    		Field field;
			try {
				field = this.myUtil.getTheClass().getDeclaredField(Constants.ID + this.myUtil.getClassName());
				if (field != null) {
					field.setAccessible(true);
					for (T instance : this.myList) {
						int currentId = (Integer)field.get(instance);
						if (currentId > iReturn) {
							iReturn = currentId;
						}
					}
				}
			} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
    	}  	
    	return iReturn;
    }
}
