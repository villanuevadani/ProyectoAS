package Domain;


import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;




public class VistaPrincipal extends JFrame {
	
	
	private static VistaPrincipal instance;

	private VistaPrincipal(){}
	
	public static VistaPrincipal getInstance(){
		if(instance == null) {
			instance = new VistaPrincipal();
		}
		return instance;
	}
	
	
	public void tancar() {
	    	System.exit(0);
	}

	public void start() {
		this.setVisible(true);
		this.setMinimumSize( new Dimension(50,50) );
        this.setResizable(false);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
       VistaJugarPartida vs = new VistaJugarPartida();
       this.pack();
       // seleccionaEspecialitat();
        this.setLocationRelativeTo(null);
	}
	

}

