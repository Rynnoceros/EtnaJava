/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.calcul;

import java.util.Random;

/**
 *
 * @author elhad
 */
public class Calculation implements ICalculation {

    @Override
    public int addition(int value1, int value2) {
        return value1 + value2;
    }

    /**
     * Initialise un tableau d'entier de taille "taille" avec des valeurs aléatoires.
     */
    @Override
    public int[] initMyArray(int taille) {
    	
    	if (taille > 0) {
    		int[] tableau = new int[taille];
    		Random rand = new Random();
    		for (int i = 0; i < taille; ++i) {
    			tableau[i] = rand.nextInt();
    		}
    		return tableau;
    	}
    	
        return null;
    }

    /**
     * Fonction de tri d'un tableau d'entier
     */
    @Override
    public int[] sortMyArray(int[] arrayToSort) {
        int[] arraySorted = null;
        int save = 0;
        
        if (arrayToSort != null) {
        	arraySorted = arrayToSort.clone();
        	for (int i = 0; i < arraySorted.length; ++i) {
        		for (int j = i + 1; j < arraySorted.length; ++j) {
        			if (arraySorted[i] > arraySorted[j]) {
        				save = arraySorted[i];
        				arraySorted[i] = arraySorted[j];
        				arraySorted[j] = save;
        			}
        		}
        	}
        }
        
        return arraySorted;
    }

    /**
     * Méthode permettant de calculer le factoriel d'un nombre de manière itérative
     */
    @Override
    public int factorielItterative(int number) {
        int factoriel = 1;
        
        for (int i = 1; i <= number; ++i) {
        	factoriel *= i;
        }
        
        return factoriel;
    }

    /**
     * Méthode permettant de calculer le factoriel d'un nombre de manière récursive
     */
    @Override
    public int factorielRecursive(int number) {
        // si n est inférieur à 1, on renvoie 1 sinon on renvoit l'appel de la fonction avec n - 1 multiplié par n
    	if (number <= 0) {
    		return 1;
    	} else {
    		return number * factorielItterative(number - 1);
    	}
    }

    /**
     * renvois 0 si les deux chaines de caractères sont identiques, 1 si la
     * premiere chaine est supérieur à la seconde chaine (en terme de code
     * ASCII), -1 si la premiere chaine est inférieur à la seconde chaine (en
     * terme de code ASCII)
     *
     * @param firstChaine
     * @param secondeChaine
     * @return result
     */
    @Override
    public int compareChaines(String firstChaine, String secondeChaine) {
        int result = 0;
       
        if (firstChaine != null) {
        	if (secondeChaine == null) {
        		result = 1;
        	} else {        		
        		char [] firstChars = firstChaine.toCharArray();
        		char [] secondChars = secondeChaine.toCharArray();
        		
        		if (firstChaine.length() > 0) {        			
        			for (int i = 0; i < firstChaine.length(); ++i) {
        				if (i < secondeChaine.length()) {
        					if ((result = compareChars(firstChars[i], secondChars[i])) != 0) {
        						break;
        					}
        				} else {
        					result = 1;
        				}
        			}
        			if (result == 0 && secondeChaine.length() > firstChaine.length()) {
        				result = -1;
        			}
        		} else {
        			if (secondeChaine.length() > 0) {
        				result = -1;
        			}	
        		}
        	}
        } else {
        	if (secondeChaine != null) {
        		result = -1;
        	}
        }
        
        return result;
    }
    
    /**
     * Renvoie 0 si les 2 caractères sont identiques, -1 si le premier caractère est avant
     * le second et 1 si le premier caractère est après le suivant
     * @param firstChar
     * @param secondChar
     * @return
     */
    private int compareChars(char firstChar, char secondChar) {
    	int result = 0;
    	
    	if (firstChar < secondChar) {
    		result = -1;
    	} else if (firstChar > secondChar) {
    		result = 1;
    	}
    	
    	return result;
    }

    /**
     * renvois 0 si le nombre est égale à 0, 1 s’il est pair et positif, 2 s’il
     * est négatif et paire, 3 s’il est impair et positif et 4 s’il est négatif
     * et impair
     *
     * @param chaine
     * @return result
     */
    @Override
    public int verifyParite(String chaine) {
        int result = -1;
        int iToVerify = 0;
        
        try {
        	iToVerify = Integer.parseInt(chaine);
        	if (iToVerify == 0) {
        		result = 0;
        	} else if (iToVerify < 0) {
        		if (iToVerify % 2 == 0) {
        			result = 2;
        		} else {
        			result = 4;
        		}
        	} else if (iToVerify > 0) {
        		if (iToVerify % 2 == 0) {
        			result = 1;
        		} else {
        			result = 3;
        		}
        	}
        } 
        catch (NumberFormatException ex) {
        	// We do nothing
        }
        
        return result;
    }

    /**
     * Calcul le nombre magique d'un tableau d'entier
     */
    @Override
    public int nombreMagique(int[] array) {
    	if (array != null && array.length > 0) {    		
    		int min = Integer.MAX_VALUE;
    		int max = Integer.MIN_VALUE;
    		
    		for (int i = 0; i < array.length; ++i) {
    			if (array[i] < min) {
    				min = array[i];
    			}
    			if (array[i] > max) {
    				max = array[i];
    			}
    		}
    		
    		return (min + max) / 2;
    	}
    	
    	return 0;
    }
}
