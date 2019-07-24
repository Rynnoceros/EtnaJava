package com.cours.ebenus.utils;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.function.Predicate;


public class GenericObjectUtil<T> {
	
	private Class<T> theClass; 
	
	/**
	 * Default constructor
	 * @param theClass Object class to fill
	 */
	public GenericObjectUtil(Class<T> theClass) {
		this.theClass = theClass;
	}
	    
    /**
     * Predicate used to filter by id
     * @param idToSearch Searched id
     * @return return true if id is equal to idToSearch, false otherwise
     */
	public Predicate<T> filterId(int idToSearch) {
    	return p -> equalsField(p, Constants.ID + theClass.getSimpleName(), (Integer)idToSearch);

    }
	
	/**
	 * Method used to get a comparator of id
	 * @return a comparator of id.
	 */
	public Comparator<T> compareId() {
		return new Comparator<T>() {
			int result = 0;
			
			/**
			 * Method used to compare 2 object of class T on their id.
			 */
			@Override
			public int compare(T o1, T o2) {
				try {					
					Field field = theClass.getDeclaredField(Constants.ID + theClass.getSimpleName());
					field.setAccessible(true);
					int id1, id2;
					if (field != null) {
						id1 = (Integer)field.get(o1);
						id2 = (Integer)field.get(o2);
						result = Integer.compare(id1, id2);
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				return result;
			}
		};
	}
	
	/**
	 * Method used to filter an element on a specified criteria
	 * @param criteria The criteria to filter
	 * @param valueCriteria Criteria's value
	 * @return true if criteria is equal to searched value, false otherwise
	 */
	public Predicate<T> filterByCriteria(String criteria, Object valueCriteria) {
		return p -> equalsField(p, criteria, valueCriteria);
	}
	
	
	public boolean equalsField(T element, String criteria, Object value) {
		Field field = null;
		Class<?> fieldClass = null;
		boolean toReturn = false;

		try {
			field = theClass.getDeclaredField(criteria);
			field.setAccessible(true);
			
			if (field != null) {
				fieldClass = field.getType();
				if (fieldClass == Boolean.class) {
					toReturn = ((Boolean)field.get(element) == (Boolean)value);
				} else if (fieldClass == Byte.class) {
					toReturn = ((Byte)field.get(element) == (Byte)value);
				} else if (fieldClass == Character.class) {
					toReturn = ((Character)field.get(element) == (Character)value);
				} else if (fieldClass == Short.class) {
					toReturn = ((Short)field.get(element) == (Short)value);
				} else if (fieldClass == Integer.class) {
					toReturn = ((Integer)field.get(element) == (Integer)value);
				} else if (fieldClass == Long.class) {
					toReturn = ((Long)field.get(element) == (Long)value);
				} else if (fieldClass == Float.class) {
					toReturn = ((Float)field.get(element) == (Float)value);
				} else if (fieldClass == Double.class) {
					toReturn = ((Double)field.get(element) == (Double)value);
				} else if (fieldClass == Date.class) {
					SimpleDateFormat formatter = new SimpleDateFormat(Constants.DATE_PATTERN);
					toReturn = formatter.format(field.get(element)).equals(formatter.format((String)value));
				} else {
					toReturn = ((String)field.get(element)).trim().equalsIgnoreCase((String)value);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return toReturn;
	}
    
    /**
     * Method used to fill a field
     * @param instance Instance of the object to fill 
     * @param fieldName The field name to fill
     * @param value The value to put in the field
     */
    public void fillField(T instance, String fieldName, String value) {
    	Field field = null;
    	Class<?> fieldClass = null;
    	
		try {
			if (value != null)
			{
				field = theClass.getDeclaredField(fieldName);
				if (field != null) {
					field.setAccessible(true);
					fieldClass = field.getType();					
					if (fieldClass == Boolean.class) {
						field.set(instance, Boolean.parseBoolean(value));
					} else if (fieldClass == Byte.class) {
						field.set(instance, Byte.parseByte(value));
					} else if (fieldClass == Character.class) {
						if (value.length() > 0) {						
							field.set(instance, value.charAt(0));
						}
					} else if (fieldClass == Short.class) {
						field.set(instance, Short.parseShort(value));
					} else if (fieldClass == Integer.class) {
						field.set(instance, Integer.parseInt(value));
					} else if (fieldClass == Long.class) {
						field.set(instance, Long.parseLong(value));
					} else if (fieldClass == Float.class) {
						field.set(instance, Float.parseFloat(value));
					} else if (fieldClass == Double.class) {
						field.set(instance, Double.parseDouble(value));
					} else if (fieldClass == Date.class) {
						SimpleDateFormat formatter = new SimpleDateFormat(Constants.DATE_PATTERN);
						field.set(instance, formatter.parse(value));
					} else {
						field.set(instance, value);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public Class<T> getTheClass() {
    	return theClass;
    }
    
    public String getClassName() {
    	return theClass.getSimpleName();
    }
}
