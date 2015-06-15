package Domain;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class VistaSeleccionOpcion extends JPanel{
	
	private JButton Sortir;
	private JButton JugarPartida;
	private JButton ConsultarRanking;
	
	public VistaSeleccionOpcion(){
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		genBotons(this);
		 VistaPrincipal.getInstance().add(this);
	     VistaPrincipal.getInstance().pack();
		
		
	}

	
	 private void genBotons(JPanel jp) {
		 
		 	JPanel pb = new JPanel();
	    	pb.setLayout( new FlowLayout(FlowLayout.CENTER));
	    	JugarPartida = new JButton(" Jugar Partida ");
	    	pb.add(JugarPartida);
	    	jp.add(pb);
	    	ConsultarRanking = new JButton(" Consultar Ranking ");
	    	pb.add(ConsultarRanking);
	    	jp.add(pb);
	    	Sortir = new JButton(" Sortir ");
	    	pb.add(Sortir);
	    	jp.add(pb);
	    	Sortir.addActionListener(new ActionListener() {

	            @Override
	            public void actionPerformed(ActionEvent ae) {
	                VistaPrincipal.getInstance().tancar();
	            }
	        });
	    	JugarPartida.addActionListener(new ActionListener() {

	            @Override
	            public void actionPerformed(ActionEvent ae) {
	            	VistaPrincipal.getInstance().remove(jp);
	                VistaPrincipal.getInstance().jugarPartida();
	            }
	        });
	  }
}
