/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etna.mypenelope.core;

/**
 * Module loader class
 * @author soubri_j/martin_m
 */
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.jar.Manifest;
import java.util.jar.JarFile;
import java.util.ArrayList;
import java.util.List;
import java.net.URL;
import java.net.URLClassLoader;
import java.security.AccessController;
import java.security.PrivilegedAction;

public class ModuleLoader {
    private static List<URL> urls = new ArrayList<URL>();
	 
    private static ClassLoader classLoader;
 
    /**
     * Load all modules and returns them.
     * @return The loaded modules list.
     */
    public static List<IModule> loadModules() {
        List<IModule> modules = new ArrayList<IModule>();
 
        List<String> classes = getModuleClasses();
 
        AccessController.doPrivileged(new PrivilegedAction<Object>() {
            @Override
            public Object run() {
                classLoader = new URLClassLoader(
                        urls.toArray(new URL[urls.size()]),
                        ModuleLoader.class.getClassLoader());
 
                return null;
            }
        });
        try {
            for (String c : classes) {
                try {
                    Class<?> moduleClass = Class.forName(c, true, classLoader);
                    if (IModule.class.isAssignableFrom(moduleClass)) {
                        Class<IModule> castedClass = (Class<IModule>) moduleClass;
                        IModule module = castedClass.newInstance();
                        modules.add(module);
                    }
                } catch (ClassNotFoundException e) {
                    LogManager.getInstance().log(e.getLocalizedMessage());
                } catch (InstantiationException e) {
                    LogManager.getInstance().log(e.getLocalizedMessage());
                } catch (IllegalAccessException e) {
                    LogManager.getInstance().log(e.getLocalizedMessage());
                }
            }
        } catch (NullPointerException e) {
            // TODO: handle exception
        }

        return modules;
    }
 
    /**
     * Get all module classes to load.
     * First list all files of module folder
     * Then for each jar it extracts manifest file to get moduleClassName
     * @return String list containing modules classes.
     */
    private static List<String> getModuleClasses() {
        List<String> classes = new ArrayList<String>();
 
        File[] files = new File(Core.getInstance().getApplicationFolder() + "/modules/").listFiles(new ModuleFilter());
        try {
            for (File f : files) {
                JarFile jarFile = null;

                try {

                    jarFile = new JarFile(f);

                    Manifest manifest = jarFile.getManifest();  
                    if (manifest != null) {
                        String moduleClassName = manifest.getMainAttributes().getValue("Module-Class");
                        if (moduleClassName != null) {		                	
                            classes.add(moduleClassName);
                            urls.add(f.toURI().toURL());	
                        } else {
                            LogManager.getInstance().log("No Module-Class variable found in manifest file for " + jarFile.getName());
                        }
                    } else {
                        LogManager.getInstance().log("No manifest file found for " +jarFile.getName());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (jarFile != null) {
                        try {
                            jarFile.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        } catch (NullPointerException e) {
            // TODO: handle exception
        }
        return classes;
    }
 
    /**
     * Filter used to only list jar files.
     *
     * @author soubri_j/martin_m
     */
    private static class ModuleFilter implements FileFilter {
        @Override
        public boolean accept(File file) {
            return file.isFile() && file.getName().toLowerCase().endsWith(".jar");
        }
    }
}
