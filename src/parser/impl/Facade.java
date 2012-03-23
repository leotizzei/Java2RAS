/**
 * @author Leonardo Pondian Tizzei < tizzei<at>ic.unicamp.br  > 
 * 
 */

package parser.impl;



import java.io.File;
import java.io.IOException;

import parser.spec.prov.IParserMgt;



class Facade implements IParserMgt{

	public static void main(String args[]){
		File f = new File(".");
		System.out.println(f.getAbsolutePath());
		Parser p = new Parser();
		
		
		//p.fillInterfaceDefinitionProfile(componentFolder,args[1]);
		String compFolder = "/home/lsd/ra001973/workspace2/estudoDeCaso_oldPetstore/oldPetstore/com/";
		String template = "/home/lsd/ra001973/workspace2/Java2RAS/parser/parser/impl/abstractTemplateCosmos.xsl";
		String newFile = "/home/lsd/ra001973/workspace2/estudoDeCaso_oldPetstore/oldPetstore/oldPetstore.xml";
		//p.fillAbstractComponentProfile( compFolder );
		p.fillRASProfile(compFolder, template, newFile);
		
		
	}
	
	/**
	 * start the transformation
	 * @param baseDir a string that represents the absolute path to the component directory
	 * @param template the absolute path of the template that will be used in the transformation
	 * @throws IOException 
	 */
	public boolean fillRASFile(String baseDir, String template, String destinationFileName) throws IOException {
		boolean result = false;
		System.out.println("Running Java2RAS component...");
		if( ( baseDir != null) && ( template != null) && ( destinationFileName != null) ){
			File baseDirFile = new File( baseDir );
			File templateFile = new File( template );
			File destFile = new File( destinationFileName );

			boolean created = false;
			// if the destination file exists
			if( destFile.exists() ){
				// delete the file
				destFile.delete();
			}	
			// and create a new one
			created = destFile.createNewFile();
			
			
			// check if the files exist
			if( ( baseDirFile.exists() ) && ( templateFile.exists() ) && ( created ) ){
				Parser p = new Parser();
				System.out.println("The files specified exist");
				result = p.fillRASProfile(baseDir , template , destinationFileName);
			}
			else{
				if( !baseDirFile.exists() )
					System.err.println("Component directory "+baseDirFile.getAbsolutePath()+" does not exist");
				if( !templateFile.exists() )
					System.err.println("Template "+ templateFile.getAbsolutePath() +" does not exist");
				if( !created )
					System.err.println("The new file "+ destFile.getAbsolutePath()+" was not created");
			}
		}
		else{
			System.err.println(" Some parameter may be null or invalid");
		}
		return result;
	}

}
