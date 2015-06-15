package Domain;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class VistaPrincipal extends JFrame {
	
	private JugarPartidaViewController jpvc;

	public VistaPrincipal(){
		jpvc = new JugarPartidaViewController();
	}
	
	
	public void tancar() {
	    	System.exit(0);
	}
	
	public void identificacioUsuari() {
		VistaUsuario vu = new VistaUsuario(this,jpvc);
		this.pack();
	}
	
	public void jugarPartida(){
		VistaPartida vp = new VistaPartida(this,jpvc);
	}
	
	
	public void seleccionarOpcion(){
		VistaSeleccionOpcion vso = new VistaSeleccionOpcion(this,jpvc);
	}
	
	public void consultarRanking(){
		VistaConsultarRanking vcr = new VistaConsultarRanking(this,jpvc);
	}
	
	public void partidaAcabada(){
		VistaPartidaAcabada vpa = new VistaPartidaAcabada(this,jpvc);
	}
	

	public void start() {
		this.setVisible(true);
		this.setMinimumSize( new Dimension(50,50) );
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(Color.black);
       VistaJugarPartida vys = new VistaJugarPartida(this,jpvc);
       this.pack();
       // seleccionaEspecialitat();
        this.setLocationRelativeTo(null);
	}
	

}

