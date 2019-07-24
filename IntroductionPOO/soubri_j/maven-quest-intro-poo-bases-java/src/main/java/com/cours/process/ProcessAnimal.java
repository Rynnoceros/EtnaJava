/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.process;

import com.cours.entities.Animal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author elhad
 */
public class ProcessAnimal implements IProcessAnimal {

    private static final Log log = LogFactory.getLog(ProcessAnimal.class);
    private List<Animal> animals = null;
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private final String fileByName = "animauxParNom.txt";
    private final String fileByWeight = "animauxParPoids.txt";
    private final String fileById = "animauxParId.txt";
    private final String fileByColor = "animauxParCouleur.txt";


    @Override
    public List<Animal> loadAnimalsManually() {
        animals = new ArrayList<Animal>();

        try {        	
        	animals.add(new Animal(1, "Lion", 200, dateFormat.parse("23/12/1988"), "Marron", 4, true));
        	animals.add(new Animal(2, "Elephant", 700, dateFormat.parse("23/12/1978"), "Noir", 4, true));
        	animals.add(new Animal(3, "Tigre", 150, dateFormat.parse("23/12/1998"), "Blanc", 4, true));
        	animals.add(new Animal(4, "Requin", 10, dateFormat.parse("23/12/1978"), "Blanc", 0, true));
        	animals.add(new Animal(5, "Chat", 5, dateFormat.parse("23/12/2000"), "Noir", 4, true));
        	animals.add(new Animal(6, "Mouton", 25, dateFormat.parse("23/12/2001"), "Blanc", 4, false));
        	animals.add(new Animal(7, "Chevre", 35, dateFormat.parse("23/12/2012"), "Noir", 4, false));
        	animals.add(new Animal(8, "Poule", 1, dateFormat.parse("23/12/2009"), "Marron", 2, false));
        	animals.add(new Animal(9, "Porc", 20, dateFormat.parse("23/12/2003"), "Blanc", 4, false));
        	animals.add(new Animal(10, "Singe", 25, dateFormat.parse("23/12/2004"), "Marron", 4, false));
        	animals.add(new Animal(11, "Girafe", 175, dateFormat.parse("23/12/2013"), "Marron et noir", 4, false));
        }
        catch (Exception ex) {
        	ex.printStackTrace();
        }
        
        return animals;
    }

