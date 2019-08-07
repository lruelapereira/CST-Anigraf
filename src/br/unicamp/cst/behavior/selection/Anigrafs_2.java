/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicamp.cst.behavior.selection;

import br.unicamp.cst.core.entities.Codelet;
import java.util.ArrayList;

/**
 *
 * @author lruel
 */
public interface Anigrafs_2 {
   /*
    * Selection mode 2, sets Anigrafs with Cartesian coordinates and edges
    */
    public double getX();
    public double getY();
    public ArrayList<String> getVEdgeNames();
}
