/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.ebenus.dao.impl;

import com.cours.ebenus.dao.ConnectionHelper;
import com.cours.ebenus.dao.DataSourceSingleton;
import com.cours.ebenus.dao.IDao;
import com.cours.ebenus.dao.annotations.FetchChild;
import com.cours.ebenus.dao.annotations.FieldName;
import com.cours.ebenus.dao.annotations.PrimaryKey;
import com.cours.ebenus.dao.annotations.TableName;
import com.cours.ebenus.dao.annotations.UpdateDate;
import com.cours.ebenus.dao.annotations.CreationDate;
import com.cours.ebenus.dao.entities.Utilisateur;
import com.cours.ebenus.utils.Constants;
import com.cours.ebenus.utils.GenericSQLObjectUtil;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ElHadji
 * @param <T>
 */
public abstract class AbstractDao<T> implements IDao<T> {

	protected GenericSQLObjectUtil<T> myUtil = null;
	protected String tableName = null;

    public AbstractDao(Class<T> myClass) {
        this.myUtil = new GenericSQLObjectUtil<T>(myClass);
        Annotation annotation = this.myUtil.getTheClass().getAnnotation(TableName.class);
        if (annotation != null) {
    		TableName tAnnotation = (TableName)annotation;
    		this.tableName = tAnnotation.name();
    	}
    }