    @Override
    public List<Animal> loadAnimalsFile() {
    	String line = null;
    	Animal animal = null;
    	animals = new ArrayList<Animal>();
    	BufferedReader buffer = null;
    	
        try {
			FileReader fr = new FileReader("animaux.txt");
			buffer = new BufferedReader(fr);
			while ((line = buffer.readLine()) != null) {
				animal = readAnimal(line);
				if (animal != null) {
					animals.add(animal);
				}
			}
		} catch (FileNotFoundException e) {
			log.error("File not found");
			e.printStackTrace();
		} catch (IOException e) {
			log.error("Error reading file");
			e.printStackTrace();
		}
        finally {
        	if (buffer != null) {
        		try {
					buffer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
        	}
        }
        
        
        return animals;
    }
    
    /**
     * Read an animal from a line of a file
     * @param line the file line
     * @return an Animal if ok, null otherwise
     */
    private Animal readAnimal(String line) {
    	Animal animal = null;
    	String[] fields = null;
    	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    	
    	if (line != null && line.length() > 0) {
    		fields = line.split(",");
    		if (fields != null) {
    			try {
    				animal = new Animal(Integer.parseInt(fields[0].trim()),
    						fields[1].trim(),
    						Double.parseDouble(fields[2].trim()),
    						sdf.parse(fields[3].trim()),
    						fields[4].trim(),
    						Integer.parseInt(fields[5].trim()),
    						Boolean.parseBoolean(fields[6].trim()));
    			}
    			catch (Exception ex) {
    				log.error(String.format("Error reading anima from line : %s", line));
    			}
    		}
    	}
    	
    	return animal;
    }

    @Override
    public Double calculMoyennePoidsAnimaux() {
        double total = 0.0;
        int iCpt = 0;
        
        if (animals != null) {
        	for (Animal animal : animals) {
        		if (animal != null) {
        			total += animal.getPoids();
        			++iCpt;
        		}
        	}
        	if (iCpt > 0) {
        		total = total / iCpt;
        	}
        }
        
        return total;
    }

    @Override
    public Double calculEcartTypePoidsAnimaux() {
    	double poidsTotal = 0;
    	double moyenne = 0;
    	int iCpt = 0;
    	double result = 0.0;
    	
    	if (animals != null) {
    		for(Animal animal : animals) {
    			if (animal != null) {
    				poidsTotal += animal.getPoids() * animal.getPoids();
    				++iCpt;
    			}
    		}
    		if (iCpt > 0) {
    			poidsTotal = poidsTotal / iCpt;
    			moyenne = calculMoyennePoidsAnimaux();
    			moyenne = moyenne * moyenne;
    			result = Math.sqrt(poidsTotal - moyenne);
    		}
    	}
    	
        return result;
    }

    @Override
    public List<Animal> sortAnimalsById() {
    	if (animals != null) {
    		animals.sort(new Comparator<Animal>() {
				@Override
				public int compare(Animal o1, Animal o2) {
					if (o1.getIdAnimal() == o2.getIdAnimal()) {						
						return 0;
					} else if (o1.getIdAnimal() < o2.getIdAnimal()) {
						return -1;
					} else {
						return 1;
					}
				}
    		} );
    	}
    	
        return animals;
    }

    @Override
    public List<Animal> sortAnimalsByName() {
        if (animals != null) {
        	animals.sort(new Comparator<Animal>() {

				@Override
				public int compare(Animal o1, Animal o2) {
					return o1.getNom().compareTo(o2.getNom());
				}
        	
        	});
        }
        
        return animals;
    }

    @Override
    public List<Animal> sortAnimalsByWeight() {
        if (animals != null) {
        	animals.sort(new Comparator<Animal>() {

				@Override
				public int compare(Animal o1, Animal o2) {
					if (o1.getPoids() == o2.getPoids()) {						
						return 0;
					} else if (o1.getPoids() < o2.getPoids()) {
						return -1;
					} else {
						return 1;
					}
				}
        		
        	});
        }
        
        return animals;
    }

    @Override
    public List<Animal> sortAnimalsByColor() {
        if (animals != null) {
        	animals.sort(new Comparator<Animal>() {

				@Override
				public int compare(Animal o1, Animal o2) {
					return o1.getCouleur().compareTo(o2.getCouleur());
				}
        		
        	});
        }
        
        return animals;
    }

    @Override
    public void generateFileByName() {
    	sortAnimalsByName();
    	generateFile(fileByName);
    }

    @Override
    public void generateFileByWeight() {
    	sortAnimalsByWeight();
    	generateFile(fileByWeight);
    }
    
    @Override
    public void generateFileById() {
    	sortAnimalsById();
    	generateFile(fileById);
    }
    
    @Override
    public void generateFileByColor() {
    	sortAnimalsByColor();
    	generateFile(fileByColor);
    }
    
    private void generateFile(String fileName) {
    	FileWriter fw = null;
    	BufferedWriter buffer = null;
    	
    	try {
			fw = new FileWriter(fileName);
			if (fw != null) {
				buffer = new BufferedWriter(fw);
				if (buffer != null) {					
					if (animals != null) {
						for(Animal animal : animals) {
							buffer.write(animal.toString());
							buffer.newLine();
						}
					}
				}
			}
		} catch (IOException e) {
			log.error(String.format("File %s not found", fileName));
			e.printStackTrace();
		} finally {
    		try {
    			if (buffer != null) {
    				buffer.flush();
    				buffer.close();
    			}
    			if (fw != null) {
    				fw.close();
    			}    			    			
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
    	}
    }

    @Override
    public List<Animal> getAnimals() {
        return animals;
    }
}
