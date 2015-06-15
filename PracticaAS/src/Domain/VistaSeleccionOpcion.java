package Domain;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class VistaSeleccionOpcion extends JPanel{
	
	private JButton Sortir;
	private JButton JugarPartida;
	private JButton ConsultarRanking;
	private JugarPartidaViewController jpvc;
	private VistaPrincipal vp;
	
	public VistaSeleccionOpcion(VistaPrincipal v, JugarPartidaViewController j){
		vp = v;
		jpvc = j;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JPanel jp1 = new JPanel();
		JLabel h = new JLabel("             ");
		jp1.add(h);
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		this.setBackground(Color.DARK_GRAY);
		this.add(jp1);
		genBotons(this);
		JPanel aux3 = new JPanel();
	    JTextArea jtext = new JTextArea(3,30);
	    aux3.add(jtext);
	    this.add(aux3);
		 vp.add(this);
	     vp.pack();
		
		
	}

	
	 private void genBotons(JPanel jp) {
		 
		 	JPanel pb = new JPanel();
	    	pb.setLayout( new FlowLayout(FlowLayout.CENTER));
	    	//pb.setBackground(Color.DARK_GRAY);
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
	                vp.tancar();
	            }
	        });
	    	JugarPartida.addActionListener(new ActionListener() {

	            @Override
	            public void actionPerformed(ActionEvent ae) {
	            	vp.remove(jp);
	                vp.jugarPartida();
	            }
	        });
	    	ConsultarRanking.addActionListener(new ActionListener() {

	            @Override
	            public void actionPerformed(ActionEvent ae) {
	            	vp.remove(jp);
	                vp.consultarRanking();
	            }
	        });
	  }
}
