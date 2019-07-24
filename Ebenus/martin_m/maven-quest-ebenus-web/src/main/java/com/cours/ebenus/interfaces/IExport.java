/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.ebenus.interfaces;

import java.io.File;
import java.util.List;

/**
 *
 * @author soubri_j/martin_m
 */
public interface IExport<T> {
    File export(List<T> liste);
}
