/**
 * @author Leonardo Pondian Tizzei < tizzei<at>ic.unicamp.br  > 
 * 
 */
package parser.impl;

import harsh.javatoxml.Java2XML;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

class Parser{
	
	/**
	 * this method only gets a list of all java files in the base directory and store their 
	 * absolute paths in a list. 
	 * @param baseDir a string that represents the absolute path to the component directory
	 * @param template the absolute path of the template that will be used in the transformation
	 * @return
	 */
	protected boolean fillRASProfile(String baseDir,String template, String destinationFileName) {
		File folder = new File(baseDir );
		
		if( folder.exists() ){
			
			//make a list of all java files
			List<String> javaFiles = new ArrayList<String>();
			String filter = ".java";
			this.searchJavaFiles( folder , javaFiles , filter );
			
			// start transformation 
			boolean result = this.transformation( baseDir , template , javaFiles, destinationFileName ) ;
			
			return result;
		}
		else{
			System.err.println("the component folder does not exist");
			return false;
		}	
	}
	
	
	/**
	 * this method extract meta-information on the files in the list and perform the 
	 * transformation from one xml into a RAS file, according to the template
	 * @param baseDir a string that represents the absolute path to the component directory
	 * @param template the absolute path of the template that will be used in the transformation
	 * @param javaFiles a list of all java files in the base directory
	 * @return
	 */
	private  boolean transformation(String baseDir,String template, List javaFiles, String destinationFileName) {
		boolean result;	
		//for all java files
		String[] args = new String[javaFiles.size()];
		for(int i=0;i<javaFiles.size();i++){
			//add to the string array
			args[i] = (String) javaFiles.get(i);
		}
		
		//extract metadata from all these java files and persist into output.xml
		Java2XML.main(args);
		System.out.println("Component metadata file created.");
			
		//create a xml RAS profile from the metadata created by the java2xml
		Transformation t = new Transformation();
		
		
		//check if the metadata file exists
		String metadata = new String( "./output.xml" ) ;
		File f = new File( metadata );
		result = f.exists();
		if( result ){
			System.out.println("output.xml exists");
			//fill the RAS profile informations using the metadata
			String compName = this.getComponentName( baseDir ) + ".xml";

			// run transformation
			t.transform( metadata , template, destinationFileName );
		}
		else
			System.out.println("output.xml does not exist");
		return result;
	

	}

	
	/**
	 * get the last component folder and return
	 * @param baseDir a string that represents the absolute path to the component directory 
	 * @return
	 */
	private String getComponentName(String baseDir){
		String[] names = baseDir.split("/");
		int last = names.length;
		last --;
		return names[last];
	}
	
	
	
	/**
	 * search recursively for java files
	 * @param f
	 * @param javaFiles
	 * @param filter
	 */
	private void searchJavaFiles(File f, List<String> javaFiles,String filter){
		if( ( f == null ) || ( !f.exists() ) )
			return;
		else{
			File[] files = f.listFiles();
			for(int i = 0 ; i < files.length ; i++ ) {
				//System.out.println(files[i].getAbsolutePath());
				if( files[i].isDirectory() )
					searchJavaFiles( files[i] , javaFiles , filter );
				else{
					if( files[i].getAbsolutePath().endsWith(filter)){
						//System.out.println(files[i].getAbsolutePath() );
						javaFiles.add(new String( files[i].getAbsolutePath() ) );
					}
				}
			}
		
		}
	}

	
}
