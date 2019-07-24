/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.ebenus.dao.manual.array.impl;

import com.cours.ebenus.dao.IDao;
import com.cours.ebenus.utils.Constants;
import com.cours.ebenus.utils.GenericObjectUtil;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author ElHadji
 * @param <T>
 */
public abstract class AbstractArrayDao<T> implements IDao<T> {

    private T[] myArray = null;
    private GenericObjectUtil<T> myUtil = null;

    public AbstractArrayDao(Class<T> t, T[] myArray) {
        this.myArray = myArray;
        this.myUtil = new GenericObjectUtil<T>(t);
    }

    /**
     * Return the list of all T
     */
    @Override
    public List<T> findAll() {
        return Arrays.asList(this.myArray);
    }

    /**
     * Returns the instance of T with the id.
     */
    @Override
    public T findById(int id) {
        T found = null;
        
        if (this.myArray != null && this.myArray.length > 0) {
        	if (this.myUtil != null) {        		
        		try {
        			Field field = this.myUtil.getTheClass().getDeclaredField(Constants.ID + this.myUtil.getClassName());
        			if (field != null) {
        				field.setAccessible(true);
                		for (T instance : this.myArray) {   
                			if (((Integer)field.get(instance)) == id) {
                				found = instance;
                				break;
                			}
                		}
        			}
        		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
        			// TODO Auto-generated catch block
        			e.printStackTrace();
        		}
        	}
        }
        
        return found;
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
    	
    	if (this.myArray != null && this.myArray.length > 0) {
    		if (this.myUtil != null) {
    			for (T instance : this.myArray) {   
    				if (this.myUtil.equalsField(instance, criteria, valueCriteria)) {
    					listToReturn.add(instance);
    				}
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
						this.myArray = append(this.myArray, t);
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
     * Method used to add an element at the end of an array
     * @param tab The tab to add the element to
     * @param element The element to add
     * @return A new array containing the element
     */
    private T[] append(T[] tab, T element) {
    	T[] toReturn = Arrays.copyOf(tab, tab.length + 1);
    	toReturn[tab.length] = element;
    	return toReturn;
    }

    /**
     * Method used to update an element.
     * The element is filtered by its id.
     */
    @Override
    public T update(T t) {
    	T toUpdate = null;
    	int idTofind = 0;
    	
        if (this.myArray != null && this.myArray.length > 0) {
        	if (this.myUtil != null) {
        		try {
					Field field = this.myUtil.getTheClass().getDeclaredField(Constants.ID + this.myUtil.getClassName());
					if (field != null) {
						field.setAccessible(true);
						idTofind = (Integer)field.get(t);
						for (int i = 0; i < this.myArray.length; ++i) {
							if (this.myUtil.equalsField(this.myArray[i], Constants.ID + this.myUtil.getClassName(), idTofind)) {
								this.myArray[i] = t;
								toUpdate = t;
								break;
							}
						}
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
     * Method used to delete an element.
     * The element is filter by its id.
     */
    @Override
    public boolean delete(T t) {
    	T[] newList = null;
    	int idToFind = 0;
    	boolean deleted = false;
    	
    	if (this.myArray != null && this.myArray.length > 0) {
    		if (this.myUtil != null) {
    			try {
					Field field = this.myUtil.getTheClass().getDeclaredField(Constants.ID + this.myUtil.getClassName());
					if (field != null) {
						field.setAccessible(true);
						idToFind = (Integer)field.get(t);
						newList = Arrays.copyOf(this.myArray, this.myArray.length - 1);
						for (int i = 0; i < this.myArray.length; ++i) {
							if (((Integer)field.get(this.myArray[i])) == idToFind) {
								deleted = true;
							} else {
								newList[i] = this.myArray[i];
							}
						}
						if (deleted) {
							this.myArray = newList;
						}
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
    	int iCurrent = 0;
    	
    	if (this.myArray != null && this.myUtil != null) {
    		try {    				
    			Field field = this.myUtil.getTheClass().getDeclaredField(Constants.ID + this.myUtil.getClassName());
    			if (field != null) {
    				field.setAccessible(true);
    				for (T instance : this.myArray) {      					
    					iCurrent = (Integer)field.get(instance);
    					iReturn = ((iCurrent > iReturn) ? iCurrent : iReturn); 
    				}
    			}
    		} catch (Exception ex) {
    			ex.printStackTrace();
    		}
    	}
    	
    	return iReturn;
    }
    
    /**
     * Method used to get the array of elements.
     * @return The array of elements.
     */
    public T[] getAll() {
    	return this.myArray;
    }
}
