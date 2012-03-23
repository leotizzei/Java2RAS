/**
 * @author Leonardo Pondian Tizzei < tizzei<at>ic.unicamp.br  > 
 * 
 */

package parser.impl;

import parser.spec.prov.IManager;


public class ComponentFactory {
	
	/**
	 * 
	 * create an instance of manager
	 */
	public static IManager createInstance(){
		
		IManager im = new Manager();
		return im;
	}
	
	
	
}
