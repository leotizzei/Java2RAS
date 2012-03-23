package parser.gui;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class XSLTFilter extends FileFilter {

	private final String xsl = "xsl";
	private final String xslt = "xslt";

	@Override
	public boolean accept(File f) {
		if (f.isDirectory()) {
			return true;
		}

		String extension =  getExtension(f);
		if (extension != null) {
			if (extension.equals( xsl ) || extension.equals( xslt)) 
				return true;
			else 
				return false;

		}

		return false;
	}

	@Override
	public String getDescription() {
		/*String extension =  getExtension();
	    String type = null;

	    if (extension != null) {
	        if (extension.equals( xsl) ||  extension.equals( xslt)) {
	            type = "XSLT File";
	        } 
	        
	    }
*/	    String type = "XSLT File";
		return type;
	}

	public String getExtension(File f) {
		String ext = null;
		String s = f.getName();
		int i = s.lastIndexOf('.');

		if (i > 0 &&  i < s.length() - 1) {
			ext = s.substring(i+1).toLowerCase();
		}
		return ext;
	}

	
}
