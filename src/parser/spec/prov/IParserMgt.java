/**
 * @author Leonardo Pondian Tizzei < tizzei<at>ic.unicamp.br  > 
 * 
 */
package parser.spec.prov;

import java.io.IOException;


public interface IParserMgt {

	/**
	 * 
	 * @param baseDir the directory of the component. For example: a component placed in 
	 * '/home/lsd/user/br/compA/' whose package is 'br.compA', the correct string should
	 * be '/home/lsd/user/br'
	 * @param template the absolute path of the template that will be used in the transformation 
	 * @return
	 */	
	public boolean fillRASFile(String baseDir, String template, String destinationFileName) throws IOException;
	
}
