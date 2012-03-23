/**
 * @author Leonardo Pondian Tizzei < tizzei<at>ic.unicamp.br  > 
 * 
 */
package parser.impl;

import java.io.File;


class Transformation {

	/**
	 * this method call the xalan library to perform the transformation
	 * @param metadata the absolute path of the file that will be transformed. For example, one 
	 * valid string is '/home/lsd/user/br/compA/metadata.xml' 
	 * @param rasProfile the absolute path of the file that will be the result of the transformation
	 * @param template the absolute path of the template that will be used in the transformation
	 * @return if any parameter is null or if the metadata file doesn't exists return false, otherwise
	 * return true
	 */
	protected boolean transform(String metadata,String template, String rasProfile){
		if( ( metadata != null ) && ( rasProfile != null) && ( template != null )){
			File metaFile = new File( metadata );
			
			//check if metadata exists
			if( ( metaFile.exists() ) && ( template != null)){
				System.out.println("metadata="+metadata+"\ntemplate="+template+"\nrasProfile="+rasProfile);
				
				// setup the parameters
				String[] param = {"-IN" , metadata , "-XSL" , template , "-OUT",rasProfile};
				
				// run the transformation 
				org.apache.xalan.xslt.Process.main( param);
				System.out.println("Transformation complete!");
				return true;
			}
			else{
				System.err.println("Transformation incomplete: metadata file does not exist");
				return false;
			}
		}
		else{
			System.err.println("Transformation incomplete: either metadata or RAS Profile is null");
			return false;
		}
	}

}
