package parser.gui;
import java.awt.Rectangle;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import parser.impl.ComponentFactory;
import parser.spec.prov.IManager;
import parser.spec.prov.IParserMgt;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;

/**
 * An example which shows off a functional simple text editor.  Includes a variety of events.
 */
public class SimpleTextEditor extends JFrame {

	private javax.swing.JPanel jContentPane = null;

	private javax.swing.JButton jButton = null;

	private javax.swing.JFileChooser jFileChooser = null; //  @jve:visual-info  decl-index=0 visual-constraint="582,36"

	private javax.swing.JFileChooser jDirectoryChooser = null;
	
	private static final String title = "Java2RAS";

	private JButton jButtonComponent = null;

	private JButton jButtonRun = null;

	private JLabel jLabel = null;

	private JLabel jLabel1 = null;

	private JLabel jLabel2 = null;

	private JButton jButtonFilename = null;

	private JLabel jLabel3 = null;

	private JTextField jTextField = null;

	private JTextField jTextField1 = null;

	private JTextField jTextField2 = null;

	/**
	 * This method initializes 
	 * 
	 */
	public SimpleTextEditor() {
		super();
		initialize();
	}

	/**
	 * This method initializes jButtonComponent	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonComponent() {
		if (jButtonComponent == null) {
			jButtonComponent = new JButton();
			jButtonComponent.setBounds(new Rectangle(122, 199, 234, 33));
			jButtonComponent.setText("Choose component folder");
			jButtonComponent.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					loadDirectory( jTextField1 );
				}
			});
			
		}
		return jButtonComponent;
	}

	/**
	 * This method initializes jButtonRun	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton2() {
		if (jButtonRun == null) {
			jButtonRun = new JButton();
			jButtonRun.setBounds(new Rectangle(175, 408, 133, 29));
			jButtonRun.setText("Run Java2RAS");
			jButtonRun.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if( ( jTextField1 != null ) && ( jTextField != null ) && ( jTextField2 != null ) )
						runJava2RAS(jTextField1.getText(), jTextField.getText(), jTextField2.getText());
					else{
						String msg = "Some parameter may be either invalid or null";
						JOptionPane.showMessageDialog(jButtonRun, msg );
						
					}
				}

				
			});
		}
		return jButtonRun;
	}

	private void runJava2RAS(String baseDir, String template, String destinationFilename) {
		IManager imanager = ComponentFactory.createInstance();
		IParserMgt iparser = (IParserMgt) imanager.getProvidedInterface("IParserMgt");
		boolean res;
		try {
			System.out.println("Running Java2RAS...");
			/*baseDir = "/home/lsd/ra001973/workspace2/adapterCaseStudy/petstore2_0ea2_jar/com/";
			template = "/home/lsd/ra001973/workspace2/Java2RAS/parser/parser/impl/concreteTemplate.xsl";
			destinationFilename = "/home/lsd/ra001973/coisas/petstore201.xml";*/
			res = iparser.fillRASFile(baseDir, template , destinationFilename);
//			boolean res = true;
			System.out.println("Execution " + res);
			String display = null;
			if( res )
				display = "Congratulations! The transformation was done successfully!";
			else
				display = "It wasn't possible to do the transformation.";
			System.out.println(display);
			JOptionPane.showMessageDialog(jButtonRun, display);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
	
	
	/**
	 * This method initializes jButtonFilename	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton1() {
		if (jButtonFilename == null) {
			jButtonFilename = new JButton();
			jButtonFilename.setBounds(new Rectangle(121, 311, 231, 35));
			jButtonFilename.setText("Choose destination filename");
			jButtonFilename.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					loadFile( jTextField2 );
				}
			});
		}
		return jButtonFilename;
	}

	/**
	 * This method initializes jTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField() {
		if (jTextField == null) {
			jTextField = new JTextField();
			jTextField.setBounds(new Rectangle(77, 138, 386, 22));
		}
		return jTextField;
	}

	/**
	 * This method initializes jTextField1	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField1() {
		if (jTextField1 == null) {
			jTextField1 = new JTextField();
			jTextField1.setBounds(new Rectangle(61, 244, 401, 20));
		}
		return jTextField1;
	}

	/**
	 * This method initializes jTextField2	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField2() {
		if (jTextField2 == null) {
			jTextField2 = new JTextField();
			jTextField2.setBounds(new Rectangle(92, 352, 371, 21));
		}
		return jTextField2;
	}

	public static void main(String[] args) {
		SimpleTextEditor ste = new SimpleTextEditor();
		ste.show();
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private javax.swing.JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel3 = new JLabel();
			jLabel3.setBounds(new Rectangle(11, 351, 78, 22));
			jLabel3.setText("destination:");
			jLabel2 = new JLabel();
			jLabel2.setBounds(new Rectangle(13, 244, 45, 15));
			jLabel2.setText("folder:");
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(8, 138, 66, 21));
			jLabel1.setText("template:");
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(163, 18, 143, 47));
			jLabel.setFont(new Font("Nimbus Mono L", Font.BOLD, 30));
			jLabel.setDisplayedMnemonic(KeyEvent.VK_UNDEFINED);
			jLabel.setText("JAVA2RAS");
				
			jContentPane = new javax.swing.JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBorder(javax.swing.BorderFactory.createEmptyBorder(
					5, 5, 5, 5));
			jContentPane.add(getJButton(), null);
			jContentPane.add(getJButtonComponent(), null);
			jContentPane.add(getJButton2(), null);
			jContentPane.add(jLabel, null);
			jContentPane.add(jLabel1, null);
			jContentPane.add(jLabel2, null);
			jContentPane.add(getJButton1(), null);
			jContentPane.add(jLabel3, null);
			jContentPane.add(getJTextField(), null);
			jContentPane.add(getJTextField1(), null);
			jContentPane.add(getJTextField2(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(480, 481);
		this.setContentPane(getJContentPane());
		this.setTitle(title);
		this.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
				doExit();
			}
		});

	}

	/**
	 * This method initializes jButton
	 * 
	 * @return javax.swing.JButton
	 */
	private javax.swing.JButton getJButton() {
		if (jButton == null) {
			jButton = new javax.swing.JButton();
			jButton.setText("Choose template file");
			jButton.setBounds(new Rectangle(123, 98, 234, 32));
			jButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					loadFile( jTextField );
				}
			});
		}
		return jButton;
	}

	/**
	 * This method initializes jFileChooser
	 * 
	 * @return javax.swing.JFileChooser
	 */
	private javax.swing.JFileChooser getJFileChooser() {
		if (jFileChooser == null) {
			jFileChooser = new javax.swing.JFileChooser();
			jFileChooser.setMultiSelectionEnabled(false);
			jFileChooser.setFileFilter(new XSLTFilter());
			System.out.println("Files and Directories");
		}
		
				
		return jFileChooser;
	}

	private JFileChooser getJDirectoryChooser(){
		if(jDirectoryChooser == null){
			jDirectoryChooser = new javax.swing.JFileChooser();
			jDirectoryChooser.setMultiSelectionEnabled(false);
			
			//jDirectoryChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			jDirectoryChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			
		}
		return jDirectoryChooser;
	}
	
	private void loadFile(JTextField jLabel) {
		int state = getJFileChooser().showOpenDialog(this);
		if (state == JFileChooser.APPROVE_OPTION) {
			File f = getJFileChooser().getSelectedFile();
			
			jLabel.setText( f.getAbsolutePath() );
			
			//setTitle(title);
		}
	}
	
	private void loadDirectory(JTextField jtextfield){
		int state = getJDirectoryChooser().showOpenDialog(this);
		if (state == JFileChooser.APPROVE_OPTION) {
			File f = getJDirectoryChooser().getSelectedFile();
			if( f.isDirectory() )
				jtextfield.setText( f.getAbsolutePath() );
			else{
				String msg = "Please select a directory, not a file";
				JOptionPane.showMessageDialog(jButtonRun, msg);
			}
				
			//setTitle(title);
		}
	}

	

	private void doExit() {
				
		System.exit(0);
	}
}  //  @jve:decl-index=0:visual-constraint="38,43"
