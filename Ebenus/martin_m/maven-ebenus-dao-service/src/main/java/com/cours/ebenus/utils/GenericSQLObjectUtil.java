package com.cours.ebenus.utils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.cours.ebenus.dao.annotations.PrimaryKey;
import com.cours.ebenus.dao.annotations.FetchChild;

import java.sql.Date;

public class GenericSQLObjectUtil<T> extends GenericObjectUtil<T> {    
    public GenericSQLObjectUtil(Class<T> theClass) {
        super(theClass);
    }
    
    public void fillField(Class<T> myClass, T instance, String fieldName, Object obj) {
    	Field field = null;
    	try {
    		if (obj != null) {
    			field = myClass.getDeclaredField(fieldName);
    			if (field != null) {
    				field.setAccessible(true);
    				field.set(instance, obj);
    			}
    		}
    	} catch (Exception ex) {
    		ex.printStackTrace();
    	}
    }
    
    /**
     * Method used to fill a field
     * @param instance Instance of the object to fill 
     * @param fieldName The field name to fill
     * @param set The resultset containing the value to put in the field
     */
    public void fillField(T instance, String fieldName, ResultSet set) {
    	Field field = null;
    	Class<?> fieldClass = null;
    	
        try {
            if (set != null)
            {
                field = theClass.getDeclaredField(fieldName);
                if (field != null) {
                    field.setAccessible(true);
                    fieldClass = field.getType();					
                    if (fieldClass == Boolean.class) {
                        field.set(instance, set.getBoolean(fieldName));
                    } else if (fieldClass == Byte.class) {
                        field.set(instance, set.getByte(fieldName));
                    } else if (fieldClass == Character.class) {						
                        field.set(instance, (char)set.getByte(fieldName));
                    } else if (fieldClass == Short.class) {
                        field.set(instance, set.getShort(fieldName));
                    } else if (fieldClass == Integer.class) {
                        field.set(instance, set.getInt(fieldName));
                    } else if (fieldClass == Long.class) {
                        field.set(instance, set.getLong(fieldName));
                    } else if (fieldClass == Float.class) {
                        field.set(instance, set.getFloat(fieldName));
                    } else if (fieldClass == Double.class) {
                        field.set(instance, set.getDouble(fieldName));
                    } else if (fieldClass == Date.class) {
                        field.set(instance, set.getDate(fieldName));
                    } else if (fieldClass == String.class) {
                    	field.set(instance, set.getString(fieldName));
                    } else {
                        Object subObject = fieldClass.newInstance();
                        Field subField = fieldClass.getDeclaredField(Constants.ID + fieldName.substring(0,1).toUpperCase() + fieldName.substring(1));
                        if (subField != null) {
                            subField.setAccessible(true);
                            subField.set(subObject, set.getObject("id" + fieldName));
                            field.set(instance, subObject);   	
                        }                    
                    }
                }
            }
        } catch (Exception e) {
        	// Do nothing
            //e.printStackTrace();
        }
    }
    
    public void fillPreparedStatement(PreparedStatement ps, String criteria, Object value, int parameterIndex)
    {
        if (ps != null) {
            try {
                Field field = theClass.getDeclaredField(criteria);
                Class<?> fieldClass = null;
                
                if (field != null) {
                    field.setAccessible(true);
                    fieldClass = field.getType();					
                    if (fieldClass == Boolean.class) {
                        ps.setBoolean(parameterIndex, (Boolean)value);
                    } else if (fieldClass == Byte.class) {
                        ps.setByte(parameterIndex, (Byte)value);
                    } else if (fieldClass == Character.class) {						
                        ps.setByte(parameterIndex, (Byte)value);
                    } else if (fieldClass == Short.class) {
                        ps.setShort(parameterIndex, (Short)value);
                    } else if (fieldClass == Integer.class) {
                        ps.setInt(parameterIndex, (Integer)value);
                    } else if (fieldClass == Long.class) {
                        ps.setLong(parameterIndex, (Long)value);
                    } else if (fieldClass == Float.class) {
                        ps.setFloat(parameterIndex, (Float)value);
                    } else if (fieldClass == Double.class) {
                        ps.setDouble(parameterIndex, (Double)value);
                    } else if (fieldClass == Date.class || fieldClass == java.util.Date.class) {
                        ps.setObject(parameterIndex, value);
                    } else if (fieldClass == String.class) {
                    	ps.setString(parameterIndex, (String)value);
                    }  else {
                    	field = fieldClass.getDeclaredField(Constants.ID + criteria.substring(0,1).toUpperCase() + criteria.substring(1));
                    	if (field != null) {
                    		field.setAccessible(true);
                    		ps.setObject(parameterIndex, field.get(value));
                    	}
                    }
                }
            } catch (Exception ex) {              
            	// Do nothing
                //e.printStackTrace();
            }
        }
    }
    
    public void fillPreparedStatement(PreparedStatement ps, T instance) {
        if (ps != null) {
            try {
                Field[] fields = theClass.getDeclaredFields();
                for (int i = 0; i < fields.length; ++i) {
                	fields[i].setAccessible(true);
                	Annotation annotation = fields[i].getAnnotation(PrimaryKey.class);
                	if (annotation == null) {
                		//fields[i].set(i, fields[i].get(instance));
                        fillPreparedStatement(ps, fields[i].getName(), fields[i].get(instance), i);	
                	}
                	annotation = fields[i].getAnnotation(FetchChild.class);
                	if (annotation != null) {
                		FetchChild fc = (FetchChild)annotation;
                		fillPreparedStatement(ps, fc.foreignKey(), fields[i].get(instance), i);
                	}
                }    
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