    /**
     * Return the list of all T
     */
    @Override
    public List<T> findAll() {
        List<T> toReturn = new ArrayList<T>();
        PreparedStatement statement = null;
        ResultSet results = null;
        Connection connection = null;
        
        try {
        	connection = DataSourceSingleton.getInstance().getConnection();
        	String requete = String.format(Constants.SELECT_ALL, this.tableName);
            statement = connection.prepareStatement(requete);
            statement.execute();
            results = statement.getResultSet();
            if (results != null) {
                toReturn = convertToList(results);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
        	ConnectionHelper.closeSqlResources(connection, statement, results);
        }
        return toReturn;            
    }
    
    private List<T> convertToList(ResultSet set) {
        List<T> toReturn = new ArrayList<T>();
        
        if (set != null) {
            try {
                while (set.next()) {
                    T instance = createInstance(this.myUtil.getTheClass(), set);
                    if (instance != null) {
                        toReturn.add(instance);
                    }
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return toReturn;
    }
    
    private T createInstance(Class<T> theClass, ResultSet set) {
        T instance = null;
        Object toSet = null;
        
        if(set != null) {
            try {
                instance = theClass.newInstance();
                for(Field field : theClass.getDeclaredFields()) {
                	Annotation annotation = field.getAnnotation(FetchChild.class);
                	if (annotation != null) {
                		FetchChild fa = (FetchChild)annotation;
                		Object subInstance = createInstance(fa.entity(), set);
                		field.setAccessible(true);
                		field.set(instance, subInstance);
                	} else {
                		Annotation subField = field.getAnnotation(FieldName.class);
                		if (subField != null) {
                			FieldName fn = (FieldName) subField;
                			toSet = set.getObject(fn.name());
                		} else {
                			toSet = set.getObject(field.getName());
                		}
                		this.myUtil.fillField(theClass, instance, field.getName(), toSet);
                	}
                }
            } catch(Exception ex) {
                ex.printStackTrace();
            }
        }
        return instance;
    }

    /**
     * Returns the instance of T with the id.
     */
    @Override
    public T findById(int id) {
    	T instance = null;
    	List<T> all = null;
    	PreparedStatement ps = null;
    	ResultSet result = null;
    	Connection connection = null;
    	
    	if (this.myUtil != null) {
            try {
            	connection = DataSourceSingleton.getInstance().getConnection();
                String requete = String.format(Constants.SELECT_WHERE_PARAMETER, this.tableName, Constants.ID + this.myUtil.getClassName(), id);
                ps = connection.prepareStatement(requete);
                this.myUtil.fillPreparedStatement(ps, Constants.ID + this.myUtil.getClassName(), id, 1);
                ps.execute();
                result = ps.getResultSet();
                all = convertToList(result);
                if (all != null && all.size() > 0) {
                    instance = all.get(0);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
            	ConnectionHelper.closeSqlResources(connection, ps, result);
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
    	List<T> all = null;
    	PreparedStatement ps = null;
    	ResultSet result = null;
    	Connection connection = null;
        
    	if (this.myUtil != null) {
            try {
            	connection = DataSourceSingleton.getInstance().getConnection();
                String requete = String.format(Constants.SELECT_WHERE_PARAMETER, this.tableName, criteria, valueCriteria.toString());
                ps = connection.prepareStatement(requete);
                this.myUtil.fillPreparedStatement(ps, criteria, valueCriteria, 1);
                ps.execute();
                result = ps.getResultSet();
                all = convertToList(result);
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
            	ConnectionHelper.closeSqlResources(connection, ps, result);
            }
    	}
    	return all;
    }
    
    public List<T> findByCriteria(String request, String[] criterias, Object[] values) {
    	List<T> all = null;
    	PreparedStatement ps = null;
    	ResultSet result = null;
    	Connection connection = null;
        
    	if (this.myUtil != null && values != null) {
            try {
            	connection = DataSourceSingleton.getInstance().getConnection();
            	String requestFormatted = String.format(request, (Object[])criterias);
            	ps = connection.prepareStatement(requestFormatted);
                for (int i = 0; i < values.length; ++i) {
                	ps.setObject(i + 1, values[i]);
                }
                ps.execute();
                result = ps.getResultSet();
                all = convertToList(result);
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
            	ConnectionHelper.closeSqlResources(connection, ps, result);
            }
    	}
    	return all;
    }
    
    /**
     * Method used to find by criteria using request
     * @param request The request to execute
     * @param values The parameters values
     * @return A list of element if ok, null otherwise
     */
    public List<T> findByCriteria(String request, Object[] values) {
    	List<T> all = null;
    	PreparedStatement ps = null;
    	ResultSet result = null;
    	Connection connection = null;
        
    	if (this.myUtil != null && values != null && values.length > 0) {
            try {
                connection = DataSourceSingleton.getInstance().getConnection();
                ps = connection.prepareStatement(request);
                for (int i = 0; i < values.length; ++i) {
                	ps.setObject(i + 1, values[i]);
                }
                ps.execute();
                result = ps.getResultSet();
                all = convertToList(result);
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
            	ConnectionHelper.closeSqlResources(connection, ps, result);
            }
    	}
    	return all;
    }

    /**
     * Add a T element in the list. 
     * @return The element if ok, null otherwise;
     */
    @Override
    public T create(T t) {
    	T toCreate = null;
    	PreparedStatement ps = null;
    	Connection connection = null;
    	String primaryKey = "";
    	
        if (t != null) {
            if (this.myUtil != null) {        			
                try {
                	connection = DataSourceSingleton.getInstance().getConnection();
                    String requete = constructInsertQuery();
                    ps = connection.prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
                    for (Field field : this.myUtil.getTheClass().getDeclaredFields()) {
                    	field.setAccessible(true);
                    	Annotation annotation = field.getAnnotation(CreationDate.class);
                        if (annotation != null) {
                        	field.set(t, new Date());
                        }
                        annotation = field.getAnnotation(UpdateDate.class);
                        if (annotation != null) {
                        	field.set(t, new Date());
                        }  
                        annotation = field.getAnnotation(PrimaryKey.class);
                        if (annotation != null) {
                        	primaryKey = field.getName();
                        }
                    }
                    this.myUtil.fillPreparedStatement(ps, t);
                    ps.execute();
                    ResultSet rs = ps.getGeneratedKeys();
                    if (rs.next()) {
                    	Field field = this.myUtil.getTheClass().getDeclaredField(primaryKey);
                    	field.setAccessible(true);
                    	if (field != null) {
                    		field.set(t, rs.getInt(1));
                    	}
                    }
                    toCreate = t;
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } finally {
                	ConnectionHelper.closeSqlResources(connection, ps, null);
                }
            }
        }
        return toCreate;
    }
    
    /**
     * Method used to construct a prepared statement query with the fields of the object
     * @return The prepared statement query
     */
    private String constructInsertQuery() {
        StringBuilder sb = new StringBuilder(String.format(Constants.INSERT_INTO, this.tableName));
        Field[] fields = this.myUtil.getTheClass().getDeclaredFields();
        
        for(Field field : fields) {
        	Annotation annotation = field.getAnnotation(PrimaryKey.class);
        	if (annotation == null) {
            	annotation = field.getAnnotation(FetchChild.class);
            	if (annotation != null) {
            		FetchChild fc = (FetchChild)annotation;
            		sb.append(fc.foreignKey());
            	} else {
            		sb.append(field.getName());	
            	}
        		sb.append(",");
        	}
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(") VALUES(");
        for (int i = 0; i < fields.length; ++i) {
        	Annotation annotation = fields[i].getAnnotation(PrimaryKey.class);
        	if (annotation == null) {
		        sb.append("?");
		        if (i < fields.length - 1) {
		            sb.append(",");
		        } else {
		            sb.append(");");
		        }
        	}
        }      
        return sb.toString();
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
    	PreparedStatement ps = null;
    	Connection connection = null;
    	
    	if (t != null) {
            if (this.myUtil != null) {
                try {
                	connection = DataSourceSingleton.getInstance().getConnection();
                    Field field = this.myUtil.getTheClass().getDeclaredField(Constants.ID + this.myUtil.getClassName());
                    if (field != null) {
                        field.setAccessible(true);
                        Annotation annotation = field.getAnnotation(UpdateDate.class);
                        if (annotation != null) {
                        	field.set(t, new Date());
                        }
                        idToFind = (Integer)field.get(t);
                        String requete = constructUpdateQuery();
                        ps = connection.prepareStatement(requete);
                        this.myUtil.fillPreparedStatement(ps, t);
                        this.myUtil.fillPreparedStatement(ps, field.getName(), idToFind, this.myUtil.getTheClass().getDeclaredFields().length);
                        ps.execute();
                        toUpdate = t;
                    }         
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } finally {
                	ConnectionHelper.closeSqlResources(connection, ps, null);
                }
            }
    	}
    	return toUpdate;
    }
    
    /**
     * Method used to construct a prepared statement query with the fields of the object
     * @return The prepared statement query
     */
    private String constructUpdateQuery() {
        StringBuilder sb = new StringBuilder(String.format(Constants.UPDATE_QUERY, this.tableName));
        Field[] fields = this.myUtil.getTheClass().getDeclaredFields();
        
        for(Field field : fields) {
        	Annotation annotation = field.getAnnotation(PrimaryKey.class);
        	if (annotation == null) {
        		annotation = field.getAnnotation(FetchChild.class);
        		if (annotation != null) {
        			FetchChild fc =(FetchChild)annotation;
        			sb.append(fc.foreignKey());
        		} else {
        			sb.append(field.getName());
        		}
        		sb.append(" = ?,");
        	}
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(" WHERE ");
        sb.append(Constants.ID + this.myUtil.getClassName());
        sb.append(" = ?;");  
        return sb.toString();
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
    	PreparedStatement ps = null;
    	Connection connection = null;
    	
    	if (t != null) {
            if (this.myUtil != null) {
                try {
                    Field fToFind = this.myUtil.getTheClass().getDeclaredField(Constants.ID + this.myUtil.getClassName());
                    if (fToFind != null) {
                        fToFind.setAccessible(true);
                        idToDelete = (Integer)fToFind.get(t);
                        String requete = constructDeleteQuery();
                        connection = DataSourceSingleton.getInstance().getConnection();
                        ps = connection.prepareStatement(requete);
                        this.myUtil.fillPreparedStatement(ps, Constants.ID + this.myUtil.getClassName(), idToDelete, 1);
                        ps.execute();
                        deleted = true;
                    }
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } finally {
                	ConnectionHelper.closeSqlResources(connection,ps, null);
                }
            }
    	}
        return deleted;
    }
    
    protected String constructDeleteQuery() {
        StringBuilder sb = new StringBuilder(String.format(Constants.DELETE_QUERY, this.tableName));

        sb.append(Constants.ID + this.myUtil.getClassName());
        sb.append(" = ?;");
        
        return sb.toString();
    }
    
    protected String constructDeleteQuery(String className) {
        StringBuilder sb = new StringBuilder(String.format(Constants.DELETE_QUERY, this.tableName));

        sb.append(Constants.ID + className);
        sb.append(" = ?;");
        
        return sb.toString();
    }
}
