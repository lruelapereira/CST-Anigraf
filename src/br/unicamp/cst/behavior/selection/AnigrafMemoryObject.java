/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicamp.cst.behavior.selection;

import br.unicamp.cst.core.entities.Memory;
import br.unicamp.cst.core.entities.MemoryObject;

/**
 *
 * @author lruel
 */
public class AnigrafMemoryObject extends MemoryObject implements Memory{
        private volatile Double x; /////////////////////////////////////////////////////////
	private volatile Double y;
        
        public AnigrafMemoryObject() {
                x = 0.0d;
                y = 0.0d;
	}
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public synchronized Double getX() {
		return x;
	}


	public synchronized void setX(Double x) {
		this.x = x;
	}
    
	public synchronized Double getY() {
		return y;
	}


	public synchronized void setY(Double y) {
		this.y = y;
	}
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
}
